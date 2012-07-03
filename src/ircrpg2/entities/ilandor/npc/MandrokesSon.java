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
public class MandrokesSon extends Mandrokian {

    @Override
    public boolean isFriendly(RPGCharacter character) {
        return character instanceof Banditian;
    }

    public MandrokesSon(World world, Locality locality) {
        super(world, 5, locality, new Kurzschwert(), null, "Mandroke's Sohn");
        HumanEquipment.equip(this);
        //super(world, 90, 90, 30, locality, new Kurzschwert(), null, "Mandroke's Sohn", 0, 0, 0, CharacterState.ALIVE, new HashSet<Skill>(), new Position(locality));
    }

}
