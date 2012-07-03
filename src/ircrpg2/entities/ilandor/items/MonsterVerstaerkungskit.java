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
public class MonsterVerstaerkungskit extends ItemCommon {

    public String getName() {
        return "Monster-Verstärkungskit";
    }

    @Override
    public String itemInfo() {
        return super.itemInfo() + ". Repariert sämtliche Gegenstände und verstärkt sie auf die zehnfache Haltbarkeit";
    }

    public int getWeight() {
        return 30000;
    }

    public void onItemRemoved(RPGCharacter user) {
    }

    public void use(RPGCharacter user) throws RPGException {
        user.allMsg(user.getName() + " repariert und verstärkt sein Hab und Gut auf 1000%");
        for (Item i : user.getInventory().getItems()) {
        i.repair(1000);
        }
        user.getInventory().removeItem(this);
    }

}
