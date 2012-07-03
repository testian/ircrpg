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
public class RedyniaSchmiede extends DefaultLocality implements Store {

    public void use(RPGCharacter user) throws RPGException {
        store.use(user);
    }
    Store store;

    public Selection getSelection() {
        return store.getSelection();
    }
    public RedyniaSchmiede() {
    super("Schmiede von Redynia");
    store = new StoreCommon() {

            public String getName() {
                return RedyniaSchmiede.this.getName();
            }

            public Selection getSelection() {
                Map<Class<? extends Item>, PricePair> list = new HashMap<Class<? extends Item>, PricePair>();
                list.put(GeschaerftesLangschwertRezept.class, new PricePair(50,20));
                list.put(GehaerteteStahlbeineRezept.class, new PricePair(50,20));
                list.put(PunktfeuerRezept.class, new PricePair(200,20));
                list.put(Schleifstein.class, new PricePair(50,20));
                list.put(Diamant.class, new PricePair(1000,320));
                list.put(Goldbrocken.class, new PricePair(320,80));
                list.put(Silberstraehne.class, new PricePair(160,40));
                list.put(Eisenerz.class, new PricePair(80,20));
                list.put(Reparaturkit.class, new PricePair(200,50));
                list.put(GehaerteterEisenhelmRezept.class, new PricePair(50, 20));
                list.put(GehaerteteStahlbrustRezept.class, new PricePair(60,25));
                list.put(VerstaerkteLederhandschuheRezept.class, new PricePair(40, 15));
                list.put(VerstaerkteLederschuheRezept.class, new PricePair(40,15));
                return new SelectionCommon(list);
            }

    };
    }
}