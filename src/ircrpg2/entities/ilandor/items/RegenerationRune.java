/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.items;

import ircrpg2.core.ItemCommon;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.RPGException;
import ircrpg2.core.Skill;
import ircrpg2.entities.ilandor.skills.Magier;

/**
 *
 * @author simulity
 */
public class RegenerationRune extends ItemCommon{

    public int getWeight() {
        return 500;
    }

    public void onItemRemoved(RPGCharacter user) {

    }

    public String getName() {
        return "Rune Regeneration";
    }

    @Override
    public String itemInfo() {
        return super.itemInfo() + ". Der Lebensretter für den sterbenden Magier. Heilt den zaubernden vollständig.";
    }

    public void use(RPGCharacter user) throws RPGException {
        Skill m = user.getSkill(Magier.class);
        if(m == null){
            user.msg("Du bist kein Magier.");
            return;
        }else{
            m.increase(new Regeneration().cast(user));
        }
    }

}
