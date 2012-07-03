/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.locations;

import ircrpg2.core.Locality;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.RPGException;
import ircrpg2.core.Usable;
import ircrpg2.entities.common.DefaultLocality;

/**
 *
 * @author testi
 */
public class Teleport extends DefaultLocality implements Usable {

    private Locality destination;
    public void use(RPGCharacter user) throws RPGException {
        user.allMsg(user.getName() + " benützt das Teleportal " + this.getName() + ".");
        user.reach(destination);
    }

    public Teleport(String name, Locality destination) {
        super(name);
        this.destination = destination;
    }

}
