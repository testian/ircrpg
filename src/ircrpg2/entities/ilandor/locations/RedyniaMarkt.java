/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.locations;
import java.util.*;
import ircrpg2.core.*;
import ircrpg2.entities.common.*;
import ircrpg2.entities.ilandor.items.*;
/**
 *
 * @author testi
 */
public class RedyniaMarkt extends DefaultLocality implements Store {

    public void use(RPGCharacter user) throws RPGException {
        store.use(user);
    }
    Store store;

    public Selection getSelection() {
        return store.getSelection();
    }
    public RedyniaMarkt() {
    super("Redynia-Markt");
    store = new StoreCommon() {

            public String getName() {
                return RedyniaMarkt.this.getName();
            }

            public Selection getSelection() {
                Map<Class<? extends Item>, PricePair> list = new HashMap<Class<? extends Item>, PricePair>();
                list.put(Kurzschwert.class,new PricePair(300,150));
                list.put(Spitzhacke.class,new PricePair(200,100));
                list.put(Holzbogen.class,new PricePair(500,250));
                list.put(KleinerHeiltrank.class,new PricePair(30,10));
                list.put(KleinerManatrank.class,new PricePair(100,30));

                list.put(LeereFlasche.class, new PricePair(5,1));

                list.put(GrosserHeiltrank.class,new PricePair(90,10));
                list.put(GrosserManatrank.class,new PricePair(280,90));


                list.put(Langschwert.class,new PricePair(500,250));
                list.put(Holzschild.class,new PricePair(120,40));
                list.put(Eisenschild.class,new PricePair(350,175));
                list.put(Weizensack.class,new PricePair(15,5));
                list.put(Brot.class,new PricePair(20,15));
                list.put(BrotRezept.class,new PricePair(40,5));
                list.put(GrosseTasche.class,new PricePair(1000,500));
                list.put(Eisenhelm.class, new PricePair(200,100));
                list.put(Lederbeinkleidung.class, new PricePair(55,25));
                list.put(Stahlbeine.class, new PricePair(200,100));
                list.put(Lederjacke.class, new PricePair(60,25));
                list.put(LederneHandschuhe.class, new PricePair(45,25));
                list.put(Lederschuhe.class, new PricePair(40,25));
                list.put(TeleportRedyniaSpruchrolle.class,new PricePair(1000,100));
                list.put(Stahlbrustpanzer.class, new PricePair(300,150));
                return new SelectionCommon(list);
            }

    };
    }
}