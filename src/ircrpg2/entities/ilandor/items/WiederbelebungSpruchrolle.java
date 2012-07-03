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
public class WiederbelebungSpruchrolle extends ItemCommon{

    public int getWeight() {
        return 500;
    }

    public void onItemRemoved(RPGCharacter user) {

    }

    public String getName() {
        return "Spruchrolle Wiederbelebung";
    }

    @Override
    public String itemInfo() {
        return super.itemInfo() + ". Für den einmaligen Gebrauch. Belebt das tote Ziel wieder. Reichweite 200m. Benötigt im Normalfall soviel Mana wie das Ziel maximale Lebensenergie hat.";
    }

    public void use(RPGCharacter user) throws RPGException {
        new Wiederbelebung().cast(user, user.getTarget());
        user.getInventory().removeItem(this);
    }

}
