/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.common.npc.ai;

import ircrpg2.core.AssistBehaviour;
import ircrpg2.core.RPGCharacter;

/**
 *
 * @author testi
 */
public class TimeAssist extends Assist {

    private long finishTime;
    public TimeAssist(RPGCharacter subject, RPGCharacter target, AssistBehaviour ab, long time) {
        super(subject, target, ab);
        finishTime = (System.currentTimeMillis()/1000)+time;
    }

    @Override
    public boolean satisfied() {
        return System.currentTimeMillis()/1000>finishTime;
    }


}
