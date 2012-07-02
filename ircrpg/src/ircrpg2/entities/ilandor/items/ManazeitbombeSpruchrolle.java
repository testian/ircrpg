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
public class ManazeitbombeSpruchrolle extends ItemCommon {

    public String getName() {
        return "Spruchrolle Manazeitbombe";
    }

    public int getWeight() {
        return 500;
    }

    public void onItemRemoved(RPGCharacter user) {
    }

    @Override
    public String itemInfo() {
        return super.itemInfo() + ". Für den einmaligen Gebrauch.  Wird an einem beliebigen Ort platziert. Explodiert nach 10 Minuten. Fügt allen in einer Reichweite von 100 Metern inklusive dem Bombenleger bis zu 400 Schaden zu. Benötigt 200 Mana.";
    }


    public void use(RPGCharacter user) throws RPGException {
        new Manazeitbombe().cast(user);
        user.getInventory().removeItem(this);
    }

}
