/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.common.npc.ai;

import ircrpg2.ai.ShortestPath;
import ircrpg2.ai.Target;
import ircrpg2.core.AttackBehaviour;
import ircrpg2.core.CharacterState;
import ircrpg2.core.Locality;
import ircrpg2.core.Location;
import ircrpg2.core.Path;
import ircrpg2.core.Position;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.RPGException;
import ircrpg2.core.Util;
import ircrpg2.core.World;
import java.util.List;
import java.util.Timer;

/**
 *
 * @author testi
 */
public class FindAndKill implements Target {

    private RPGCharacter subject;
    private RPGCharacter target;
    private boolean surrender;
    private ShortestPath sp;
    private AttackBehaviour ab;
    //private long lastMove;

    public FindAndKill(RPGCharacter subject, RPGCharacter target, AttackBehaviour ab) {
        this.subject = subject;
        this.target = target;
        this.ab = ab;
        sp = new ShortestPath(getNearestLocality(subject.getPosition()),getNearestLocality(target.getPosition()));
    //lastMove = 0;
    }

    private void trimPath(Position s, Position t, List<Locality> path) {
    if (!s.isOnPath() && path.size()>0 && s.getLocation() == path.get(0))
    path.remove(0);
    else if (s.isOnPath() && (path.size() == 1 || (path.size()>1 && (s.getDestination() == path.get(1) || s.getStart() == path.get(1)))))
    path.remove(0);

    if (t.isOnPath() && (path.size() == 1 || (path.size() > 1 && (path.get(path.size()-2) == t.getStart() || path.get(path.size()-2) == t.getDestination()))) )
    path.remove(path.size()-1);
    }
    /**
     *
     * @return true if attack was executed or in progress, false otherwise
     */
    private boolean tryAttack() {
        AttackBehaviour.AttackResult simulation = ab.simulateAttack(subject, target);
        if (simulation == AttackBehaviour.AttackResult.NO_DAMAGE || simulation == AttackBehaviour.AttackResult.SUCCESSFUL) {

       AttackBehaviour.AttackResult execution = ab.attack(subject, target);

        if (execution == AttackBehaviour.AttackResult.NO_DAMAGE && simulation == AttackBehaviour.AttackResult.NO_DAMAGE) {

         surrender = true;
         
         }
        return execution == execution.SUCCESSFUL || execution == execution.NO_DAMAGE || execution == execution.IN_PROGRESS;
        }
        return false;
    }
    private boolean attack() {
        AttackBehaviour.AttackResult simulation = ab.simulateAttack(subject, target);
        AttackBehaviour.AttackResult execution = ab.attack(subject, target);

        if (execution == AttackBehaviour.AttackResult.NO_DAMAGE && simulation == AttackBehaviour.AttackResult.NO_DAMAGE) {

         surrender = true;

         }
        return execution == execution.SUCCESSFUL || execution == execution.NO_DAMAGE || execution == execution.IN_PROGRESS;
    }
    private void followPath(Position spos, List<Locality> path) {

        if (!spos.isOnPath() || !subject.isMoving() || path.get(0) != spos.getDestination()) {
        move(path.get(0));
        }
        
    }

    private boolean move(Locality loc) {
    /*long time = System.currentTimeMillis();
    if ((subject.isMoving() || target.isMoving()) && time-lastMove<5000) {
    subject.msg("Enforcing movement relaxation");
    return false;
    }*/

    //lastMove = time;
    try {subject.move(loc);} catch (RPGException ex) {
    subject.msg(subject.getName() + ", " + ex.getMessage() + ".");
    return false;
    }
    return true;
    }

    public void followTarget() {
        Position spos = subject.getPosition();
        Position tpos = target.getPosition();
        sp.setStart(getNearestLocality(spos));
        sp.setStop(getNearestLocality(tpos));
        List<Locality> path = sp.getPath();
        if (path == null) {surrender = true;return;}
        trimPath(spos,tpos, path);
        subject.msg("Proceed to kill target " + target.getName());
        if (tryAttack() || surrender) return;
        if (path.size() < 1) {
        if (attack() || surrender) return;
        subject.msg("Required to execute an approaching attack on " + target.getName());
        approachAttack(spos,tpos);
        return;
        }

        //precondition: path.size() is at least 1 and points at first to the location where the character should go
        if (( subject.isMoving() || target.isMoving()) && path.size() == 1) return; //Wait until the target or i is at some location or stops
        subject.msg("Following the path to " + target.getName());
        followPath(spos, path);



        

        
    }

