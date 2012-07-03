/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.common;
import ircrpg2.core.*;
import java.util.*;
/**
 *
 * @author testi
 */
public class CharacterInventory implements Inventory {
    private RPGCharacter character;
    int bagSlots;
    public CharacterInventory(RPGCharacter character) {
        this.character = character;
        this.items = new HashSet<Item>();
        this.gold = 0;
        bagSlots = 0;
    }

    public CharacterInventory(RPGCharacter character, Set<Item> items, long gold) {
        this.character = character;
        this.items = new HashSet<Item>();
        for (Item i : items) {
        this.items.add(i);
        }
        this.gold = gold;
        for (Item i : items) {
        if (i instanceof Bag) {
        Bag b = (Bag)i;
        bagSlots+=b.getSlots();
        }
        }
    }
    
    private HashSet<Item> items;
    private long gold;
    private final int MAX_SLOTS = 50;
    public void addItem(Item item) throws RPGException {
        int newBagSlots = 0;
        if (item instanceof Bag) {
        newBagSlots = ((Bag)item).getSlots();
        }
        if (freeSlots()+newBagSlots>0) {
            if (item.getWeight()>freeWeight()) {
            throw new RPGException(RPGException.Type.WEIGHT_LIMIT_EXCEEDED);
            }
            items.add(item);
            bagSlots+=newBagSlots;
        }
        else {
        throw new RPGException(RPGException.Type.INVENTORY_FULL);
        }
    }

    public int freeSlots() {
        return MAX_SLOTS - items.size() + bagSlots;
    }

    public int freeWeight() {
        int freeWeight = getMaxWeight();
        for (Item i : items) {
        freeWeight-=i.getWeight();
        }
        return freeWeight;
    }

    public Set<Item> getItems() {
        //return items;
        return (Set<Item>)items.clone();
        //Eventually clone instead
    }

    public int getMaxItems() {
        return MAX_SLOTS;
    }

    public int getMaxWeight() {
        return character.getStrength()*5000;
    }

    public void removeItem(Item item) throws RPGException {
        if (!items.contains(item)) {
        throw new RPGException(RPGException.Type.NOT_CONTAINED);
        }
        if (item instanceof Bag) {
        Bag b = (Bag)item;
        if (b.getSlots()>freeSlots()) {
        throw new RPGException(RPGException.Type.BAG_STILL_NEEDED);
        }
        bagSlots-=b.getSlots();
        }
        items.remove(item);
        item.onItemRemoved(character);
    }

    public void addGold(long amount) {
        if (amount<0){throw new IllegalArgumentException("amount must not be <0");}
        gold+=amount;
    }

    public void removeGold(long amount) throws RPGException {
    if (amount<0){throw new IllegalArgumentException("amount must not be <0");}
    if ( amount > gold) {
    throw new RPGException(RPGException.Type.NOT_ENOUGH_GOLD);
    }
    gold-=amount;
    }
    public long getGold() {
    return gold;
    }

    public boolean hasItem(Class<? extends Item> item) {
    return getItem(item) != null;
    }

    public Item getItem(Class<? extends Item> item) {
        for (Item i : items) {
        if (i.getClass().equals(item))
            return i;
        }
    return null;
    }

    public int itemAmount(Class<? extends Item> item) {
    int count = 0;
        for (Item i : items) {
        if (i.getClass().equals(item))
            count++;
        }
    return count;
    }




}
