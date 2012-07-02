/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.npc;
import ircrpg2.core.*;
import ircrpg2.entities.ilandor.items.*;
/**
 *
 * @author testi
 */
public class Mandroke extends Mandrokian {

    @Override
    public boolean isFriendly(RPGCharacter character) {
        return character instanceof Banditian;
    }

    public Mandroke(World world, Locality locality) {
        super(world, 31, locality, new GeschaerftesLangschwert(), new Kurzschwert(), "Mandroke der Banditenführer");
        HumanEquipment.equip(this);
        //super(world, 350, 350, 60, locality, new GeschaerftesLangschwert(), new Kurzschwert(), "Mandroke, der Banditenführer", 0, 0, 0, CharacterState.ALIVE, new HashSet<Skill>(), new Position(locality));
    }

}
