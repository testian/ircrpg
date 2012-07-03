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
public class ErheblicherHeiltrank extends ItemCommon {

    public String getName() {
        return "Erheblicher Heiltrank";
    }

    public int getWeight() {
        return 500;
    }

    public void onItemRemoved(RPGCharacter user) {
    }

    public String itemInfo() {
        return super.itemInfo() + ". Ein Heiltrank, der um 150 Punkte heilt.";
    }


    public void use(RPGCharacter user) throws RPGException {
        user.allMsg(user.getName() + " trinkt einen erheblichen Heiltrank.");
        user.increaseHealth(150);
        user.getInventory().removeItem(this);
    }

}
