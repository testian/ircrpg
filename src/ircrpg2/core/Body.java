/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;

/**
 *
 * @author testi
 */
public interface Body {
public Armor hands();
public void setHands(Armor hands);
public Armor head();
public void setHead(Armor head);
public Armor chest();
public void setChest(Armor chest);
public Armor legs();
public void setLegs(Armor chest);
public Armor feet();
public void setFeet(Armor feet);
public int getRealBlock();
public int getBlock();
public void dealDamage(int damage);

}
