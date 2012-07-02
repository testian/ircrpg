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
public class WiederbelebungRune extends ItemCommon {

    public String getName() {
        return "Rune Wiederbelebung";
    }

    public int getWeight() {
        return 500;
    }

    public void onItemRemoved(RPGCharacter user) {
    }

    @Override
    public String itemInfo() {
        return super.itemInfo() + ". Für Magier. Belebt das tote Ziel wieder. Reichweite 200m. Benötigt im Normalfall soviel Mana wie das Ziel maximale Lebensenergie hat.";
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

        m.increase(new Wiederbelebung().cast(user,user.getTarget()));

    }

}
