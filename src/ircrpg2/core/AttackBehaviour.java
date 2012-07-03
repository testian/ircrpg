/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ircrpg2.core;

/**
 *
 * @author testi
 */
public interface AttackBehaviour {

    public AttackResult simulateAttack(RPGCharacter attacker, RPGCharacter target);

    public AttackResult attack(RPGCharacter attacker, RPGCharacter target);

    public enum AttackResult {

        SUCCESSFUL,
        OUT_OF_RANGE,
        NO_DAMAGE,
        NO_RESOURCE,
        UNABLE,
        IN_PROGRESS
    }
}
