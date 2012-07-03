/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.items;

import ircrpg2.core.ItemCommon;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.RPGException;

/**
 *
 * @author simulity
 */
public class RegenerationSpruchrolle extends ItemCommon{

    public int getWeight() {
        return 500;
    }

    public void onItemRemoved(RPGCharacter user) {

    }

    public String getName() {
        return "Spruchrolle Regeneration";
    }

    @Override
    public String itemInfo() {
        return super.itemInfo() + ". Für den einmaligen Gebrauch. Heilt den zaubernden vollständig.";
    }

    public void use(RPGCharacter user) throws RPGException {
        new Regeneration().cast(user);
        user.getInventory().removeItem(this);
    }

}
