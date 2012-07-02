/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.npc;

import ircrpg2.core.Locality;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.World;
import ircrpg2.entities.common.NPCCommon;
import ircrpg2.entities.ilandor.items.Dolch;
import ircrpg2.entities.ilandor.items.HumanEquipment;
import ircrpg2.entities.ilandor.items.Langschwert;

/**
 *
 * @author simulity
 */
public class Minzraeuber extends NPCCommon{
    public Minzraeuber(World world, Locality locality, int id){
        super(world, 24, locality, new Langschwert(), new Dolch(), "Minzräuber " + id);
        HumanEquipment.equip(this);
        //super(world, 300, 300, 80, locality, new Langschwert(), new Dolch(), "Minzräuber " + id, 0, 0, 0, CharacterState.ALIVE, new HashSet<Skill>(), new Position(locality));
    }

    @Override
    public boolean isFriendly(RPGCharacter character) {
        return character instanceof Minzraeuber;
    }

}
