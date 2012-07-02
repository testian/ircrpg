/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.items;

import ircrpg2.core.RPGCharacter;
import ircrpg2.core.RPGException;

/**
 *
 * @author simulity
 */
public class Regeneration {
    public int cast(RPGCharacter user) throws RPGException {
        user.useMana(50);
        user.allMsg(user.getName() + " wirkt Regeneration.");
        int currentHP = user.getHealth();
        int maxHP = user.getMaxHealth();
        if(currentHP != maxHP){
            user.increaseHealth(maxHP - currentHP);
            //user.allMsg(user.getName() + " ist vollständig geheilt.");
            return 1;
        }
        return 0;
    }
}
