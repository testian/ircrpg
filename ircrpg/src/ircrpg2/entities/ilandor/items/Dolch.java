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
public class Dolch extends Weapon {

    @Override
    public int getMaxDamage() {
        return 8;
    }

    @Override
    public int getMinDamage() {
        return 3;
    }

    @Override
    public double getRange() {
        return 3;
    }

    @Override
    public int getRequiredStrength() {
        return 5;
    }

    @Override
    public double getSpeed() {
        return 3;
    }

    public String getName() {
        return "Dolch";
    }

    public int getWeight() {
        return 500;
    }

    @Override
    public int getDamageBlock() {
        return 5;
    }


}
