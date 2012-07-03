/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.items;
import ircrpg2.core.*;
import ircrpg2.core.ItemCommon;
/**
 *
 * @author testi
 */
public class Vitanit extends ItemCommon {

    public String getName() {
        return "Vitanit";
    }

    public int getWeight() {
        return 12000;
    }

    public void onItemRemoved(RPGCharacter user) { 
    }

    public void use(RPGCharacter user) throws RPGException {
    }

}
