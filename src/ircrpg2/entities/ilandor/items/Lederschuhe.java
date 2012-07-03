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
public class Lederschuhe extends ArmorCommon.FeetArmor {

    public String getName() {
        return "Schuhe aus Leder";
    }

    public int getWeight() {
        return 1000;
    }

    public int getBlock() {
        return 1;
    }

}
