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
public class Eisenschild extends Weapon {

    @Override
    public int getDamageBlock() {
        return 32;
    }

    @Override
    public int getMaxDamage() {
        return 3;
    }

    @Override
    public int getMinDamage() {
        return 1;
    }

    @Override
    public double getRange() {
        return 1;
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
        return "Eisernes Schild";
    }

    public int getWeight() {
        return 5000;
    }

}
