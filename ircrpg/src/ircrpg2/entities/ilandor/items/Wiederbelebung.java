/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.items;

import ircrpg2.core.CharacterState;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.RPGException;

/**
 *
 * @author simulity
 */
public class Wiederbelebung {
    public int cast(RPGCharacter user, RPGCharacter target) throws RPGException{
        if (target == null) throw new RPGException(RPGException.Type.NO_TARGET);
        int mana = (target.getLevel()+4)*10;
        double distance = user.getPosition().getDistance(target.getPosition());
        
        
        if (target.getState() == CharacterState.DEAD && distance <= 200){
            user.useMana(mana);
            user.allMsg(user.getName() + " wirkt Wiederbelebung auf " + target.getName() + ".");
            //target.allMsg(target.getName() + " wurde wiederbelebt.");
            target.revive(mana);
            return target.getLevel()+1;
        } else {
            if (user.getState() != CharacterState.DEAD) user.msg(user.getName() + " ist nicht tot.");
            throw new RPGException(RPGException.Type.OUT_OF_RANGE);
        }
    }
}
