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
public class Diamantenjaeger extends NPCCommon {

    @Override
    public boolean isFriendly(RPGCharacter character) {
        return character instanceof Diamantenjaeger;
    }

    public Diamantenjaeger(World world, Locality locality, int id) {
        super(world, 16, locality, new GeschaerftesLangschwert(), null, "Diamantenjäger " + id);
        HumanEquipment.equip(this);
        //super(world, 200, 200, 30, locality, new GeschaerftesLangschwert(), null, "Diamantenjäger " + id, 0, 0, 0, CharacterState.ALIVE, new HashSet<Skill>(), new Position(locality));
    }

}
