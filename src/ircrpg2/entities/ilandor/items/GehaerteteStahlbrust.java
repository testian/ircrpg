/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.items;

import ircrpg2.entities.common.ArmorCommon;

/**
 *
 * @author simulity
 */
public class GehaerteteStahlbrust extends ArmorCommon.ChestArmor{

    public String getName() {
        return "Gehärtete Stahlbrust";
    }

    public int getWeight() {
        return 5500;
    }

    public int getBlock() {
        return 15;
    }

}
