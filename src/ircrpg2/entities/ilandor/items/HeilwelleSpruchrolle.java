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
public class HeilwelleSpruchrolle extends ItemCommon {

    public String getName() {
        return "Spruchrolle Heilwelle";
    }

    public int getWeight() {
        return 500;
    }

    public void onItemRemoved(RPGCharacter user) {
    }

    @Override
    public String itemInfo() {
        return super.itemInfo() + ". Für den einmaligen Gebrauch. Heilt ausnahmslos alle in einer Reichweite von 50 Metern um bis zu 200. Benötigt 100 Mana.";
    }


    public void use(RPGCharacter user) throws RPGException {
        new Heilwelle().cast(user);
        user.getInventory().removeItem(this);
    }

}
