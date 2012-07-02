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
public interface Location extends Named {
    /**
     *
     * @return the Localities that are reachable from this location
     */
    public Set<Locality> getLocalities();
    //public String getName();
}
