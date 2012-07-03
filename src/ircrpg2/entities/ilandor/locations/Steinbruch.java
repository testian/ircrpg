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
public class Steinbruch extends DefaultLocality implements ResourceBase {
    ResourceCommon resource;
    public Steinbruch() {
    super("Der alte Steinbruch");
    resource = new ResourceCommon();
    resource.addItemResource(Fortanit.class, 2, 50, Minenarbeiter.class, Spitzhacke.class);
    }

    public Resource getResource() {
    return resource;
    }

}
