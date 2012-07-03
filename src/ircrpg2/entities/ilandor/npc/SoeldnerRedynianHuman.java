/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.npc;

import ircrpg2.core.Locality;
import ircrpg2.core.World;
import ircrpg2.entities.ilandor.items.GeschaerftesLangschwert;
import ircrpg2.entities.ilandor.items.Holzbogen;
import ircrpg2.entities.ilandor.items.HumanEquipment;

/**
 *
 * @author testi
 */
public class SoeldnerRedynianHuman extends RedynianHuman {

    public SoeldnerRedynianHuman(World world, int level, Locality locality, String name) {
        super(world, level, locality, name);
        this.increaseMana(20); //For teleports!
        this.setNPCBehaviour(new SoeldnerBehaviour((level+1),Math.min(level/2, 0)));

        //new Heiler().init(this);
        HumanEquipment.equip(this);
    }






}
