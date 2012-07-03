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
public class Feuerplatz extends DefaultLocality implements ResourceBase {
    ResourceCommon resource;
    public Feuerplatz() {
    super("Feuerplatz");
    resource = new ResourceCommon();
    resource.addItemResource(Vitanit.class, 3, 20, Minenarbeiter.class, Spitzhacke.class);
    resource.addItemResource(Esperit.class, 3, 20, Minenarbeiter.class, Spitzhacke.class);
    resource.addItemResource(Fortanit.class, 3, 20, Minenarbeiter.class, Spitzhacke.class);
    resource.addItemResource(HeilzauberRune.class, 0.1, 100, Minenarbeiter.class, Spitzhacke.class);
    resource.addItemResource(FeuerwelleRune.class, 0.1, 110, Minenarbeiter.class, Spitzhacke.class);
    resource.addItemResource(ManazeitbombeRune.class, 0.1, 120, Minenarbeiter.class, Spitzhacke.class);
    resource.addItemResource(DiamantenpanzerRezept.class, 0.1, 130, Minenarbeiter.class, Spitzhacke.class);
    }

    public Resource getResource() {
    return resource;
    }

}
