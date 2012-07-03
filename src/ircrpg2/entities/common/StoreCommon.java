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
abstract public class StoreCommon implements Store {

    public void use(RPGCharacter user) throws RPGException {
    user.msg("Preisliste " + getName());
    for (Map.Entry<Class<? extends Item>, PricePair> e : getSelection().getItems().entrySet()) {

            user.msg(ItemFactory.itemName(e.getKey()) + " - Du bezahlst: " + (e.getValue().getBuy() == Long.MAX_VALUE ? "(Unverkäuflich)" : String.valueOf(e.getValue().getBuy()))  + ", " + getName() + " bezahlt: " + (e.getValue().getSell() == Long.MAX_VALUE ? "(Wird nicht gekauft)" : String.valueOf(e.getValue().getSell())));
      

        }
    }
}
