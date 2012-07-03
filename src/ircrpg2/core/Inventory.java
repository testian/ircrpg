/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;
import java.util.Set;
/**
 *
 * @author testi
 */
public interface Inventory {

    public Set<Item> getItems();
    public int getMaxItems();
    public int getMaxWeight();
    public int freeSlots();
    public int freeWeight();
    public void addItem(Item item) throws RPGException;
    public void removeItem(Item item) throws RPGException;
    public void addGold(long amount);
    public void removeGold(long amount) throws RPGException;
    public long getGold();
    public boolean hasItem(Class<? extends Item> item);
    public int itemAmount(Class<? extends Item> item);
    public Item getItem(Class<? extends Item> item);
    //public void move(Item item, Inventory inventory) throws RPGException;
    //public void moveGold(long amount, Inventory inventory) throws RPGException;
}
