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
public class FeuerwelleRune extends ItemCommon {

    public String getName() {
        return "Rune Feuerwelle";
    }

    public int getWeight() {
        return 500;
    }

    public void onItemRemoved(RPGCharacter user) {
    }

    @Override
    public String itemInfo() {
        return super.itemInfo() + ". Für Magier mit mindestens 20% Erfahrung. Fügt allen in einer Reichweite von 50 Metern bis zu 200 Schaden zu. Benötigt 100 Mana.";
    }


    public void use(RPGCharacter user) throws RPGException {
    Skill m = user.getSkill(Magier.class);
    if (m == null) {
    user.msg("Du bist kein Magier.");
    return;
    }
    if (m.getProgress() < 200) {
    user.msg("Du brauchst 20% Erfahrung in Magie!");
    return;
    }

        m.increase(new Feuerwelle().cast(user));

    }

}
