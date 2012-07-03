/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.items;
import ircrpg2.entities.common.*;
/**
 *
 * @author testi
 */
public class Eisenhelm extends ArmorCommon.HeadArmor {

    public String getName() {
        return "Helm aus Eisen";
    }

    /*public String itemInfo() {
        return "Ein eiserner Helm. " + super.itemInfo();
    }*/


    public int getWeight() {
        return 4000;
    }

    public int getBlock() {
        return 7;
    }

}
