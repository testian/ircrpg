/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ircrpg2.entities.ilandor.items;

import ircrpg2.core.CharacterState;
import ircrpg2.core.Destructive;
import ircrpg2.core.Library;
import ircrpg2.core.Position;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.RPGException;
import ircrpg2.core.Skill;
import ircrpg2.core.Util;
import ircrpg2.entities.ilandor.skills.Magier;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 *
 * @author testi
 */
public class Manazeitbombe {

    public void cast(final RPGCharacter s) throws RPGException {

        int hits = 0;
        final Position myP = s.getPosition();
        s.useMana(200);
        s.allMsg(s.getName() + " erzeugt eine Manazeitbombe. Zeit bis zur Explosion: 10 Minuten");
        new Timer().schedule(Util.tott(s.getWorld().entailTask(new Runnable() {

            public void run() {
                s.allMsg("Die Manabombe von " + s.getName() + " explodiert.");
                int hits = 0;

                Library l = s.getWorld().getLibrary();
                List<RPGCharacter> targets = new ArrayList<RPGCharacter>();
                targets.addAll(l.getNPCs());
                targets.addAll(l.getPlayers());
                for (RPGCharacter t : targets) {
                    if (t.getState() == CharacterState.DEAD) {
                        continue;
                    }
                    double distance = t.getPosition().getDistance(myP);
                    if (distance <= 100.0) {

                        double relDamage = 1.0 - distance / 100.0;
                        int absoluteDamage = (int) (360.0 * relDamage) + 40;
                        if (absoluteDamage > 0) {
                            s.attack(t, new Destructive() {

                                public DestructionType getType() {
                                    return Destructive.DestructionType.MAGIC;
                                }

                                public String getName() {
                                    return "Manabombe";
                                }
                            }, absoluteDamage);
                            if (s != t) hits++;
                        }
                    }


                }

                Skill m = s.getSkill(Magier.class);
                if (m != null) m.increase(hits);
            }
        })), 1000 * 10 * 60);


    }
}
