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
public class TeleportLeiterstadtSpruchrolle extends ItemCommon {

    public String getName() {
        return "Spruchrolle Teleport Leiterstadt";
    }

    public int getWeight() {
        return 500;
    }

    public void onItemRemoved(RPGCharacter user) {
    }

    @Override
    public String itemInfo() {
        return super.itemInfo() + ". Für den einmaligen Gebrauch. Teleportiert den Benützer nach Leiterstadt. Benötigt 20 Mana.";
    }


    public void use(RPGCharacter user) throws RPGException {
        user.useMana(20);
        user.allMsg(user.getName() + " wirkt Teleport nach Leiterstadt");
        user.reach(user.getWorld().getLibrary().getLocality("Leiterstadt"));
        user.getInventory().removeItem(this);
    }

}
