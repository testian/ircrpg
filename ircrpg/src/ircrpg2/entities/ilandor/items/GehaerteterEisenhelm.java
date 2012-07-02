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
public class GehaerteterEisenhelm extends ArmorCommon.HeadArmor{

    public int getWeight() {
        return 4500;
    }

    public String getName() {
        return "Gehärteter Eisenhelm";
    }

    public int getBlock() {
        return 10;
    }

}
