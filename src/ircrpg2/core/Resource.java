/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;
import java.util.*;
/**
 *
 * @author testi
 */
public interface Resource {
public void harvest(RPGCharacter harvester) throws RPGException;
public void harvest(RPGCharacter harvester, Class<? extends Item> itemClass) throws RPGException;
public Set<Class<? extends Item>> itemsAvailable(RPGCharacter harvester);
}
