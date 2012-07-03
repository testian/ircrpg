/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.locations;

import ircrpg2.core.Resource;
import ircrpg2.core.ResourceBase;
import ircrpg2.entities.common.DefaultLocality;
import ircrpg2.entities.common.ResourceCommon;
import ircrpg2.entities.ilandor.items.Kuryllin;
import ircrpg2.entities.ilandor.skills.Bauer;

/**
 *
 * @author testi
 */
public class Kuryllinfeld extends DefaultLocality implements ResourceBase {
    private ResourceCommon resource;
    public Kuryllinfeld() {
    super("Kyrillinfeld");
    resource = new ResourceCommon();
    resource.addItemResource(Kuryllin.class, 10, 20, Bauer.class);
    }

    public Resource getResource() {
    return resource;
    }
}
