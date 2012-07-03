/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.common;


import ircrpg2.core.AttackBehaviour;
import ircrpg2.core.AttackBehaviour.AttackResult;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.RPGException;
import ircrpg2.core.Weapon;
import ircrpg2.core.WeaponFusion;

/**
 *
 * @author testi
 */
public class DefaultAttackBehaviour implements AttackBehaviour {


            public AttackResult attack(RPGCharacter attacker, RPGCharacter target) {
                int health = target.getHealth();
                try {
                attacker.setTarget(target);
                attacker.attack();
                int damage = health-target.getHealth();
                if (damage < 1) return AttackResult.NO_DAMAGE;
                else return AttackResult.SUCCESSFUL;}
                catch (RPGException ex) {
                if (ex.getType() == RPGException.Type.ATTACK_PENDING || ex.getType() == RPGException.Type.USAGE_PENDING) return AttackResult.IN_PROGRESS;
                else if (ex.getType() == RPGException.Type.OUT_OF_RANGE) return AttackResult.OUT_OF_RANGE;
                else return AttackResult.UNABLE;
                }
            }

            public AttackResult simulateAttack(RPGCharacter attacker, RPGCharacter target) {
                Weapon w1 = attacker.getCurrentWeapon();
                Weapon w2 = attacker.getSecondCurrentWeapon();
                Weapon w = new WeaponFusion(w1,w2);
                int damage = w.getMaxDamage();

                if (damage>target.getBody().getRealBlock()) {
                return AttackResult.SUCCESSFUL;
                }
                else {
                return AttackResult.NO_DAMAGE;
                }
                /*boolean attackable = attacker.attackable(target);
                if (attackable) return AttackResult.SUCCESSFUL;
                else
                return AttackResult.NO_DAMAGE;*/
            }

        
}
