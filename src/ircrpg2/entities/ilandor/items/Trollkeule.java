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
public class Trollkeule extends Weapon{

    @Override
    public int getMaxDamage() {
        return 50;
    }

    @Override
    public int getMinDamage() {
        return 20;
    }

    @Override
    public double getRange() {
        return 7;
    }

    @Override
    public double getSpeed() {
        return 9;
    }

    @Override
    public int getRequiredStrength() {
        return 50;
    }

    @Override
    public int getDamageBlock() {
        return 15;
    }

    public int getWeight() {
        return 40000;
    }

    public String getName() {
        return "Riesiger Trollprügel";
    }

}
