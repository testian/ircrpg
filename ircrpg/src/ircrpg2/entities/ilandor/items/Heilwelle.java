/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.items;

//import ircrpg2.core.Destructive;
import ircrpg2.core.CharacterState;
import ircrpg2.core.Library;
import ircrpg2.core.Position;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.RPGException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author testi
 */
public class Heilwelle {


    public int cast(RPGCharacter s) throws RPGException {
        
        int hits = 0;
        Position myP = s.getPosition();
        s.useMana(100);
        s.allMsg(s.getName() + " wirkt Heilwelle.");

    Library l = s.getWorld().getLibrary();
        List<RPGCharacter> targets = new ArrayList<RPGCharacter>();
        targets.addAll(l.getNPCs());
        targets.addAll(l.getPlayers());
    for (RPGCharacter t : targets) {
    if (t == s) continue;
    if (t.getState() == CharacterState.DEAD) continue;
        double distance = t.getPosition().getDistance(myP);
        if (distance <= 50.0) {

            double relDamage = 1.0-distance/50.0;
            int absoluteDamage = (int)(180.0*relDamage)+20;
            if (absoluteDamage > 0) {
            /*s.attack(t, new Destructive() {

                        public DestructionType getType() {
                            return Destructive.DestructionType.MAGIC;
                        }

                        public String getName() {
                            return "Feuerwelle";
                        }

            }, absoluteDamage);*/
            int healing = s.getHealth();
            t.increaseHealth(absoluteDamage);
            healing = s.getHealth()-healing;
            if (healing>0) hits++;
            }
        }


    }
    return hits;
    }
}
