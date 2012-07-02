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
public class Wuestenbandit extends NPCCommon {

    @Override
    public boolean isFriendly(RPGCharacter character) {
        return character instanceof Wuestenbandit;
    }

    public Wuestenbandit(World world, Locality locality, int id) {
        super(world,6, locality, new Langschwert(), null, "Wüstenbandit " + id);
                HumanEquipment.equip(this);
        //super(world, 100, 100, 30, locality, new Langschwert(), null, "Wüstenbandit " + id, 0, 0, 0, CharacterState.ALIVE, new HashSet<Skill>(), new Position(locality));
    }

}
