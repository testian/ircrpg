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
public class Horwald extends DefaultLocality implements ResourceBase {
    ResourceCommon resource;
    public Horwald() {
    super("Horwald");
    resource = new ResourceCommon();
    //resource.addItemResource(Goldbrocken.class, 1, 100, Minenarbeiter.class, Spitzhacke.class);
    //resource.addItemResource(Silberstraehne.class, 2, 50, Minenarbeiter.class, Spitzhacke.class);
    resource.addItemResource(Holzscheit.class, 10, 15, Foerster.class, Holzfaelleraxt.class);
    resource.addItemResource(Harz.class, 3, 25, Foerster.class, Holzfaelleraxt.class);
    resource.addItemResource(Myrtille.class, 1, 25, Foerster.class, Holzfaelleraxt.class);
    resource.addItemResource(FeuerwelleSpruchrolle.class, 0.1, 0, Minenarbeiter.class, Spitzhacke.class);
    }

    public Resource getResource() {
    return resource;
    }

}
