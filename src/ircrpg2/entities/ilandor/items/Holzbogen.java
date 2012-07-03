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
public class Holzbogen extends Weapon {

    @Override
    public int getDamageBlock() {
        return 0;
    }

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
        return 30;
    }

    @Override
    public int getRequiredStrength() {
        return 25;
    }

    @Override
    public double getSpeed() {
        return 10;
    }

    public String getName() {
        return "Hölzener Bogen";
    }

    public int getWeight() {
        return 1000;
    }

}
