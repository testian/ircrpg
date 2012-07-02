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
public interface Selection {

    public void sell(RPGCharacter user, Class<? extends Item> item) throws RPGException;
    public void buy(RPGCharacter user, Class<? extends Item> item) throws RPGException;
    public void sell(RPGCharacter user, Class<? extends Item> item, int amount) throws RPGException;
    public void buy(RPGCharacter user, Class<? extends Item> item, int amount) throws RPGException;
    public Map<Class<? extends Item>, PricePair> getItems() throws RPGException;

}
