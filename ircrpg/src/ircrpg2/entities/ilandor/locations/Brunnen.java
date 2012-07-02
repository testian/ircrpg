/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.locations;

import ircrpg2.core.Item;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.RPGException;
import ircrpg2.core.Usable;
import ircrpg2.entities.common.DefaultLocality;
import ircrpg2.entities.ilandor.items.LeereFlasche;
import ircrpg2.entities.ilandor.items.Quellwasser;

/**
 *
 * @author testi
 */
public class Brunnen extends DefaultLocality implements Usable {

    public Brunnen(String name) {
        super(name);
    }

    public void use(RPGCharacter user) throws RPGException {
        
        Item leereFlasche = null;
        int amount = 0;
        while((leereFlasche = user.getInventory().getItem(LeereFlasche.class)) != null){
        
        user.getInventory().removeItem(leereFlasche);
        try {
        user.getInventory().addItem(new Quellwasser());
        } catch (RPGException ex) {
        user.getInventory().addItem(leereFlasche);
        if (amount<1) throw ex;
        }
        amount++;
        }
        if (amount > 0) {
        user.allMsg(user.getName() + " füllt " + amount + " leere Flaschen mit Quellwasser.");
        } else {
        user.msg("Du hast keine leeren Flaschen.");
        }
    }

}
