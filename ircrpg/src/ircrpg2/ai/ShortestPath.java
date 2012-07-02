/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.ai;
import ircrpg2.core.Locality;
import ircrpg2.core.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/**
 *
 * @author testi
 */
public class ShortestPath {
private Locality start;
private Locality stop;
private LinkedList<Locality> path;

    public ShortestPath(Locality start, Locality stop) {
        this.start = start;
        this.stop = stop;
        path = null;
    }

    public void setStart(Locality start) {
        this.start = start;
    }

    public void setStop(Locality stop) {
        this.stop = stop;
    }


    /**
     *
     * @return null if the localities are not connected, the shortest path from start to stop otherwise
     */
public List<Locality> getPath() {
    if (path == null) calculatePath();
    else if (path.getFirst() != start || path.getLast() != stop) {
    if (path.size()>1 && path.get(1) == start)
        path.removeFirst();


    if (path.size()>1 && path.get(path.size()-2) == stop)
    path.removeLast();
    if (path.getFirst() != start || path.getLast() != stop) {calculatePath();}
    }
    if (path == null) return null;
    LinkedList<Locality> copy = new LinkedList<Locality>();

    for (Locality l : path) {
    copy.addLast(l);
    }

    return copy;
}

private void calculatePath() { //TODO: actually calculate the SHORTEST

Set<Locality> visited = new HashSet<Locality>();


LinkedList<Locality> allPlaces = new LinkedList<Locality>();
LinkedList initPath = new LinkedList<Locality>();
initPath.add(start);
visited.add(start);
allPlaces.addLast(start);
Locality next = null;
Map<Locality,LinkedList<Locality>> pathMap = new HashMap<Locality,LinkedList<Locality>>();
pathMap.put(start,initPath);
try {
while ((next = allPlaces.removeFirst()) != stop) {
//System.out.println("Entering loop: " + next.getName());
for (Locality n : getUnvisitedNeighbours(next,visited)) {
allPlaces.addLast(n);
visited.add(n);
LinkedList<Locality> incompletePath = pathMap.get(next);
LinkedList<Locality> copy = (LinkedList<Locality>)incompletePath.clone();
copy.addLast(n);
pathMap.put(n, copy);
}
pathMap.remove(next);
}
} catch (NoSuchElementException ex) {

    //System.out.println("Debug spot 1");
    path = null;return;}



path = pathMap.get(stop);
//System.out.println("Debug spot finish");


}


public Set<Locality> getUnvisitedNeighbours(Locality l, Set<Locality> visited) {
Set<Locality> neighbours = new HashSet<Locality>();
for (Path p : l.getPaths()) {
for (Locality n : p.getLocalities()) {
if (!visited.contains(n) && l != n) {
neighbours.add(n);
}
}
}
return neighbours;
}


/*private LinkedList<Locality> path(Set<Locality> visited, Locality a, Locality b) {
if (a == b) return new LinkedList<Locality>();


Set<Locality> neighbours = getUnvisitedNeighbours(a,visited);


LinkedList<Locality> shortestPath = null;

for (Locality n : neighbours) {
visited.add(n);
LinkedList<Locality> subPath = path(visited,n,b);
if (subPath != null) {
if (shortestPath == null || shortestPath.size()>subPath.size()) {
shortestPath = subPath;
}
}
visited.remove(n);
}
if (shortestPath == null) return null;

LinkedList<Locality> newPath = new LinkedList<Locality>();
newPath.addAll(shortestPath);
return newPath;

}*/



}
