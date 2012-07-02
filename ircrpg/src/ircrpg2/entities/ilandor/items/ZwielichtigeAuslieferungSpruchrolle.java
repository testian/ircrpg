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
public class ZwielichtigeAuslieferungSpruchrolle extends ItemCommon {

    public String getName() {
        return "Spruchrolle Fragwürdige Auslieferung";
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

        
        new Auslieferung().cast(user, user.getHome());
        user.getInventory().removeItem(this);
    }

}
