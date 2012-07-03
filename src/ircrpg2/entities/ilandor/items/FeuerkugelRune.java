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
public class FeuerkugelRune extends ItemCommon {
    private Feuerkugel feuerkugel;
    public FeuerkugelRune() {
    super();
    feuerkugel = null;
    }




    public String getName() {
        return "Rune Feuerkugel";
    }

    public int getWeight() {
        return 500;
    }

    public String itemInfo() {
        return super.itemInfo() + ". Ein Magier kann damit einem Gegner beliebig schaden. Je nach Mana und Aufladungszeit. Reichweite 40m.";
    }


    public void onItemRemoved(RPGCharacter user) {
    }

    public void use(RPGCharacter user) throws RPGException {
    Skill m = user.getSkill(Magier.class);
    if (m == null) {
    user.msg("Du bist kein Magier.");
    return;
    }

    if (feuerkugel == null)
        {
        Feuerkugel newKugel = new Feuerkugel();
        m.increase(newKugel.cast(user,user.getTarget()));
        feuerkugel = newKugel;
        
    }
    else {
    m.increase(feuerkugel.cast(user,user.getTarget()));
    feuerkugel = null;
    }
        

    }

}
