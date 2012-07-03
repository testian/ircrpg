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
public class TeleportMagierKlosterSpruchrolle extends ItemCommon {

    public String getName() {
        return "Spruchrolle Teleport Das Kloster der Magier";
    }

    public int getWeight() {
        return 500;
    }

    public void onItemRemoved(RPGCharacter user) {
    }

    @Override
    public String itemInfo() {
        return super.itemInfo() + ". Für den einmaligen Gebrauch. Teleportiert den Benützer zum Kloster der Magier. Benötigt 20 Mana.";
    }


    public void use(RPGCharacter user) throws RPGException {
        user.useMana(20);
        user.allMsg(user.getName() + " wirkt Teleport zum Kloster der Magier");
        user.reach(user.getWorld().getLibrary().getLocality("Das Kloster der Magier"));
        user.getInventory().removeItem(this);
    }

}
