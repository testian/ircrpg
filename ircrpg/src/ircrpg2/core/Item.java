/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;

/**
 *
 * @author testi
 */
public interface Item extends Usable, Named {
    /**
     *
     * @return weight of the item in gram
     */
    public int getWeight();
    /**
     * Action performed after the user removed the item from his inventory
     * @param user
     */
    public void onItemRemoved(RPGCharacter user);
    /**
     * 
     * @return name of the item
     */
    public String getName();
    /**
     * 
     * @return integrity of the item
     */
    public int getIntegrity();
    /**
     * sets the integrity of the item to integrity
     * @param integrity
     */
    public void setIntegrity(int integrity);


    /**
     * repairs the item by repairpercentage percent, values higher than 100 are possible
     * @param repairpercentage
     */
    public void repair(int repairpercentage);
    /**
     * repairs the item entirely
     */
    public void repair();
    /**
     * decreases the items integrity by damage
     * @param damage
     */
    public void decreaseIntegrity(int damage);
    /**
     * increases the items integrity by repair
     * @param repair
     */
    public void increaseIntegrity(int repair);
    /**
     * 
     * @return a description of the item including usage requirements, properties and similar
     */
    public String itemInfo();
}
