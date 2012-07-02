/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.items;

import ircrpg2.core.CharacterState;
import ircrpg2.core.Destructive;
import ircrpg2.core.Library;
import ircrpg2.core.Position;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.RPGException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author testi
 */
public class Blitzaugen {


    public int cast(RPGCharacter s) throws RPGException {

        
        
        RPGCharacter target = s.getTarget();
        if (target == null) throw new RPGException(RPGException.Type.NO_TARGET);
        Position myP = s.getPosition();
        double distance = target.getPosition().getDistance(myP);
        if (target.getState() == CharacterState.DEAD) throw new RPGException(RPGException.Type.TARGET_DEAD);
        if (distance > 500.0) throw new RPGException(RPGException.Type.OUT_OF_RANGE);
        s.useMana(500);
        double relDamage = (1-distance/500.0);
        int damage = (int)(relDamage*0.9*1500.0) + 150;
        s.attack(target, new Destructive() {

            public DestructionType getType() {
                return DestructionType.MAGIC;
            }

            public String getName() {
                return "Blitzaugen";
            }

        }, damage);
        return damage/10;

    }
}
