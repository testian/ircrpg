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
public class Punktfeuer extends Weapon {

        @Override
    public int getDamageBlock() {
        return 10;
    }

    @Override
    public int getMaxDamage() {
        return 250;
    }

    @Override
    public int getMinDamage() {
        return 100;
    }

    @Override
    public double getRange() {
        return 90;
    }

    @Override
    public int getRequiredStrength() {
        return 60;
    }

    @Override
    public double getSpeed() {
        return 25;
    }

    public String getName() {
        return "Punktfeuerbogen";
    }

    public int getWeight() {
        return 8000;
    }
}
