/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.npc;

import ircrpg2.core.CharacterState;
import ircrpg2.core.Destructive;
import ircrpg2.core.Locality;
import ircrpg2.core.Position;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.Skill;
import ircrpg2.core.Weapon;
import ircrpg2.core.World;
import ircrpg2.entities.common.NPCCommon;
import ircrpg2.entities.common.npc.ai.FindAndKill;
import java.util.Set;

/**
 *
 * @author testi
 */
public abstract class Zyrenbaer extends NPCCommon {

    @Override
    public boolean isFriendly(RPGCharacter character) {
        return character instanceof Zyrenbaer;
    }

    public Zyrenbaer(World world, int health, int maxHealth, int strength, Locality home, Weapon currentWeapon, Weapon secondCurrentWeapon, String name, long xp, int level, int skillPoints, CharacterState state, Set<Skill> skills, Position position) {
        super(world, health, maxHealth, strength, home, currentWeapon, secondCurrentWeapon, name, xp, level, skillPoints, state, skills, position);
        this.setNPCBehaviour(new ProtectingBehaviour(Zyrenbaer.class));
    }

    public Zyrenbaer(World world, int level, Locality home, Weapon primary, Weapon secondary, String name) {
        super(world, level, home, primary, secondary, name);
        this.setNPCBehaviour(new ProtectingBehaviour(Zyrenbaer.class));
    }
    
}
