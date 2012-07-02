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
public class Holzfaelleraxt extends Weapon {

    @Override
    public int getDamageBlock() {
        return 7;
    }

    @Override
    public int getMaxDamage() {
        return 15;
    }

    @Override
    public int getMinDamage() {
        return 8;
    }

    @Override
    public double getRange() {
        return 5;
    }

    @Override
    public int getRequiredStrength() {
        return 20;
    }

    @Override
    public double getSpeed() {
        return 6;
    }

    public String getName() {
        return "Holzfälleraxt";
    }

    public int getWeight() {
        return 2000;
    }

}
