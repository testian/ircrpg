/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.items;
import ircrpg2.core.*;
/**
 *
 * @author testi
 */
public class Kurzschwert extends Weapon {

    @Override
    public int getMaxDamage() {
        return 12;
    }

    @Override
    public int getMinDamage() {
        return 5;
    }

    @Override
    public double getRange() {
        return 6;
    }

    @Override
    public int getRequiredStrength() {
        return 10;
    }

    @Override
    public double getSpeed() {
        return 3;
    }

    public String getName() {
        return "Kurzschwert";
    }

    public int getWeight() {
        return 2000;
    }

    @Override
    public int getDamageBlock() {
        return 8;
    }

}
