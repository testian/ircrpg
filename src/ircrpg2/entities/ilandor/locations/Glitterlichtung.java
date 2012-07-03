/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.locations;

import ircrpg2.core.Resource;
import ircrpg2.core.ResourceBase;
import ircrpg2.entities.common.DefaultLocality;
import ircrpg2.entities.common.ResourceCommon;
import ircrpg2.entities.ilandor.items.Spitzhacke;
import ircrpg2.entities.ilandor.items.ZwielichtigeAuslieferungSpruchrolle;
import ircrpg2.entities.ilandor.skills.Minenarbeiter;

/**
 *
 * @author simulity
 */
public class Glitterlichtung extends DefaultLocality implements ResourceBase{
    ResourceCommon resource;
    public Glitterlichtung(){
        super("Die Lichtung im Zentrum");
        resource = new ResourceCommon();
        resource.addItemResource(ZwielichtigeAuslieferungSpruchrolle.class, 0.1, 0, Minenarbeiter.class, Spitzhacke.class);
        //resource.addItemResource(Schneeball.class, 0.1, 0, Foerster.class, Holzfaelleraxt.class);
    }
    public Resource getResource() {
        return resource;
    }

}
