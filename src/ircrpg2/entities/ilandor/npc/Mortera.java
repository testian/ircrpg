/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.npc;

import ircrpg2.core.Locality;
import ircrpg2.core.World;
import ircrpg2.entities.ilandor.items.HumanEquipment;
import ircrpg2.entities.ilandor.items.Punktfeuer;

/**
 *
 * @author testi
 */
public class Mortera extends RedynianCore {



    public Mortera(World world, Locality locality) {
        super(world, 46, locality, new Punktfeuer(), null, "Mortera der Magier");
        //super(world, locality,"Mortera der Magier");
        new BlitzaugenMagier().init(this);
        HumanEquipment.equip(this);
    }



}
