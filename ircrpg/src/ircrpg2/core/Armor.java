/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;

/**
 *
 * @author testi
 */
public interface Armor extends Item {
public int getBlock();
public int getRealBlock();
/**
 * equips this item onto the user
 * @param user
 * @return true if item could be equipped and the user wasn't wearing it already, false otherwise
 */
public boolean equip(RPGCharacter user);
/**
 * unequips this item from the user
 * @param user
 * @return true if the item could be unequipped and the user was wearing it
 */
public boolean unEquip(RPGCharacter user);
}
