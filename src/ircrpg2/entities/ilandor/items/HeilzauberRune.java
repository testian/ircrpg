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
public class HeilzauberRune extends ItemCommon {
    public HeilzauberRune() {
    super();
    }




    public String getName() {
        return "Rune Heilzauber";
    }

    public int getWeight() {
        return 500;
    }

    public String itemInfo() {
        return super.itemInfo() + ". Heilt das Ziel oder falls keine Auswahl getroffen sich selbst um 100 Punkte, sofern es sich in einer Reichweite von 100 Metern befindet. Benötigt 20 Mana";
    }


    public void onItemRemoved(RPGCharacter user) {
    }

    public void use(RPGCharacter user) throws RPGException {
    Skill m = user.getSkill(Magier.class);
    if (m == null) {
    user.msg("Du bist kein Magier.");
    return;
    }

    RPGCharacter target = user.getTarget();
    if (target == null) target = user;
    else {
    double distance = target.getPosition().getDistance(user.getPosition());
    if (distance > 100.0) {
        user.msg(target.getName() + " ist zu weit entfernt.");
        return;
    }
    }
    
    user.useMana(20);
    user.allMsg(user.getName() + " wirkt Heilzauber auf " + (target == user ? "sich selbst" : target.getName()) + ".");
    int healing = target.getHealth();
    target.increaseHealth(100);
    healing = target.getHealth()-healing;
    if (healing > 0) {
    m.increase(healing/20);
    }

        

    }

}
