/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.items;

import ircrpg2.core.RPGCharacter;
import ircrpg2.core.RPGException;
import ircrpg2.core.ItemCommon;

/**
 *
 * @author testi
 */
public class Brot extends ItemCommon {
    public String getName() {
        return "Brot";
    }

    public int getWeight() {
        return 9000;
    }

    public String itemInfo() {
        return super.itemInfo() + ". Heilt um 10 Punkte.";
    }


    public void onItemRemoved(RPGCharacter user) {
    }

    public void use(RPGCharacter user) throws RPGException {
        user.allMsg(user.getName() + " isst ein Brot.");
        user.increaseHealth(10);
        user.getInventory().removeItem(this);
    }
}
