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
public class VerstaerkteLederhandschuhe extends ArmorCommon.HandsArmor{

    public int getWeight() {
        return 1200;
    }

    public String getName() {
        return "Verstärkte Lederhandschuhe";
    }

    public int getBlock() {
        return 5;
    }

}
