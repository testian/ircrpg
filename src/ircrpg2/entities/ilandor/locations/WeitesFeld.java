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
public class WeitesFeld extends DefaultLocality implements ResourceBase {
    ResourceCommon resource;
    public WeitesFeld() {
    super("Weites Feld");
    resource = new ResourceCommon();
    resource.addItemResource(Weizensack.class, 50, 50, Bauer.class);
    }

    public Resource getResource() {
    return resource;
    }

}
