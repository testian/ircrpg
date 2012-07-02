/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.common;
import ircrpg2.core.*;
import java.util.*;
/**
 *
 * @author testi
 */
public class DefaultLocality implements Locality {

private String name;
private HashSet<Path> paths;
public DefaultLocality(String name) {
this.name = name;
paths = new HashSet<Path>();
}
public void addPath(Path path) {
paths.add(path);
}
public void setPaths(Path... paths) {
this.paths.clear();
for (Path p : paths) {
this.paths.add(p);
}
}

public Set<Path> getPaths() {
        return this.paths;
}

    public Set<Locality> getLocalities() {
        Set<Locality> neighbours = new HashSet<Locality>();
        for (Path p : paths) {
        for (Locality l : p.getLocalities()) {
        if (this != l) { neighbours.add(l); break;}
        }
        }
        return neighbours;
    }

    public Path getPathTo(Locality o) {
    for (Path p : o.getPaths()) {
    if (paths.contains(p)) return p;
    }
    return null;
    }



    public String getName() {
        return name;
    }


}
