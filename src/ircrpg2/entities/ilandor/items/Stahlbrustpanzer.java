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
public class Stahlbrustpanzer extends ArmorCommon.ChestArmor{

    public int getWeight() {
        return 5000;
    }

    public String getName() {
        return "Stahlbrustpanzer";
    }

    public int getBlock() {
        return 11;
    }

}
