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
public class Leiterbasar extends DefaultLocality implements Store {

    public void use(RPGCharacter user) throws RPGException {
        store.use(user);
    }
    Store store;

    public Selection getSelection() {
        return store.getSelection();
    }
    public Leiterbasar() {
    super("Leiter-Basar");
    store = new StoreCommon() {

            public String getName() {
                return Leiterbasar.this.getName();
            }

            public Selection getSelection() {
                Map<Class<? extends Item>, PricePair> list = new HashMap<Class<? extends Item>, PricePair>();
                list.put(Kurzschwert.class,new PricePair(280,140));
                list.put(Morgenstern.class,new PricePair(370,185));
                list.put(Spitzhacke.class,new PricePair(200,100));
                list.put(Holzbogen.class,new PricePair(500,250));
                list.put(KleinerHeiltrank.class,new PricePair(40,15));
                list.put(KleinerManatrank.class,new PricePair(80,30));
                list.put(LeereFlasche.class, new PricePair(5,1));

                list.put(GrosserHeiltrank.class,new PricePair(90,10));
                list.put(GrosserManatrank.class,new PricePair(240,90));


                list.put(Langschwert.class,new PricePair(450,225));
                list.put(Holzschild.class,new PricePair(100,40));
                list.put(Eisenschild.class,new PricePair(300,150));
                list.put(Weizensack.class,new PricePair(20,15));
                list.put(Brot.class,new PricePair(30,25));
                list.put(BrotRezept.class,new PricePair(40,5));
                list.put(GrosseTasche.class,new PricePair(1000,500));
                list.put(Eisenhelm.class, new PricePair(180,90));
                list.put(Lederbeinkleidung.class, new PricePair(50,22));
                list.put(Stahlbeine.class, new PricePair(200,100));
                list.put(Lederjacke.class, new PricePair(60,25));
                list.put(LederneHandschuhe.class, new PricePair(45,25));
                list.put(Lederschuhe.class, new PricePair(40,25));
                list.put(Reparaturkit.class, new PricePair(220,60));
                list.put(Verstaerkungskit.class, new PricePair(600,180));
                list.put(GrossesVerstaerkungskit.class, new PricePair(1200,180));
                list.put(TeleportLeiterstadtSpruchrolle.class,new PricePair(1000,100));
                list.put(Stahlbrustpanzer.class, new PricePair(300,150));
                return new SelectionCommon(list);
            }

    };
    }
}