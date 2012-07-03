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
public class Moerderzange extends Weapon{

    @Override
    public int getMaxDamage() {
        return 22;
    }

    @Override
    public int getMinDamage() {
        return 9;
    }

    @Override
    public double getRange() {
        return 5;
    }

    @Override
    public double getSpeed() {
        return 6;
    }

    @Override
    public int getRequiredStrength() {
        return 15;
    }

    @Override
    public int getDamageBlock() {
        return 3;
    }

    public int getWeight() {
        return 5000;
    }

    public String getName() {
        return "Mörderzange";
    }

}
