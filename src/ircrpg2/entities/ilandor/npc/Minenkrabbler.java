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
import ircrpg2.entities.ilandor.items.Moerderzange;
import java.util.HashSet;

/**
 *
 * @author simulity
 */
public class Minenkrabbler extends NPCCommon{

    @Override
    public boolean isFriendly(RPGCharacter character) {
        return character instanceof Minenkrabbler;
    }
    public Minenkrabbler(World world, Locality locality, int id){
        super(world, 11, locality, new Moerderzange(), null, "Minenkrabbler " + id);
        //super(world, 150, 150, 20, locality, new Moerderzange(), null, "Minenkrabbler " + id, 0, 0, 0, CharacterState.ALIVE, new HashSet<Skill>(), new Position(locality));
    }

}
