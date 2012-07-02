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
public class Langschwert extends Weapon {

    @Override
    public int getDamageBlock() {
        return 10;
    }

    @Override
    public int getMaxDamage() {
        return 40;
    }

    @Override
    public int getMinDamage() {
        return 20;
    }

    @Override
    public double getRange() {
        return 6;
    }

    @Override
    public int getRequiredStrength() {
        return 20;
    }

    @Override
    public double getSpeed() {
        return 5;
    }

    public String getName() {
        return "Stählernes Langschwert";
    }

    public int getWeight() {
        return 8000;
    }

}
