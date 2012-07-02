/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.npc;
import ircrpg2.core.*;
import ircrpg2.entities.common.NPCCommon;

import ircrpg2.entities.ilandor.items.*;
import java.util.*;
/**
 *
 * @author testi
 */
public class Banditenwache extends NPCCommon implements Banditian {

    @Override
    public boolean isFriendly(RPGCharacter character) {
        return character instanceof Banditian;
    }

    public Banditenwache(World world, Locality locality, int id) {
        super(world, 7, locality, new Langschwert(), null, "Banditenwache " + id);
        HumanEquipment.equip(this);
    }

}
