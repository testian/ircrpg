/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;

/**
 *
 * @author testi
 */
public class WeaponFusion extends Weapon {

    Weapon first;
    Weapon second;
    boolean hasFirst;
    boolean hasSecond;
    public WeaponFusion(Weapon first, Weapon second) {
    if (first == null) {
    this.first = new EmptyWeapon();
    hasFirst = false;
    } else {this.first = first;hasFirst = true;}
    if (second == null) {
    this.second = new EmptyWeapon();
    hasSecond = false;
    } else {this.second = second; hasSecond = true;};
    }
    
    @Override
    public int getDamageBlock() {
        return first.getDamageBlock() + second.getDamageBlock();
    }

    @Override
    public int getMaxDamage() {
        return first.getMaxDamage() + second.getMaxDamage();
    }

    @Override
    public int getMinDamage() {
        if (first.getRange() == second.getRange()) {return first.getMinDamage() + second.getMinDamage();}

        return first.getRange() > second.getRange() ? first.getMinDamage() : second.getMinDamage();
    }

    @Override
    public double getRange() {
        return first.getRange() > second.getRange() ? first.getRange() : second.getRange();
    }

    @Override
    public int getRequiredStrength() {
        return first.getRequiredStrength() + second.getRequiredStrength();
    }

    @Override
    public double getSpeed() {
        return first.getSpeed() > second.getSpeed() ? first.getSpeed() : second.getSpeed();
    }

    public String getName() {
        if (!hasFirst && !hasSecond) {return "Nichts";}
        if (!hasFirst) {return second.getName();}
        if (!hasSecond) {return first.getName();}
        return first.getName() + " und " + second.getName();
    }

    public int getWeight() {
        return first.getWeight() + second.getWeight();
    }
    @Override
    public int calculateDamage(RPGCharacter attacker, RPGCharacter target) throws RPGException {
    double distance = attacker.getPosition().getDistance(target.getPosition());
    boolean excepted=false;
    int d = 0;
    try {
    d+= calcDamage(first, distance);
    //System.err.println("Weapon1: " +d);
    } catch (RPGException ex) {
    excepted=true;
    }
    try {
    d+= calcDamage(second, distance);
    //System.err.println("Weapon2: " +d + " " + calcDamage(second, distance));
    } catch (RPGException ex) {
    if (excepted) {throw ex;}
    }
    return d;
    }

    private int calcDamage(Weapon w, double distance) throws RPGException {
    if (distance>w.getRange() || distance < 0) {throw new RPGException(RPGException.Type.OUT_OF_RANGE);}
    if (w.getRange() == 0) {return (w.getMinDamage()+w.getMaxDamage())/2;}
    double relativeDistance = distance/w.getRange();
    return (int)(relativeDistance*w.getMinDamage() + (1 - relativeDistance)*w.getMaxDamage());
    }


    private class EmptyWeapon extends Weapon {

        @Override
        public int getDamageBlock() {
            return 0;
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
            return 0;
        }

        @Override
        public double getSpeed() {
            return 0;
        }

        public String getName() {
            return "";
        }

        public int getWeight() {
            return 0;
        }

    }

}
