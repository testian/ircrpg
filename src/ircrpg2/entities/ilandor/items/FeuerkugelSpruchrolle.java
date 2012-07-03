/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.items;

import ircrpg2.core.RPGCharacter;
import ircrpg2.core.RPGException;
import ircrpg2.core.Skill;
import ircrpg2.core.ItemCommon;
import ircrpg2.entities.ilandor.skills.Magier;

/**
 *
 * @author testi
 */
public class FeuerkugelSpruchrolle extends ItemCommon {
    private Feuerkugel feuerkugel;
    public FeuerkugelSpruchrolle() {
    super();
    feuerkugel = null;
    }




    public String getName() {
        return "Spruchrolle Feuerkugel";
    }

    public int getWeight() {
        return 500;
    }

    public void onItemRemoved(RPGCharacter user) {
    }

    public String itemInfo() {
        return super.itemInfo() + ". Kann einmal verwendet werden. Kann beliebig viel Schaden anrichten. Je nach Mana und Aufladungszeit. Reichweite 40m.";
    }

    public void use(RPGCharacter user) throws RPGException {

    if (feuerkugel == null)
        {
        Feuerkugel newKugel = new Feuerkugel();
        newKugel.cast(user,user.getTarget());
        feuerkugel = newKugel;
        
    }
    else {
    feuerkugel.cast(user,user.getTarget());
    feuerkugel = null;
    user.getInventory().removeItem(this);
    }
        

    }

}
