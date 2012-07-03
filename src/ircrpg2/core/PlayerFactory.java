/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;

/**
 *
 * @author testi
 */
public interface PlayerFactory {
public RPGCharacter createPlayer(String name) throws RPGException;
public void attachPlayer(RPGCharacter player) throws RPGException;
}
