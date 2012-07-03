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
public class Holzfaellerhuette extends DefaultLocality implements Store {

    public void use(RPGCharacter user) throws RPGException {
        store.use(user);
    }
    private Store store;


    public Selection getSelection() {
        return store.getSelection();
    }
    public Holzfaellerhuette() {
    super("Holzfällerhütte");
    store = new StoreCommon() {

            public String getName() {
                return Holzfaellerhuette.this.getName();
            }

            public Selection getSelection() {
                Map<Class<? extends Item>, PricePair> list = new HashMap<Class<? extends Item>, PricePair>();
                list.put(BuchDerForstwirtschaft.class,new PricePair(200,10));
                list.put(Holzfaelleraxt.class,new PricePair(200,10));
                list.put(Holzscheit.class,new PricePair(30,20));
                list.put(Harz.class,new PricePair(Long.MAX_VALUE,70));
                list.put(StaerketrankRezept.class,new PricePair(400,10));
                list.put(Reparaturkit.class, new PricePair(300,50));
                return new SelectionCommon(list);
            }

    };
    }

}