    @Override
    public boolean equals(Object o) {
    if (o == null || !(o instanceof FindAndKill)) return false;
    FindAndKill other = (FindAndKill)o;
    return (other.subject == subject && other.target == target);
    }

    public boolean satisfied() {
        return target.getState() == CharacterState.DEAD || surrender;
    }


    private void approachAttack(Position subjectPosition, Position targetPosition) {
    //if (subject.isMoving()) return; //can't work with that precondition yet
    //double divisor = 1.0;
    /*//if (target.isMoving()) return; //Simply avoid cycles
    if (target.isMoving() && targetPosition.getDestination() == subjectPosition.getLocation()) {
    divisor = 2.0;
    return; //Since the target is coming towards us all we have to do is wait.
    }
    else if (target.isMoving()) {
    move(targetPosition.getDestination());
    return;
    } else if (target.isMoving()) {
    subject.stop();
    return;
    }*/
    //The cases that are to be distinguished: target is moving towards us, target is moving away from us, target stays
    //These can be distinguished in case the following precondition applies: target is max 1 locality away




    Locality dest = localityInDirectionOf(subjectPosition,targetPosition);
    double timeDistance = targetPosition.getDistance(subjectPosition);
    if (!target.isMoving()) { //First case - target is staying
    //reaction go to target and attack when on height of target
    if (move(dest) && targetPosition.isOnPath()) { //Only in case target is on path the timer is required
    timedAttack(timeDistance);
    }
        return;
    }
    else if (targetPosition.getDestination() == dest) { //Second case - target is going away from us
        //reaction just move to the same location as target
        move(dest);
    }
    else { //Third case: Target is coming towards us
    timeDistance = timeDistance/2.0;
    move(dest); //Instead of dividing timeDistance by 2.0 it can be left unmodified in case move(dest) remains unused
    timedAttack(timeDistance);
    }



    
    /*if (targetPosition.getDestination() != subjectPosition.getLocation()) {
        dest = targetPosition.getDestination();
    }*/
    
    //if (!move(dest)) return;
    
    

    }
    private void timedAttack(double timeDistance) {
        Timer timer = new Timer();
    final RPGCharacter ttarget = target;
    final RPGCharacter tsubject = subject;
    final World world = tsubject.getWorld();
    if (timeDistance == Double.MAX_VALUE) return;
    long delay = (long)(timeDistance*1000.0);
    if (delay<1) delay = 1;
    else if (delay>1000*3600) delay = 1000*3600;
    timer.schedule(Util.tott(world.entailTask(new Runnable() {

            @Override
            public void run() {
                    tsubject.msg("Executing Approach attack against: " + target.getName());
                    //attack();
                    AttackBehaviour.AttackResult sim = ab.simulateAttack(tsubject, ttarget);
                    AttackBehaviour.AttackResult exec = ab.attack(tsubject, ttarget);
                    if (sim == sim.SUCCESSFUL) tsubject.stop();
                    if (sim == exec && sim == sim.NO_DAMAGE) surrender = true;

            }

    })), (long)delay);
    }

    private Locality getNearestLocality(Position position) {
    if (!position.isOnPath()) return (Locality)position.getLocation();

    
    //return position.getDestination();
    if (position.getProgress()>0.5) {
    return position.getDestination();
    }
    else {
    return position.getStart();
    }
    }

    public boolean related(Object o) {
    return o == subject || o == target;
    }

    private Locality localityInDirectionOf(Position from, Position to) {
    if (!to.isOnPath())
        return (Locality)to.getLocation();
    if (!from.isOnPath()) {
    if (from.getLocation() == to.getDestination()) return to.getStart();
    else return to.getDestination();
    }
    if (from.getDestination() != to.getDestination()) {
    to = new Position((Path)to.getLocation(),to.getDestination(),to.getStart(),1.0-to.getProgress());
    }
    if (from.getDestination() != to.getDestination() || from.getStart() != to.getStart()) {
    return to.getDestination();
    }
    if (to.getProgress()>=from.getProgress()) return to.getDestination();
    return to.getStart();

    }
    

}
