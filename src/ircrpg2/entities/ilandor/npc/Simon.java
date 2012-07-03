/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.npc;

import ircrpg2.core.Locality;
import ircrpg2.core.World;
import ircrpg2.entities.ilandor.items.GeschaerftesLangschwert;
import ircrpg2.entities.ilandor.items.HumanEquipment;
import ircrpg2.entities.ilandor.items.Kurzschwert;

/**
 *
 * @author testi
 */
public class Simon extends RedynianCore {



    public Simon(World world, Locality locality) {
        super(world, 15, locality, new GeschaerftesLangschwert(), new Kurzschwert(), "Simon Rettowka");
        //super(world, locality,"Mortera der Magier");
        this.setNPCBehaviour(new SoeldnerBehaviour(30,7));
        new Heiler().init(this);
        HumanEquipment.equip(this);
    }



}
