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
public class ManazeitbombeRune extends ItemCommon {

    public String getName() {
        return "Rune Manazeitbombe";
    }

    public int getWeight() {
        return 500;
    }

    public void onItemRemoved(RPGCharacter user) {
    }

    @Override
    public String itemInfo() {
        return super.itemInfo() + ". Für Magier mit mindestens 30% Erfahrung. Wird an einem beliebigen Ort platziert. Explodiert nach 10 Minuten. Fügt allen in einer Reichweite von 100 Metern inklusive dem Bombenleger bis zu 400 Schaden zu. Benötigt 200 Mana.";
    }


    public void use(RPGCharacter user) throws RPGException {
    Skill m = user.getSkill(Magier.class);
    if (m == null) {
    user.msg("Du bist kein Magier.");
    return;
    }
    if (m.getProgress() < 300) {
    user.msg("Du brauchst 30% Erfahrung in Magie!");
    return;
    }

        new Manazeitbombe().cast(user);

    }

}
