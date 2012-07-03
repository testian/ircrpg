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
public class Manasteigerung extends ItemCommon {

    public String getName() {
        return "Trank der Manasteigerung";
    }

    public int getWeight() {
        return 20000;
    }

    public void onItemRemoved(RPGCharacter user) {
    }

    public void use(RPGCharacter user) throws RPGException {
        user.allMsg(user.getName() + " trinkt einen Trank der Manasteigerung.");
        user.increaseMaxMana(10);
        user.getInventory().removeItem(this);
    }

}
