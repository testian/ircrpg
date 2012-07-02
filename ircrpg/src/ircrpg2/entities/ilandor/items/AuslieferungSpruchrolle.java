/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.items;

import ircrpg2.core.RPGCharacter;
import ircrpg2.core.RPGException;
import ircrpg2.core.ItemCommon;
import ircrpg2.core.Locality;

/**
 *
 * @author testi
 */
public class AuslieferungSpruchrolle extends ItemCommon {

    public String getName() {
        return "Spruchrolle Auslieferung";
    }

    public int getWeight() {
        return 500;
    }

    public void onItemRemoved(RPGCharacter user) {
    }

    @Override
    public String itemInfo() {
        return super.itemInfo() + ". Für den einmaligen Gebrauch. Benötigt 600 Mana. Unbekannte Wirkung.";
    }


    public void use(RPGCharacter user) throws RPGException {

        Locality l = user.getWorld().getLibrary().getLocality("Bergsee an der Bergspitze von Zyren");
        new Auslieferung().cast(user, l);
        user.getInventory().removeItem(this);
    }

}
