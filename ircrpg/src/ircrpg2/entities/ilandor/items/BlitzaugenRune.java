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
public class BlitzaugenRune extends ItemCommon {

    public String getName() {
        return "Rune Blitzaugen";
    }

    public int getWeight() {
        return 500;
    }

    public void onItemRemoved(RPGCharacter user) {
    }

    @Override
    public String itemInfo() {
        return super.itemInfo() + ". Für Magier. Fügt dem Ziel in einer Reichweite von bis zu 500 Metern bis zu 1500 Schaden zu. Benötigt 500 Mana.";
    }


    public void use(RPGCharacter user) throws RPGException {
    Skill m = user.getSkill(Magier.class);
    if (m == null) {
    user.msg("Du bist kein Magier.");
    return;
    }
    /*if (m.getProgress() < 200) {
    user.msg("Du brauchst 20% Erfahrung in Magie!");
    return;
    }*/

        m.increase(new Blitzaugen().cast(user));

    }

}
