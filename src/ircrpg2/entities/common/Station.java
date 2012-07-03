/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.common;

import ircrpg2.core.Locality;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.RPGException;
import ircrpg2.core.Usable;

/**
 *
 * @author testi
 */
public class Station extends DefaultLocality implements Usable {
    private Transport transport;
    public Station(String name) {
        super(name);
        transport = null;
    }
    public void setTransport(Transport transport) {
    this.transport = transport;
    }

    public void use(RPGCharacter user) throws RPGException {
        if (transport == null) throw new IllegalStateException("station was never added to a transport");
        
        try {
        Locality c = transport.currentStation();
        if (c == this) {user.reach(transport);}
        } finally {
        transport.printTimeTable(user);
        }
    }

}
