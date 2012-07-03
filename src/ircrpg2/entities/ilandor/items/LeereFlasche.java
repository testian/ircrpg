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
 * @author testi
 */
public class LeereFlasche extends ItemCommon {

    public String getName() {
        return "Leere Flasche";
    }

    public int getWeight() {
    return 50;
    }

    public void onItemRemoved(RPGCharacter user) {

    }

    public void use(RPGCharacter user) throws RPGException {
        user.msg("Füll mich!");
    }

}
