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
public class MagierKloster extends DefaultLocality implements Store {

    public void use(RPGCharacter user) throws RPGException {
        store.use(user);
    }
    Store store;

    public Selection getSelection() {
        return store.getSelection();
    }
    public MagierKloster() {
    super("Das Kloster der Magier");
    store = new StoreCommon() {

            public String getName() {
                return MagierKloster.this.getName();
            }

            public Selection getSelection() {
                Map<Class<? extends Item>, PricePair> list = new HashMap<Class<? extends Item>, PricePair>();
                list.put(BuchDerAlchemie.class,new PricePair(200,100));
                list.put(LebenstrankRezept.class,new PricePair(400,10));
                list.put(HeilwelleRuneRezept.class,new PricePair(2000,500));
                list.put(FeuerwelleRuneRezept.class,new PricePair(2000,500));
                list.put(FeuerkugelRuneRezept.class,new PricePair(1000,250));
                list.put(FeuerkugelSpruchrolle.class,new PricePair(500,250));
                list.put(ManazeitbombeSpruchrolle.class,new PricePair(5000,2500));
                list.put(ManazeitbombeRuneRezept.class,new PricePair(5000,2500));
                list.put(RegenerationRuneRezept.class, new PricePair(1200, 600));
                list.put(HeilzauberRune.class,new PricePair(3000,1000));
                list.put(WiederbelebungRuneRezept.class,new PricePair(2000,500));
                list.put(BuchDerMagie.class,new PricePair(1500,300));
                list.put(GrosserManatrankRezept.class, new PricePair(800,40));
                list.put(ManasteigerungRezept.class, new PricePair(1800,80));
                list.put(Reparaturkit.class, new PricePair(350,50));
                list.put(Verstaerkungskit.class, new PricePair(600,180));
                list.put(GrossesVerstaerkungskit.class, new PricePair(1200,180));
                list.put(MonsterVerstaerkungskit.class, new PricePair(4000,180));
                list.put(KleinerHeiltrank.class,new PricePair(50,15));
                list.put(KleinerManatrank.class,new PricePair(80,30));
                list.put(LeereFlasche.class, new PricePair(5,1));

                list.put(GrosserHeiltrank.class,new PricePair(150,30));
                list.put(GrosserManatrank.class,new PricePair(220,80));
                list.put(TeleportMagierKlosterSpruchrolle.class,new PricePair(1500,150));
                list.put(WiederbelebungSpruchrolle.class, new PricePair(2000, 200));

                return new SelectionCommon(list);
            }

    };
    }

}
