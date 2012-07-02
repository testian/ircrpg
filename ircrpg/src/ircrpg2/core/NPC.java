/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;

/**
 *
 * @author testi
 */
public interface NPC extends RPGCharacter {

    public NPCBehaviour getNPCBehaviour();
    public void setNPCBehaviour(NPCBehaviour npcBehaviour);
    public boolean isFriendly(RPGCharacter character);
    /**
     * compares two rpg characters
     *
     * @param c1
     * @param c2
     * @return lesser than or equal to -1 if c1 is more friendly or trustworthy than c2, 0 if both are considered equally friendly, greater than or equal to 1 if c2 is more friendly or trustworthy than c1
     */
    public int compareFriends(RPGCharacter c1, RPGCharacter c2);
    public void refresh();
    public void refresh(int refreshPercentage);
}
