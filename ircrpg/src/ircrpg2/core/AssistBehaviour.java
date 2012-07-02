/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;

/**
 *
 * @author testi
 */
public interface AssistBehaviour {
/**
 * 
 * @param subject
 * @param target
 * @return true if subject could successfully assist target
 */
public boolean assist(RPGCharacter subject, RPGCharacter target);
}
