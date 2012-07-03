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
public class GrosserHeiltrank extends ItemCommon {

    public String getName() {
        return "Grosser Heiltrank";
    }

    public int getWeight() {
        return 1500;
    }

    public void onItemRemoved(RPGCharacter user) {
    }

    public void use(RPGCharacter user) throws RPGException {
        user.allMsg(user.getName() + " trinkt einen grossen Heiltrank.");
        user.increaseHealth(120);
        user.getInventory().removeItem(this);
    }

}
