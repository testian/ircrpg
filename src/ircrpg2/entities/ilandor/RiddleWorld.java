/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor;

import ircrpg2.entities.common.DefaultLocality;
import ircrpg2.entities.common.DefaultPath;

/**
 *
 * @author testi
 */
public class RiddleWorld {

    public static void init(DefaultWorld world) {
    DefaultLocality start = new DefaultLocality("Eingang zur Rätselwelt");
    DefaultLocality siebengaenge = new DefaultLocality("Sieben Gänge");
    DefaultLocality suchmal = new DefaultLocality("Such mal!");
    world.connect(start,suchmal, new DefaultPath("Schwarzfarbener Gang",10));
    world.connect(suchmal,siebengaenge, new DefaultPath("Zu den sieben Gängen",10));
    DefaultLocality kammer1 = new DefaultLocality("Kammer des Ersten");
    DefaultLocality kammer2 = new DefaultLocality("Kammer des Zweiten");
    DefaultLocality kammer3 = new DefaultLocality("Kammer des Dritten");
    DefaultLocality kammer4 = new DefaultLocality("Kammer des Vierten");
    DefaultLocality kammer5 = new DefaultLocality("Kammer des Fünften");
    DefaultLocality kammer6 = new DefaultLocality("Kammer des Sechsten");
    DefaultLocality kammer7 = new DefaultLocality("Leere Kammer des Siebten");
    world.connect(siebengaenge,kammer1, new DefaultPath("Zum Ersten der Sieben",10));
    world.connect(siebengaenge,kammer2, new DefaultPath("Zum Zweiten der Sieben",10));
    world.connect(siebengaenge,kammer3, new DefaultPath("Zum Dritten der Sieben",10));
    world.connect(siebengaenge,kammer4, new DefaultPath("Zum Vierten der Sieben",10));
    world.connect(siebengaenge,kammer5, new DefaultPath("Zum Fünften der Sieben",10));
    world.connect(siebengaenge,kammer6, new DefaultPath("Zum Sechsten der Sieben",10));
    world.connect(siebengaenge,kammer7, new DefaultPath("Zum Letzen der Sieben",10));

    world.connect(kammer1,kammer2, new DefaultPath("Von A nach B",5));
    world.connect(kammer2,kammer3, new DefaultPath("Von B nach C",10));
    world.connect(kammer3,kammer4, new DefaultPath("Von C nach D",10));
    world.connect(kammer4,kammer5, new DefaultPath("Von D nach E",10));
    world.connect(kammer5,kammer6, new DefaultPath("Von E nach F",10));
    world.connect(kammer6,kammer7, new DefaultPath("Von F nach G",10));
    }

}
