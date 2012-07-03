/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;
import java.util.*;
/**
 *
 * @author testi
 */
public interface Store extends Usable, Named {
//public void sell(RPGCharacter user, Item item) throws RPGException;
public Selection getSelection();

//Map<Item, PricePair> getItems();
//public boolean dealsItem(Item item);
}
