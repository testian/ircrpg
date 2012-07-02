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
public class Reparaturkit extends ItemCommon {

    public String getName() {
        return "Reparaturkit";
    }

    public int getWeight() {
        return 10000;
    }

    public void onItemRemoved(RPGCharacter user) {
    }

    public void use(RPGCharacter user) throws RPGException {
        user.allMsg(user.getName() + " repariert sein Hab und Gut.");
        for (Item i : user.getInventory().getItems()) {
        i.repair();
        }
        user.getInventory().removeItem(this);
    }

}
