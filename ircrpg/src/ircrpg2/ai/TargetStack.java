/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.ai;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author testi
 */
public class TargetStack {
private LinkedList<Target> targets;
private Target rootTarget;
public TargetStack() {
targets = new LinkedList<Target>();
rootTarget = null;
}

    public void setRootTarget(Target rootTarget) {
        this.rootTarget = rootTarget;
    }

public void addTarget(Target target) {

    Target equal = removeEqual(target);
    targets.addLast(equal);
    cleanSatisfied();
}
private Target removeEqual(Target t) {
Iterator<Target> i = targets.iterator();
Target last = t;
while (i.hasNext()) {
Target next = i.next();
if (next.equals(t)) {last = next; i.remove();}
}
return last;
}
private void cleanSatisfied() {
Iterator<Target> i = targets.iterator();
while (i.hasNext()) {
if (i.next().satisfied()) i.remove();
}
}
public void proceed() {
int size = targets.size();
cleanSatisfied();
if (!targets.isEmpty()) {targets.getLast().followTarget();
if (top().satisfied()) discard();
if (size>targets.size()) proceed(); //Since the target has changed, there is hope that immediately proceeding is possible.
}
else if (rootTarget != null) {rootTarget.followTarget();}
}
public boolean fullySatisfied() {
cleanSatisfied();
return (targets.isEmpty() && (rootTarget == null || rootTarget.satisfied()));
}

private Target top() {
if (targets.isEmpty()) return rootTarget;
return targets.getLast();
}
public void discard() {
if (targets.isEmpty()) return;
targets.removeLast();
}
public void reset() {
targets.clear();
}

public boolean contains(Target t) {
cleanSatisfied();
return targets.contains(t);
}
public boolean related(Object o) {
cleanSatisfied();
Target top = top();
if (top == null) return false;

return top.related(o);
}

}
