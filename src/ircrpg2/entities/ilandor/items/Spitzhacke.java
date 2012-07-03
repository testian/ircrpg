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
public class Spitzhacke extends Weapon {

    @Override
    public int getDamageBlock() {
        return 7;
    }

    @Override
    public int getMaxDamage() {
        return 11;
    }

    @Override
    public int getMinDamage() {
        return 4;
    }

    @Override
    public double getRange() {
        return 5;
    }

    @Override
    public int getRequiredStrength() {
        return 9;
    }

    @Override
    public double getSpeed() {
        return 5;
    }

    public String getName() {
        return "Spitzhacke";
    }

    public int getWeight() {
        return 2000;
    }

}
