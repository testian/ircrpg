/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.npc;
import ircrpg2.core.*;
import ircrpg2.entities.common.*;
import ircrpg2.entities.ilandor.items.*;
import java.util.*;
/**
 *
 * @author testi
 */
public class MichaelHansHeinzPeterFritzFranz extends RedynianCore {

    @Override
    public boolean isFriendly(RPGCharacter character) {
        return !character.isNPC() || character instanceof Redynian;
    }

    public MichaelHansHeinzPeterFritzFranz(World world, Locality locality) {
        super(world, 6, locality, new Langschwert(), null, "Der starke Michaelhansheinzpeterfritzfranz");
        HumanEquipment.equip(this);
        //super(world, 100, 100, 30, locality, new Langschwert(), null, "Der starke Michaelhansheinzpeterfritzfranz", 0, 0, 0, CharacterState.ALIVE, new HashSet<Skill>(), new Position(locality));
    }

}
