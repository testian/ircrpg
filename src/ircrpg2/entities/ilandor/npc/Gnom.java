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
import java.util.HashSet;

/**
 *
 * @author simulity
 */
public class Gnom extends NPCCommon{

    @Override
    public boolean isFriendly(RPGCharacter character) {
        return character instanceof Gnom;
    }
    public Gnom(World world, Locality locality, int id, Weapon weapon){
        super(world, (weapon.getMaxDamage()<70 ? 55 : weapon.getMaxDamage()+20), (weapon.getMaxDamage()<70 ? 55 : weapon.getMaxDamage()+20), weapon.getRequiredStrength(), locality, weapon, null, "Gnom " + id, 0, 0, 0, CharacterState.ALIVE, new HashSet<Skill>(), new Position(locality));
    }
}
