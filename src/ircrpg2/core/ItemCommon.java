/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;

import ircrpg2.core.Item;

/**
 *
 * @author testi
 */
public abstract class ItemCommon implements Item {

    public static final int DEFAULT_INTEGRITY = 1000;
    private int integrity;
    public ItemCommon() {
    integrity = DEFAULT_INTEGRITY;
    }

    public void decreaseIntegrity(int damage) {
        if (damage<0) throw new IllegalArgumentException("damage must be >=0");
        setIntegrity(integrity-damage);

    }

    public String itemInfo() {
        return getName() + " - Gewicht: " + getWeight() + "g, Integrität: " + getIntegrity()/10 + "%";
    }

    public void repair(int repairpercentage) {
    int newIntegrity = (repairpercentage*DEFAULT_INTEGRITY)/100;
    if (newIntegrity>integrity)
    setIntegrity(newIntegrity);
    }



    public int getIntegrity() {
        return integrity;
    }

    public void increaseIntegrity(int repair) {
        if (repair<0) throw new IllegalArgumentException("repair must be >=0");
        setIntegrity(integrity+repair);
    }

    public void repair() {
        if (DEFAULT_INTEGRITY>integrity)
        setIntegrity(DEFAULT_INTEGRITY);
    }

    public void setIntegrity(int integrity) {
        if (integrity<0) integrity = 0;
        //else if (integrity > MAX_INTEGRITY) integrity = MAX_INTEGRITY;
        this.integrity = integrity;
    }
}
