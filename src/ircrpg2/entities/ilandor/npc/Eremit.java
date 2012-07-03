/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.npc;

import ircrpg2.core.Locality;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.World;
import ircrpg2.entities.common.NPCCommon;
import ircrpg2.entities.ilandor.items.HumanEquipment;
import ircrpg2.entities.ilandor.items.Langschwert;

/**
 *
 * @author simulity
 */
public class Eremit extends NPCCommon{

    @Override
    public boolean isFriendly(RPGCharacter character) {
        return character instanceof Eremit;
    }
    public Eremit(World world, Locality locality){
        super(world, 11, locality, new Langschwert(), null, "Verrückter Eremit");
        HumanEquipment.equip(this);
        //super(world, 160, 160, 20, locality, new Langschwert(), null, "Verrückter Eremit", 0, 0, 0, CharacterState.ALIVE, new HashSet<Skill>(), new Position(locality));
    }
}
