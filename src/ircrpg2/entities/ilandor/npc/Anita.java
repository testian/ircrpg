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
public class Anita extends RedynianCore {



    public Anita(World world, Locality locality) {
        super(world, 9, locality, new GeschaerftesLangschwert(), new Holzbogen(), "Anita Hor");
        //super(world, locality,"Mortera der Magier");
        this.increaseMana(20); //For teleports!
        this.setNPCBehaviour(new SoeldnerBehaviour(5,3));
        //new Heiler().init(this);
        HumanEquipment.equip(this);
    }



}
