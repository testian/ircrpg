/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.items;

import ircrpg2.entities.common.ArmorCommon;

/**
 *
 * @author testi
 */
public class Diamantenpanzer extends ArmorCommon.ChestArmor{

    public String getName() {
        return "Fortaner Diamantenpanzer";
    }

    public int getWeight() {
        return 150000;
    }

    public int getBlock() {
        return 500;
    }

}
