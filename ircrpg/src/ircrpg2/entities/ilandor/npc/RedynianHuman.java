/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.npc;

import ircrpg2.core.CharacterState;
import ircrpg2.core.Locality;
import ircrpg2.core.Position;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.Skill;
import ircrpg2.core.World;
import ircrpg2.entities.common.NPCCommon;
import ircrpg2.entities.ilandor.items.Dolch;
import ircrpg2.entities.ilandor.items.GeschaerftesLangschwert;
import ircrpg2.entities.ilandor.items.HumanEquipment;
import ircrpg2.entities.ilandor.items.Kurzschwert;
import ircrpg2.entities.ilandor.items.Langschwert;
import ircrpg2.entities.ilandor.items.Punktfeuer;
import java.util.HashSet;

/**
 *
 * @author testi
 *
 * This class is used for uniquely named humans that are redynians
 */
public class RedynianHuman extends RedynianCore {


    public RedynianHuman(World world, Locality locality, String name) {
        super(world, 100, 100, 30, locality, new Langschwert(), null, name, 0, 0, 0, CharacterState.ALIVE, new HashSet<Skill>(), new Position(locality));
        HumanEquipment.equip(this);
    }

    public RedynianHuman(World world, int level, Locality locality, String name) {
        super(world, level, locality,level < 5 ? (level < 1 ? new Dolch() : (level < 3 ? new Kurzschwert() : new Langschwert())) : new GeschaerftesLangschwert(), level < 15 ? null : (level < 20 ? new GeschaerftesLangschwert() : new Punktfeuer()),name);
        HumanEquipment.equip(this);
        //super(world, 100+10*level, 100+10*level, 30+10*level, locality, level < 5 ? new Langschwert() : new Langschwert(), level < 15 ? null : (level < 20 ? new GeschaerftesLangschwert() : new Punktfeuer()), name, 0, 0, 0, CharacterState.ALIVE, new HashSet<Skill>(), new Position(locality));
    }
}
