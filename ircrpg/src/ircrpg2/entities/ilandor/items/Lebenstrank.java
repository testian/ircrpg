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
public class Lebenstrank extends ItemCommon {

    public String getName() {
        return "Trank der Lebensenergie";
    }

    public int getWeight() {
        return 20000;
    }

    public void onItemRemoved(RPGCharacter user) {
    }

    public void use(RPGCharacter user) throws RPGException {
        user.allMsg(user.getName() + " trinkt einen Trank der Lebensenergie.");
        user.increaseMaxHealth(20);
        user.getInventory().removeItem(this);
    }

}
