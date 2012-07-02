/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.common;
import ircrpg2.core.*;
import java.util.*;
import java.util.Map.Entry;
/**
 *
 * @author testi
 */
public class SelectionCommon implements Selection {

    private Map<Class <? extends Item>, PricePair> list;
    public SelectionCommon(Map<Class<? extends Item>, PricePair> list) {
    this.list = list;
    }
    
    private PricePair silentBuy(RPGCharacter user, Item item) throws RPGException {
    PricePair pair = getItemPrices(item);
        if (pair == null) {
        throw new RPGException(RPGException.Type.NO_DEAL);
        }
        if (pair.getBuy() == Long.MAX_VALUE) throw new RPGException(RPGException.Type.NO_DEAL_SELL);
        Inventory inventory = user.getInventory();
        inventory.removeGold(pair.getBuy());
        try {
        inventory.addItem(item);
        //user.allMsg(user.getName() + " erwirbt " + item.getName() + " für " + pair.getBuy() + " Gold.");
        return pair;
        } catch (RPGException ex) {
        inventory.addGold(pair.getBuy());
        throw ex;
        }
    }

    public void buy(RPGCharacter user, Class<? extends Item> itemClass) throws RPGException {
        PricePair pair = silentBuy(user, ItemFactory.instantiate(itemClass));
        user.allMsg(user.getName() + " erwirbt " + ItemFactory.itemName(itemClass) + " für " + pair.getBuy() + " Gold.");
    }
    public void buy(RPGCharacter user, Class<? extends Item> itemClass, int amount) throws RPGException {
    int a = 0;
    int paid = 0;
    ItemFactory f = new ItemFactory(itemClass);
    try {
    for (int i = 0; i < amount; i++) {
        Item item = f.create();
        PricePair p = silentBuy(user, item);
        a++;
        paid+=p.getBuy();
    }
    }
    catch(RPGException ex) {
    if (a < 1) throw ex;
    }

    if (a>0) user.allMsg(user.getName() + " erwirbt " + a + " mal " + f.name() + " für " + paid + " Gold.");

    }


            public Map<Class <? extends Item>, PricePair> getItems() throws RPGException {
                return Collections.unmodifiableMap(list);
                //return list;
            }
            public PricePair getItemPrices(Item item) {
            /*for (Entry<Item, PricePair> e : list.entrySet()) {
            if (e.getKey().getName().equals(item.getName()))
            return e.getValue();
            }
            return null;*/
            return list.get(item.getClass());
            }

     private PricePair silentSell(RPGCharacter user, Item item) throws RPGException {
        //Map<Class<? extends Item>, PricePair> imap = getItems();
        PricePair pair = null;
        pair = getItemPrices(item);
        /*for (Class<? extends Item> i : imap.keySet()) {
        //Item i = Library.getByName(imap, item.getName());
        if (i ==item.getName())) {
            pair = imap.get(i);
            break;
        }
        }*/

        if (pair == null) {
        throw new RPGException(RPGException.Type.NO_DEAL);
        }
        if (pair.getSell() == Long.MAX_VALUE) throw new RPGException(RPGException.Type.NO_DEAL_BUY);
        Inventory inventory = user.getInventory();
        inventory.removeItem(item);
        inventory.addGold(pair.getSell());
        return pair;
     }

     public void sell(RPGCharacter user, Class<? extends Item> itemClass) throws RPGException {
        ItemFactory f = new ItemFactory(itemClass);
         PricePair pair = silentSell(user,f.create());
        user.allMsg(user.getName() + " verkauft " + f.name() + " für " + pair.getSell() + " Gold.");
    }
     public void sell(RPGCharacter user, Class<? extends Item> itemClass, int amount) throws RPGException {
         String itemName = null;
         int paid = 0;
         int a = 0;
         try {
         for (Item i : user.getInventory().getItems()) {
         if (i.getClass() == itemClass) {
         itemName = i.getName();
         if (a<amount) {
             PricePair p = silentSell(user,i);
             a++;
             paid+=p.getSell();
         
         }
         }
         }
         } catch (RPGException ex) {
         if (a < 1) throw ex;
         }
         if (a>0) user.allMsg(user.getName() + " verkauft " + a + " mal " + itemName + " für " + paid + " Gold.");
     }
    
}
