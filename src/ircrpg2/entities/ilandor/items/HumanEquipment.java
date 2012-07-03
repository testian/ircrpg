/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.items;

import ircrpg2.core.RPGCharacter;
import ircrpg2.core.RPGException;
import ircrpg2.entities.common.ArmorCommon;

/**
 *
 * @author testi
 */
public class HumanEquipment {
public static void equip(RPGCharacter c) {
ArmorCommon head = null;
ArmorCommon chest = null;
ArmorCommon hands = null;
ArmorCommon legs = null;
ArmorCommon feet = null;


if (c.getLevel() > 0) {
chest = new Lederjacke();
}
if (c.getLevel() > 1) {
hands = new LederneHandschuhe();
legs = new Lederbeinkleidung();
}

if (c.getLevel() > 2) {
feet = new Lederschuhe();
}

if (c.getLevel() > 4) {
head = new Eisenhelm();
}

if (c.getLevel() > 6) {
legs = new Stahlbeine();
}
if (c.getLevel() > 7) {
legs = new GehaerteteStahlbeine();
}


if (c.getLevel() > 10) {
hands = new VerstaerkteLederhandschuhe();
feet = new VerstaerkteLederschuhe();
head = new GehaerteterEisenhelm();
}

if (c.getLevel() > 11) {
chest = new Stahlbrustpanzer();
}
if (c.getLevel() > 13) {
chest = new GehaerteteStahlbrust();
}






equip(c,head,chest,hands,legs,feet);
}

private static void equip(RPGCharacter c, ArmorCommon head, ArmorCommon chest, ArmorCommon hands, ArmorCommon legs, ArmorCommon feet) {
if (head != null) equip(c,head);
if (chest != null) equip(c,chest);
if (hands != null) equip(c,hands);
if (legs != null) equip(c,legs);
if (feet != null) equip(c,feet);
}
private static void equip(RPGCharacter c, ArmorCommon armor) {
    try {
    c.getInventory().addItem(armor);
armor.use(c); } catch (RPGException ex) {System.err.println("Minor error: " + ex.getMessage());}
}
}
