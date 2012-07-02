/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.npc;
import ircrpg2.core.*;
import ircrpg2.entities.common.*;
import ircrpg2.entities.ilandor.items.*;
/**
 *
 * @author testi
 */
public class Bandit extends NPCCommon implements Banditian {

    @Override
    public boolean isFriendly(RPGCharacter character) {
        return character instanceof Banditian;
    }

    public Bandit(World world, Locality locality, int id) {
        super(world, 5, locality, new Langschwert(), null, "Bandit " + id);
        HumanEquipment.equip(this);
        //super(world, 90, 90, 30, locality, new Langschwert(), null, "Bandit " + id, 0, 0, 0, CharacterState.ALIVE, new HashSet<Skill>(), new Position(locality));
    }

}
