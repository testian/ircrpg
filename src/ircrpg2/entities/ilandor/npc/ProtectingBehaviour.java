/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.npc;

import ircrpg2.core.Destructive;
import ircrpg2.core.RPGCharacter;
import ircrpg2.entities.common.DefaultNPCBehaviour;
import ircrpg2.entities.common.npc.ai.FindAndKill;

/**
 *
 * @author testi
 */
public class ProtectingBehaviour extends DefaultNPCBehaviour {
private Class toProtect;

    public ProtectingBehaviour(Class toProtect) {
        this.toProtect = toProtect;
    }

    @Override
    protected void enemyAttackingFriendRemote(RPGCharacter attacker, RPGCharacter target, Destructive weapon, int damage, int dealtDamage) {
        super.enemyAttackingFriendRemote(attacker, target, weapon, damage, dealtDamage);
        if (toProtect.isInstance(target)) {
        targetStack().addTarget(new FindAndKill(getNpc(),attacker,this.getAttackBehaviour())); //Only for test purposes..
        targetStack().proceed();
        }
    }

}
