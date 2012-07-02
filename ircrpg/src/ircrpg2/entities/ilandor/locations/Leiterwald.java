/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.locations;
import ircrpg2.core.*;
import ircrpg2.entities.common.*;
import ircrpg2.entities.ilandor.items.*;
import ircrpg2.entities.ilandor.skills.*;
import ircrpg2.entities.common.ResourceCommon;
/**
 *
 * @author testi
 */
public class Leiterwald extends DefaultLocality implements ResourceBase {
    ResourceCommon resource;
    public Leiterwald() {
    super("Leiterwald");
    resource = new ResourceCommon();
    //resource.addItemResource(Goldbrocken.class, 1, 100, Minenarbeiter.class, Spitzhacke.class);
    //resource.addItemResource(Silberstraehne.class, 2, 50, Minenarbeiter.class, Spitzhacke.class);
    resource.addItemResource(Holzscheit.class, 10, 15, Foerster.class, Holzfaelleraxt.class);
    resource.addItemResource(Harz.class, 2, 25, Foerster.class, Holzfaelleraxt.class);
    resource.addItemResource(Myrtille.class, 2, 25, Foerster.class, Holzfaelleraxt.class);
    resource.addItemResource(HeilwelleSpruchrolle.class, 0.1, 0, Minenarbeiter.class, Spitzhacke.class);
    }

    public Resource getResource() {
    return resource;
    }

}
