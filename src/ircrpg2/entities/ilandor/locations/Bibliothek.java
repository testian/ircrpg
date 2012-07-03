/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.locations;
import ircrpg2.core.*;
import ircrpg2.entities.common.*;
import java.util.*;
import ircrpg2.entities.ilandor.items.*;
/**
 *
 * @author testi
 */
public class Bibliothek extends DefaultLocality implements Store {

    public void use(RPGCharacter user) throws RPGException {
        store.use(user);
    }
    Store store;

    public Selection getSelection() {
        return store.getSelection();
    }
    public Bibliothek() {
    super("Bibliothek");
    store = new StoreCommon() {

            public String getName() {
                return Bibliothek.this.getName();
            }

            public Selection getSelection() {
                Map<Class<? extends Item>, PricePair> list = new HashMap<Class<? extends Item>, PricePair>();
                list.put(BuchDerLandwirtschaft.class,new PricePair(0,0));
                list.put(BuchDerMinenarbeit.class, new PricePair(50,10));
                list.put(BuchDerSchmiede.class, new PricePair(50,10));
                list.put(BuchDerBaeckerei.class, new PricePair(0,0));
                return new SelectionCommon(list);
            }

    };
    }

}
