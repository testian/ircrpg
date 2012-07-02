/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.npc;

import ircrpg2.core.AssistBehaviour;
import ircrpg2.core.CharacterState;
import ircrpg2.core.NPC;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.RPGException;
import ircrpg2.entities.ilandor.items.WiederbelebungRune;
import ircrpg2.entities.ilandor.skills.Magier;

/**
 *
 * @author simulity
 */
public class Heiler {

    private WiederbelebungRune rune;

    public Heiler() {
    rune = new WiederbelebungRune();
    }

    public void init(NPC c) {
        c.increaseMaxMana(1000);
        c.increaseMana(1000);
        c.learnSkill(new Magier());
        
        try {
        c.getInventory().addItem(rune);
        } catch (RPGException ex) {
        throw new IllegalStateException(ex);
        }
        c.getNPCBehaviour().setAssistBehaviour(new AssistBehaviour() {

            public boolean assist(RPGCharacter subject, RPGCharacter target) {
                if (target.getState() == CharacterState.ALIVE) return false;
                try {
                subject.setTarget(target);
                int mana = subject.getMana();
                subject.use(rune);
                if (mana == subject.getMana()) return false;
                return true;
                } catch (RPGException ex){return false;}
            }


        });


    }
}
