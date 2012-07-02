/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;

/**
 *
 * @author testi
 */
abstract public class Weapon extends ItemCommon implements Destructive {
    
    abstract public int getMaxDamage();
    abstract public int getMinDamage();
    abstract public double getRange();
    abstract public double getSpeed();
    abstract public int getRequiredStrength();
    abstract public int getDamageBlock();
    public void use(RPGCharacter user) throws RPGException {
    if (user.getCurrentWeapon() == this || user.getSecondCurrentWeapon() == this) {
    user.unequipWeapon(this);
    return;
    }
    Weapon test = new WeaponFusion(user.getCurrentWeapon(),this);
    if (user.getStrength()<test.getRequiredStrength()){
    throw new RPGException(RPGException.Type.NOT_STRONG_ENOUGH);
    }
        user.equipWeapon(this);
    }
    public void onItemRemoved(RPGCharacter user)
    {
        try {
        user.unequipWeapon(this);
        } catch (RPGException ex){}
    }
    public int calculateDamage(RPGCharacter attacker, RPGCharacter target) throws RPGException {
    double distance = attacker.getPosition().getDistance(target.getPosition());
    if (distance>getRange() || distance < 0) {throw new RPGException(RPGException.Type.OUT_OF_RANGE);}
    if (getRange() == 0) {return (getMinDamage()+getMaxDamage())/2;}
    double relativeDistance = distance/getRange();
    return (int)(relativeDistance*getMinDamage() + (1 - relativeDistance)*getMaxDamage());
    }

    public DestructionType getType() {
        return DestructionType.WEAPON;
    }

    public String itemInfo() {
        return super.itemInfo() + ", Minimaler Schaden: " + this.getMinDamage() + ", Maximaler Schaden: " + this.getMaxDamage() + ", Reichweite: " + this.getRange() + "m, Angriffszeit: " + this.getSpeed() + "s, Schadensblockierung: " + this.getDamageBlock() + ", Benötigte Stärke: " + this.getRequiredStrength();
    }




}
