/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.items;

import ircrpg2.core.CharacterState;
import ircrpg2.core.Locality;
import ircrpg2.core.Position;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.RPGException;

/**
 *
 * @author testi
 */
public class Auslieferung {


    public int cast(RPGCharacter s, Locality locality) throws RPGException {

        
        
        
        RPGCharacter target = s.getTarget();
        if (target == null) throw new RPGException(RPGException.Type.NO_TARGET);
        Position myP = s.getPosition();
        double distance = target.getPosition().getDistance(myP);
        if (target.getState() == CharacterState.DEAD)throw new RPGException(RPGException.Type.TARGET_DEAD);
        if (distance > 500.0) throw new RPGException(RPGException.Type.OUT_OF_RANGE);
        s.allMsg(s.getName() + " wendet Auslieferungszauber auf " + target.getName() + " an.");
        s.useMana(600);
        target.reach(locality);
        return 50;
        


       

    }
}
