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
public class StringUtils {
public static Map<String, Integer> itemList(Set<Item> items) {
    Map<String,Integer> itemMap = new HashMap<String, Integer>();
    for (Item i : items) {
        if (itemMap.containsKey(i.getName())) {
        itemMap.put(i.getName(), itemMap.get(i.getName()) + 1);
        } else {
        itemMap.put(i.getName(), 1);
        }
    }
return itemMap;
}
}
