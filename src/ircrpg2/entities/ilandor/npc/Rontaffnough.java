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
import ircrpg2.entities.ilandor.items.Punktfeuer;

/**
 *
 * @author testi
 */
public class Rontaffnough extends NPCCommon {

    @Override
    public boolean isFriendly(RPGCharacter character) {
        return character == this;
    }

    public Rontaffnough(World world, Locality locality) {
        super(world, 46, locality, new Punktfeuer(), null, "Der böse Magier Rontaffnough");
        //super(world, locality,"Mortera der Magier");
        new BlitzaugenMagier().init(this);
        HumanEquipment.equip(this);
    }



}
