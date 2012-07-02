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
public class Wegelagerer extends NPCCommon {

    @Override
    public boolean isFriendly(RPGCharacter character) {
        return character instanceof Wegelagerer;
    }

    public Wegelagerer(World world, Locality locality, int id) {
        super(world, 2, locality, new Kurzschwert(), null, "Wegelagerer " + id);
                HumanEquipment.equip(this);
        //super(world, 60, 60, 20, locality, new Kurzschwert(), null, "Wegelagerer " + id, 0, 0, 0, CharacterState.ALIVE, new HashSet<Skill>(), new Position(locality));
    }

}
