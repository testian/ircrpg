/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.common.npc.ai;

import ircrpg2.ai.Target;
import ircrpg2.core.Item;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.RPGException;

/**
 *
 * @author testi
 */
public class UseItem implements Target {
private RPGCharacter subject;
private RPGCharacter target;
private Item item;
private boolean satisfied;
    public UseItem(RPGCharacter subject, RPGCharacter target, Item item) {
        if (target == subject) throw new IllegalArgumentException("target and subject must not be equal");
        this.subject = subject;
        this.target = target;
        this.item = item;
        satisfied = false;
    }
    private void remove() {
        try {
        subject.setTarget(target);
        subject.giveItem(item);
        } catch (RPGException ex) {
            try {
        subject.getInventory().removeItem(item); } catch (RPGException ex2){subject.msg(ex2.getMessage());}
        }
    }
    public void followTarget() {
        try {
        subject.setTarget(target);
        subject.use(item);
        remove();
        satisfied = true;
        } catch (RPGException ex) {
        if (ex.getType() != RPGException.Type.ATTACK_PENDING && ex.getType() != RPGException.Type.USAGE_PENDING) {
        
        remove();
        
        satisfied = true;
        }
        }
    }

    public boolean related(Object o) {
        return o == subject || o == target || o == item;
    }

    public boolean satisfied() {
        return satisfied;
    }


}
