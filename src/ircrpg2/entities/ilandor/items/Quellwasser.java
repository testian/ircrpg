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
public class Quellwasser extends ItemCommon {

    public String getName() {
        return "Quellwasser";
    }

    public int getWeight() {
        return 500;
    }

    public void onItemRemoved(RPGCharacter user) {
    }

    public void use(RPGCharacter user) throws RPGException {
        user.allMsg(user.getName() + " trinkt Quellwasser.");
        user.increaseHealth(20);
        user.increaseMana(20);
        user.getInventory().removeItem(this);
        user.getInventory().addItem(new LeereFlasche());
    }

}
