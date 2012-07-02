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
public class Holzscheit extends ItemCommon {

    public String getName() {
        return "Holzscheit";
    }

    public int getWeight() {
        return 5000;
    }

    public void onItemRemoved(RPGCharacter user) {
    }

    public void use(RPGCharacter user) throws RPGException {
        user.allMsg(user.getName() + " macht ein kleines warmes Feuer.");
        user.increaseHealth(12);
        user.getInventory().removeItem(this);
    }

}
