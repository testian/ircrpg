/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.items;

import ircrpg2.core.Destructive;
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
public class Feuerkugel {

    private boolean loading;
    private long loadTime;

    public Feuerkugel() {
    loading = false;
    loadTime = 0;

    }

    public int cast(RPGCharacter s, RPGCharacter t) throws RPGException {
        if (t == null) throw new RPGException(RPGException.Type.NO_TARGET);

        if (!loading) {
        loading = true;
        loadTime = System.currentTimeMillis();
        s.allMsg(s.getName() + " lädt Feuerkugel auf.");
        return 0;
        }
        long load = System.currentTimeMillis()-loadTime;

        int manaUse = (int)(load/200);
        if (s.getMana()<manaUse) {
        manaUse = s.useRemainingMana();
        } else {
        s.useMana(manaUse);
        }

        int damage = manaUse*3;
        double distance = s.getPosition().getDistance(t.getPosition());
        if (distance > 40.0) return 0;

        double relativeDamage = 1.0-distance/40.0;
        damage = (int)(damage*relativeDamage*0.8+damage*0.2);

        
        if (damage < 1) return 0;
        s.attack(t, new Destructive() {

            public DestructionType getType() {
                return Destructive.DestructionType.MAGIC;
            }

            public String getName() {
                return "Feuerkugel";
            }

        }, damage);




        
            return damage/10+1;
        
    }
}
