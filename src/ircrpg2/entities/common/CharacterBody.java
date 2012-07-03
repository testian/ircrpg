/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.common;
import ircrpg2.core.*;
/**
 *
 * @author testi
 */
public class CharacterBody implements Body {

    private Armor chest, feet, hands, head, legs;

    public CharacterBody() {
    chest = null;
    feet = null;
    hands = null;
    head = null;
    legs = null;
    }

    public void dealDamage(int damage) {
        //return nullArmor(chest()).getBlock()+nullArmor(feet()).getBlock()+nullArmor(hands()).getBlock()+nullArmor(head()).getBlock()+nullArmor(legs()).getBlock();
        if (damage > getRealBlock()) damage = getRealBlock();
        int damageShared = 0;
        if (damage == 0) return;
        int q = this.getRealBlock()/damage;

        Armor chest = nullArmor(this.chest);
        int chestDamage = chest.getRealBlock()/q;

        Armor feet = nullArmor(this.feet);
        int feetDamage = feet.getRealBlock()/q;

        Armor hands = nullArmor(this.hands);
        int handsDamage = hands.getRealBlock()/q;

        Armor head = nullArmor(this.head);
        int headDamage = head.getRealBlock()/q;

        Armor legs = nullArmor(this.legs);
        int legsDamage = legs.getRealBlock()/q;
        damageShared = legsDamage + headDamage + feetDamage + chestDamage + handsDamage;
        int damageLeft = damage - damageShared;
        chestDamage+=damageLeft;
        chest.decreaseIntegrity(chestDamage);
        feet.decreaseIntegrity(feetDamage);
        hands.decreaseIntegrity(handsDamage);
        head.decreaseIntegrity(headDamage);
        legs.decreaseIntegrity(legsDamage);
    }






    public Armor chest() {
        return chest;
    }

    public Armor feet() {
        return feet;
    }

    public Armor hands() {
        return hands;
    }

    public Armor head() {
        return head;
    }

    public Armor legs() {
        return legs;
    }

    public void setChest(Armor chest) {
        this.chest = chest;
    }

    public void setFeet(Armor feet) {
        this.feet = feet;
    }

    public void setHands(Armor hands) {
        this.hands = hands;
    }

    public void setHead(Armor head) {
        this.head = head;
    }

    public void setLegs(Armor legs) {
        this.legs = legs;
    }

    public int getRealBlock() {
        return realBlock(chest())+realBlock(feet())+realBlock(hands())+realBlock(head())+realBlock(legs());
    }
    public int getBlock() {
    return maxBlock(chest())+maxBlock(feet())+maxBlock(hands())+maxBlock(head())+maxBlock(legs());
    }
    private int realBlock(Armor armor) {
    armor = nullArmor(armor);
    return armor.getRealBlock();
    }
    private int maxBlock(Armor armor) {
    armor = nullArmor(armor);
    return armor.getBlock();
    }

    private Armor nullArmor(Armor armor) {
    if (armor == null) {
    return new Armor() {

                public String getName() {
                    return "Nichts";
                }

                public String itemInfo() {
                    return "Kein Schutz";
                }

                public int getWeight() {
                    return 0;
                }

                public void onItemRemoved(RPGCharacter user) {
                }

                public void use(RPGCharacter user) throws RPGException {
                }

                public int getBlock() {
                    return 0;
                }

                public void decreaseIntegrity(int damage) {

                }

                public void repair(int repairpercentage) {
                    
                }



                public int getIntegrity() {
                    return 0;
                }

                public void increaseIntegrity(int repair) {
                    
                }

                public void repair() {
                    
                }

                public void setIntegrity(int integrity) {
                    
                }
                public int getRealBlock() {
                return 0;
                }

                public boolean equip(RPGCharacter user) {
                    return false;
                }

                public boolean unEquip(RPGCharacter user) {
                    return false;
                }

    };
    }
    return armor;
    }


}
