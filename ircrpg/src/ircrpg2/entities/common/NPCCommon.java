/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.common;

import ircrpg2.ai.TargetStack;
import ircrpg2.core.*;
import ircrpg2.entities.common.npc.ai.FindAndKill;
import ircrpg2.entities.common.npc.ai.MoveHome;
import java.util.*;

/**
 *
 * @author testi
 */
abstract public class NPCCommon extends CharacterCommon implements NPC {

    private NPCBehaviour npcListener;
    protected TargetStack targetStack;
    public NPCCommon(World world, int health, int maxHealth, int strength, Locality home, Weapon currentWeapon, Weapon secondCurrentWeapon, String name, long xp, int level, int skillPoints, CharacterState state, Set<Skill> skills, Position position) {
        super(world, health, maxHealth, strength, home, currentWeapon, secondCurrentWeapon, name, xp, level, skillPoints, state, skills, position,0,0);
        this.setNPCBehaviour(new DefaultNPCBehaviour());
    }
    public NPCCommon(World world, int level, Locality home, Weapon primary, Weapon secondary, String name) {
    this(world,(level+4)*10,(level+4)*10,level*10+5, home, primary,secondary,name,level*level*250,level,0,CharacterState.ALIVE,new HashSet<Skill>(),new Position(home));
    }
    public NPCCommon(World world, int level, Locality home, String name) {
    this(world,level,home,null,null,name);
    }
    public NPCCommon(World world, int level, Locality home, Weapon weapon, String name) {
    this(world,level,home,weapon,null,name);
    }
    @Override
    public boolean isNPC() {
    return true;
    }

    abstract public boolean isFriendly(RPGCharacter character);

    public int compareFriends(RPGCharacter c1, RPGCharacter c2) {
        int l1 = 0;
        if (isFriendly(c1)) l1 = 1;
        int l2 = 0;
        if (isFriendly(c2)) l2 = 1;
        return l2-l1;
    }



    public NPCBehaviour getNPCBehaviour() {
        return npcListener;
    }

    public void setNPCBehaviour(NPCBehaviour npcBehaviour) {
        npcListener = npcBehaviour;
        npcBehaviour.setNpc(this);
    }

    public void refresh() {
    refresh(100);
    }
    public void refresh(int refreshPercentage) {
    for (Item i : this.getInventory().getItems()) {
    i.repair(refreshPercentage);
    }
    int finalMana = (getMaxMana()*refreshPercentage)/100;
    if (finalMana > this.getMana())
    this.increaseMana(finalMana-this.getMana());
    }
    


}
