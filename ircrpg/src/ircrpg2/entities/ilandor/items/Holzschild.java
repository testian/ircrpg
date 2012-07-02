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
public class Holzschild extends Weapon {

    @Override
    public int getDamageBlock() {
        return 16;
    }

    @Override
    public int getMaxDamage() {
        return 0;
    }

    @Override
    public int getMinDamage() {
        return 0;
    }

    @Override
    public double getRange() {
        return 0;
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
        return "Schild aus Holz";
    }

    public int getWeight() {
        return 2000;
    }

}
