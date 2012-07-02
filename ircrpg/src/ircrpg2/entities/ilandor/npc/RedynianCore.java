/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.npc;

import ircrpg2.core.CharacterState;
import ircrpg2.core.Locality;
import ircrpg2.core.Position;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.Skill;
import ircrpg2.core.Weapon;
import ircrpg2.core.World;
import ircrpg2.entities.common.NPCCommon;
import java.util.Set;

/**
 *
 * @author testi
 */
public class RedynianCore extends NPCCommon implements Redynian {
    public boolean isFriendly(RPGCharacter character) {
        return !character.isNPC() || character instanceof Redynian;
    }
    @Override
    public int compareFriends(RPGCharacter c1, RPGCharacter c2) {
        //int superFriends = user.compareFriends(c1, c2);
        //if (superFriends != 0) return superFriends;
        int l1 = 0;
        if (c1 instanceof RedynianCore) l1 = 1;
        int l2 = 0;
        if (c2 instanceof RedynianCore) l2 = 1;
        return l2-l1;
    }

    public RedynianCore(World world, int level, Locality home, Weapon primary, Weapon secondary, String name) {
        super(world, level, home, primary, secondary, name);
    }

    public RedynianCore(World world, int health, int maxHealth, int strength, Locality home, Weapon currentWeapon, Weapon secondCurrentWeapon, String name, long xp, int level, int skillPoints, CharacterState state, Set<Skill> skills, Position position) {
        super(world, health, maxHealth, strength, home, currentWeapon, secondCurrentWeapon, name, xp, level, skillPoints, state, skills, position);
    }


}
