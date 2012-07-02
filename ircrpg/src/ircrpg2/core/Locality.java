/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;
import java.util.Set;
/**
 *
 * @author testi
 */
public interface Locality extends Location {
public Set<Path> getPaths();

public Path getPathTo(Locality o);
}
