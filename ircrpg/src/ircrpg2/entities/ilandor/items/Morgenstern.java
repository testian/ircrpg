/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.items;

import ircrpg2.core.Weapon;

/**
 *
 * @author simulity
 */
public class Morgenstern extends Weapon{

    @Override
    public int getMaxDamage() {
        return 20;
    }

    @Override
    public int getMinDamage() {
        return 10;
    }

    @Override
    public double getRange() {
        return 6;
    }

    @Override
    public double getSpeed() {
        return 4;
    }

    @Override
    public int getRequiredStrength() {
        return 14;
    }

    @Override
    public int getDamageBlock() {
        return 4;
    }

    public int getWeight() {
        return 6000;
    }

    public String getName() {
        return "Morgenstern";
    }

}
