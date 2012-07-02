/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.items;
import ircrpg2.core.*;
import ircrpg2.core.ItemCommon;
/**
 *
 * @author testi
 */
public class GrosseTasche extends ItemCommon implements Bag {

    public int getSlots() {
        return 200;
    }

    public String getName() {
        return "Grosse Tasche";
    }

    public int getWeight() {
        return 5000;
    }

    public void onItemRemoved(RPGCharacter user) {
        
    }

    public void use(RPGCharacter user) throws RPGException {
        
    }

}
