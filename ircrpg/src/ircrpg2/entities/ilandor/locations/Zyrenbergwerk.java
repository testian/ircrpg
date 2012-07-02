/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.locations;

import ircrpg2.core.Resource;
import ircrpg2.core.ResourceBase;
import ircrpg2.entities.common.DefaultLocality;
import ircrpg2.entities.common.ResourceCommon;
import ircrpg2.entities.ilandor.items.Diamant;
import ircrpg2.entities.ilandor.items.Eisenerz;
import ircrpg2.entities.ilandor.items.Esperit;
import ircrpg2.entities.ilandor.items.Goldbrocken;
import ircrpg2.entities.ilandor.items.Silberstraehne;
import ircrpg2.entities.ilandor.items.Spitzhacke;
import ircrpg2.entities.ilandor.skills.Minenarbeiter;

/**
 *
 * @author simulity
 */
public class Zyrenbergwerk extends DefaultLocality implements ResourceBase{
    ResourceCommon resource;
    public Zyrenbergwerk(){
        super("Bergwerk am Zyren");
        resource = new ResourceCommon();
        resource.addItemResource(Esperit.class, 2, 50, Minenarbeiter.class, Spitzhacke.class);
        resource.addItemResource(Diamant.class, 2, 50, Minenarbeiter.class, Spitzhacke.class);
        resource.addItemResource(Goldbrocken.class, 3, 50, Minenarbeiter.class, Spitzhacke.class);
    }
    public Resource getResource() {
        return resource;
    }

}
