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
public class MorgansLabor extends DefaultLocality implements Store {

    public void use(RPGCharacter user) throws RPGException {
        store.use(user);
    }
    Store store;

    public Selection getSelection() {
        return store.getSelection();
    }
    public MorgansLabor() {
    super("Morgan's Laboratorium");
    store = new StoreCommon() {

            public String getName() {
                return MorgansLabor.this.getName();
            }

            public Selection getSelection() {
                Map<Class<? extends Item>, PricePair> list = new HashMap<Class<? extends Item>, PricePair>();
                list.put(BuchDerAlchemie.class,new PricePair(200,100));
                list.put(LebenstrankRezept.class,new PricePair(400,10));
                list.put(Reparaturkit.class, new PricePair(350,50));

                list.put(KleinerHeiltrank.class,new PricePair(50,15));
                list.put(KleinerManatrank.class,new PricePair(80,30));
                list.put(LeereFlasche.class, new PricePair(5,1));

                list.put(GrosserHeiltrank.class,new PricePair(150,30));
                list.put(GrosserManatrank.class,new PricePair(220,80));
                list.put(TeleportMorgansLagerSpruchrolle.class,new PricePair(1000,100));

                return new SelectionCommon(list);
            }

    };
    }

}
