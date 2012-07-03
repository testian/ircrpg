/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.npc;

import ircrpg2.core.NPC;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.RPGException;
import ircrpg2.entities.common.DefaultAttackBehaviour;
import ircrpg2.entities.ilandor.items.BlitzaugenRune;
import ircrpg2.entities.ilandor.skills.Magier;

/**
 *
 * @author simulity
 */
public class BlitzaugenMagier {

    private BlitzaugenRune rune;

    public BlitzaugenMagier() {
    rune = new BlitzaugenRune();
    }

    public void init(NPC c) {
        c.increaseMaxMana(750);
        c.increaseMana(750);
        c.learnSkill(new Magier());
        
        try {
        c.getInventory().addItem(rune);
        } catch (RPGException ex) {
        throw new IllegalStateException(ex);
        }
        c.getNPCBehaviour().setAttackBehaviour(new DefaultAttackBehaviour() {

            @Override
            public AttackResult attack(RPGCharacter attacker, RPGCharacter target) {
                try {
                attacker.setTarget(target);
                int health = attacker.getHealth();
                attacker.use(rune);
                int damage = health - attacker.getHealth();
                if (damage < 1) return super.attack(attacker, target);
                return AttackResult.SUCCESSFUL;
                } catch (RPGException ex) {
                //System.err.println("Error for " + attacker.getName() + ": " + ex.getMessage());
                return super.attack(attacker, target);
                }
                
            }

            @Override
            public AttackResult simulateAttack(RPGCharacter attacker, RPGCharacter target) {
                if (target.getPosition().getDistance(attacker.getPosition()) <= 500.0)
                    return AttackResult.SUCCESSFUL;
                AttackResult fallBack = super.simulateAttack(attacker, target);
                if (fallBack == AttackResult.NO_DAMAGE) return AttackResult.OUT_OF_RANGE;
                return fallBack;
            }

        });


    }
}
