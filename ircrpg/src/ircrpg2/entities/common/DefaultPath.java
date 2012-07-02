/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.common;
import java.util.*;
import ircrpg2.core.*;
/**
 *
 * @author testi
 */
public class DefaultPath implements Path {

private String name;
private int length;
private HashSet<Locality> localities;
public DefaultPath(String name, int length) {
this.name = name;
this.length = length;
localities = new HashSet<Locality>();
}
public void addLocality(Locality locality) {
if (localities.size()<2) {
localities.add(locality);
}
}
public void setLocalities(Locality locality1, Locality locality2) {
localities.clear();
localities.add(locality1);
localities.add(locality2);
}
public Set<Locality> getLocalities() {
        return this.localities;
}

    public double getLength() {
        return length;
    }

    public String getName() {
        return name;
    }

}
