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
import ircrpg2.core.World;
import ircrpg2.entities.common.NPCCommon;
import ircrpg2.entities.ilandor.items.Trollkeule;
import java.util.HashSet;

/**
 *
 * @author simulity
 */
public class Brueckentroll extends NPCCommon{

    @Override
    public boolean isFriendly(RPGCharacter character) {
        return character instanceof Brueckentroll;
    }
    public Brueckentroll(World world, Locality locality){
        super(world, 9, locality, new Trollkeule(), null, "Brückentroll");
        //super(world, 130, 130, 50, locality, new Trollkeule(), null, "Brückentroll", 0, 0, 0, CharacterState.ALIVE, new HashSet<Skill>(), new Position(locality));
    }
}
