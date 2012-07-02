/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.common;

import ircrpg2.core.RPGCharacter;
import ircrpg2.core.RPGException;
import ircrpg2.core.Usable;

/**
 *
 * @author testi
 */
public class Home extends DefaultLocality implements Usable {

    public Home(String name) {
        super(name);
    }

    public void use(RPGCharacter user) throws RPGException {
        user.setHome(this);
    }

}
