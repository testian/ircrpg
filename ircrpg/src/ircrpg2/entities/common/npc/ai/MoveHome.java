/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.common.npc.ai;

import ircrpg2.ai.ShortestPath;
import ircrpg2.ai.Target;
import ircrpg2.core.Locality;
import ircrpg2.core.Position;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.RPGException;
import java.util.List;

/**
 *
 * @author testi
 */
public class MoveHome implements Target {

    private RPGCharacter subject;
    private ShortestPath sp;

    public MoveHome(RPGCharacter subject) {
        this.subject = subject;
        sp = new ShortestPath(getNearestLocality(subject.getPosition()),subject.getHome());
    }

    public void followTarget() {
    sp.setStart(getNearestLocality(subject.getPosition()));
        List<Locality> path = sp.getPath();
        if (path == null) {return;}
        if (path.size() <= 1) return;

        if (subject.isMoving()) return;
        try {
         if (subject.getPosition().isOnPath()) {
         subject.move(path.get(0));
         } else {
             subject.move(path.get(1));
         }
         }


        catch (RPGException ex) {

        }

    }

    public boolean satisfied() {
        return subject.getPosition().getLocation() == subject.getHome();
    }

    private Locality getNearestLocality(Position position) {
    if (!position.isOnPath()) return (Locality)position.getLocation();

    if (position.getProgress()>0.5) {
    return position.getDestination();
    }
    else {
    return position.getStart();
    }
    }
    public boolean related(Object o) {
    return o == subject;
    }

}
