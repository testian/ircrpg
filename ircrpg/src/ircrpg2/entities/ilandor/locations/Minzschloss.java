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
public class Minzschloss extends DefaultLocality implements ResourceBase {
    ResourceCommon resource;
    public Minzschloss() {
    super("Minzschloss am Berg");
    resource = new ResourceCommon();
    //resource.addItemResource(Goldbrocken.class, 1, 100, Minenarbeiter.class, Spitzhacke.class);
    //resource.addItemResource(Silberstraehne.class, 2, 50, Minenarbeiter.class, Spitzhacke.class);
    resource.addItemResource(BlitzaugenRune.class, 0.05, 0, Minenarbeiter.class, Spitzhacke.class);
    resource.addItemResource(AuslieferungSpruchrolle.class, 0.05, 0, Minenarbeiter.class, Spitzhacke.class);
    }

    public Resource getResource() {
    return resource;
    }

}
