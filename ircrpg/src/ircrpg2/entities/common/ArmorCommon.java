/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.common;
import ircrpg2.core.ItemCommon;
import ircrpg2.core.*;
/**
 *
 * @author testi
 */
abstract public class ArmorCommon extends ItemCommon implements Armor {

    public void onItemRemoved(RPGCharacter user) {
        Body body = user.getBody();
        if (current(body) == this) {
        try {
            user.unequipArmor(this);} catch (RPGException ex) {}
        }
    }

    public boolean equip(RPGCharacter user) {
        Body body = user.getBody();
        if (current(body) != this) {
        set(body);
        return true;
        }
        return false;
    }

    public boolean unEquip(RPGCharacter user) {
        Body body = user.getBody();
        if (current(body) == this) {
        unset(body);
        return true;
        }
        return false;
    }


    @Override
    public String itemInfo() {
        return super.itemInfo() + ", Schadensblockierung: " + getRealBlock() + "/" + getBlock();
    }




    public int getRealBlock() {
    int blockLevel = (getIntegrity()+99)/100;
    if (blockLevel > 10) blockLevel = 10;
    int realBlock =  (getBlock()*blockLevel)/10;
    return realBlock;
    }






    public void use(RPGCharacter user) throws RPGException {
        Body body = user.getBody();
        if (current(body) == this) {
        user.unequipArmor(this);
        //unset(body);
        //user.allMsg(user.getName() + " legt " + this.getName() + " ab.");
        } else {
        
        user.equipArmor(this);   
        //set(body);
        //user.allMsg(user.getName() + " legt " + this.getName() + " an.");
        }
    }

    abstract protected Armor current(Body body);
    abstract protected void set(Body body);
    abstract protected void unset(Body body);

    abstract public static class HandsArmor extends ArmorCommon {

        @Override
        protected Armor current(Body body) {
            return body.hands();
        }

        @Override
        protected void set(Body body) {
            body.setHands(this);
        }
        @Override
        protected void unset(Body body) {
            body.setHands(null);
        }

    }

        abstract public static class ChestArmor extends ArmorCommon {

        @Override
        protected Armor current(Body body) {
            return body.chest();
        }

        @Override
        protected void set(Body body) {
            body.setChest(this);
        }

        @Override
        protected void unset(Body body) {
            body.setChest(null);
        }

    }

        abstract public static class FeetArmor extends ArmorCommon {

        @Override
        protected Armor current(Body body) {
            return body.feet();
        }

        @Override
        protected void set(Body body) {
            body.setFeet(this);
        }

        @Override
        protected void unset(Body body) {
            body.setFeet(null);
        }

    }

        abstract public static class HeadArmor extends ArmorCommon {

        @Override
        protected Armor current(Body body) {
            return body.head();
        }


        @Override
        protected void set(Body body) {
            body.setHead(this);
        }

        @Override
        protected void unset(Body body) {
            body.setHead(null);
        }

    }

        abstract public static class LegsArmor extends ArmorCommon {

        @Override
        protected Armor current(Body body) {
            return body.legs();
        }

        @Override
        protected void set(Body body) {
            body.setLegs(this);
        }

        @Override
        protected void unset(Body body) {
            body.setLegs(null);
        }

    }

}
