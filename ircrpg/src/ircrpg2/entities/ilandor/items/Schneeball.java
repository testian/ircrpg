/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.items;

import ircrpg2.core.ItemCommon;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.RPGException;
import ircrpg2.core.Util;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simulity
 */
public class Schneeball extends ItemCommon{

    public int getWeight() {
        return 100;
    }

    public void onItemRemoved(RPGCharacter user) {

    }

    public String getName() {
        return "Schneeball";
    }

    public void use(final RPGCharacter user) throws RPGException {
        final Schneeball snowball = this;
        final RPGCharacter target = user.getTarget();
        user.allMsg(user.getName() + " wirft einen Schneeball in " + target.getName() + "s Richtung.");
        new Timer().schedule(Util.tott(user.getWorld().entailTask(new Runnable() {
            public void run(){
                user.allMsg(user.getName() + "s Schneeball trifft " + target.getName() + " voll im Gesicht.");
                try {
                    target.getInventory().addItem(snowball);
                } catch (RPGException ex) {
                    Logger.getLogger(Schneeball.class.getName()).log(Level.SEVERE, null, ex);
                }
            }



        })), 70*1000);
        user.getInventory().removeItem(this);
    }

}
