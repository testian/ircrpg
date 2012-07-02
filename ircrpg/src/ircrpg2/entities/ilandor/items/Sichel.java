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
public class Sichel extends Weapon{

    @Override
    public int getDamageBlock() {
        return 6;
    }

    @Override
    public int getMaxDamage() {
        return 16;
    }

    @Override
    public int getMinDamage() {
        return 7;
    }

    @Override
    public double getRange() {
        return 6;
    }

    @Override
    public int getRequiredStrength() {
        return 11;
    }

    @Override
    public double getSpeed() {
        return 3.5;
    }

    public int getWeight() {
        return 1800;
    }

    public String getName() {
        return "Sichel";
    }
}
