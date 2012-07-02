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
public class Verstaerkungskit extends ItemCommon {

    public String getName() {
        return "Verstärkungskit";
    }

    @Override
    public String itemInfo() {
        return super.itemInfo() + ". Repariert sämtliche Gegenstände und verstärkt sie auf die doppelte Haltbarkeit";
    }

    public int getWeight() {
        return 20000;
    }

    public void onItemRemoved(RPGCharacter user) {
    }

    public void use(RPGCharacter user) throws RPGException {
        user.allMsg(user.getName() + " repariert und verstärkt sein Hab und Gut auf 200%");
        for (Item i : user.getInventory().getItems()) {
        i.repair(200);
        }
        user.getInventory().removeItem(this);
    }

}
