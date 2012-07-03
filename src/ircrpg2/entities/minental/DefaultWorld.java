/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.minental;
import ircrpg2.entities.minental.*;
import ircrpg2.entities.common.WorldCommon;
import ircrpg2.core.*;

import ircrpg2.entities.common.*;
//import ircrpg2.entities.ilandor.items.*;
//import ircrpg2.entities.ilandor.locations.*;
//import ircrpg2.entities.ilandor.npc.*;
import ircrpg2.messaging.*;
import java.util.*;
/**
 *
 * @author testi
 */
public class DefaultWorld extends WorldCommon {



    public void init() {


            DefaultLocality austauschstellelift = new DefaultLocality("Lift bei der Austauschstelle");
            DefaultLocality austauschstelleteich = new DefaultLocality("Teich bei der Austauschstelle");
            DefaultLocality austauschstelle = new DefaultLocality("Austauschschtelle");
            DefaultLocality eingangzumminental = new DefaultLocality("Eingang zur Kolonie"); //2 Gardisten hinzufügen
            DefaultLocality mineneingangnord = new DefaultLocality("Vor dem Eingang zur nördlichen Mine");
            DefaultLocality moleratbrueckeost = new DefaultLocality("Vor der kleinen Brücke");
            DefaultLocality moleratbrueckewest = new DefaultLocality("Nach der kleinen Brücke"); //Molerat
            DefaultLocality unterderbruecke = new DefaultLocality("Unter der kleinen Brücke");
            DefaultLocality beimgalgen = new DefaultLocality("Beim Galgen"); //Scavenger
            connect(austauschstelle, eingangzumminental, new DefaultPath("Pfad zum Eingang der Kolonie",12));
            connect(austauschstelle, austauschstellelift, new DefaultPath("Um die Austauschstelle",5));
            connect(austauschstelle, austauschstelleteich, new DefaultPath("Am Ufer",3));
            connect(eingangzumminental, mineneingangnord, new DefaultPath("Nördlicher Pfad zur nördlichen Mine",12));
            connect(mineneingangnord, moleratbrueckeost, new DefaultPath("Pfad zur kleinen Brücke",5));
            connect(moleratbrueckeost, moleratbrueckewest, new DefaultPath("Auf der kleinen Brücke",5));
            connect(mineneingangnord, unterderbruecke, new DefaultPath("Steiler Pfad ins Minental",6));
            connect(unterderbruecke, beimgalgen, new DefaultPath("Pfad nördlich des Galgens",10));
            DefaultLocality beidraxundratford = new DefaultLocality("Am Fuss des nördlichen Bergs"); //drax un dratford einfügen
            connect(beimgalgen, beidraxundratford, new DefaultPath("Entlang der Felswand des nördlichen Bergs",53));
            


/*            Kornfeld kornfeld = new Kornfeld();
            Bibliothek bibliothek = new Bibliothek();
            RedyniaMarkt markt = new RedyniaMarkt();
            RedyniaSchmiede schmiede = new RedyniaSchmiede();
            Kuryllinfeld kuryllinfeld = new Kuryllinfeld();
            MorgansLabor morganslabor = new MorgansLabor();
            Horwald horwald = new Horwald();//DefaultLocality("Horwald");
            Holzfaellerhuette holzfaellerhuette = new Holzfaellerhuette();
            Steinbruch steinbruch = new Steinbruch();
            Blutbruch blutbruch = new Blutbruch();

            Leiterbasar leiterbasar = new Leiterbasar();

            Station stationRedynia = new Station("Anlegestelle Redynia");
            Station stationLeiterstadt = new Station("Anlegestelle Leiterstadt");
            Transport schiff = new Transport("Redleit-Fähre", 3600);
            try {
            library.addLocality(schiff);
            } catch (RPGException ex) {}
            schiff.addStation(stationRedynia, 50*60, 0);
            schiff.addStation(stationLeiterstadt, 20*60, 30*60);

            connect(stadthafen, stationRedynia, new DefaultPath("Steg zur Anlegestelle in Redynia",5));
            connect(leiterbucht, stationLeiterstadt, new DefaultPath("Steg zur Anlegestelle in Leiterstadt",5));


            connect(redynia, markt, new DefaultPath("Marktgasse",5));
            connect(redynia,bibliothek,new DefaultPath("Akademikerstrasse",10));
            connect(redynia,stadthafen,new DefaultPath("Hafenstrasse",60));
            connect(stadthafen,sandstrand,new DefaultPath("Kanal",120));
            connect(sandstrand,klippe,new DefaultPath("Felspfad",30));
            connect(redynia,riverlance,new DefaultPath("Alte Wiese",100));
            connect(riverlance,klippe,new DefaultPath("Wasserschlucht",400));
            connect(riverlance,bauernhof, new DefaultPath("Landstrasse", 30));
            connect(bauernhof,kornfeld, new DefaultPath("Ackerweg", 20));
            connect(markt,schmiede, new DefaultPath("Werkstrasse", 5));
            connect(bauernhof, waechteraussenposten, new DefaultPath("Königswiese",35));
            connect(waechteraussenposten, eulerlichtung, new DefaultPath("You're leaving the redynian sector",5));
            connect(stadthafen, fischmarkt, new DefaultPath("Hafengasse",5));
            connect(eulerlichtung, dreiwegepunkt, new DefaultPath("Lichtallee",50));
            connect(dreiwegepunkt, priscilla, new DefaultPath("Wiese des Trauers", 30));
            connect(dreiwegepunkt, andereklippe, new DefaultPath("Pfad neben der Wasserschlucht", 400));
            connect(andereklippe, leuchtturm, new DefaultPath("Steinerner Küstenweg", 30));
            connect(leuchtturm, wrackbucht, new DefaultPath("Die grosse Treppe", 70));
            connect(wrackbucht, banditenlager, new DefaultPath("Zwischen zwei Zäunen", 40));
            connect(banditenlager, banditenhauptquartier, new DefaultPath("Fackelpfad", 10));
            connect(banditenhauptquartier, mandrokesmine, new DefaultPath("Höhleneingang", 10));
            connect(eulerlichtung, horwald, new DefaultPath("Dunkler Waldtunnel", 50));
            connect(horwald, tinkermine, new DefaultPath("Pfad zur Tinkermine", 200));
            connect(horwald, mandelbergfuss, new DefaultPath("Pfad zum Bergfuss", 73));
            connect(horwald, holzfaellerhuette, new DefaultPath("Pfad zur Holzfällerhütte",30));
            connect(mandelbergfuss, hortal, new DefaultPath("Talstrasse bei der Horquelle", 73));
            connect(mandelbergfuss, hortal, new DefaultPath("Talstrasse bei der Horquelle", 73));
            connect(hortal, hordorf, new DefaultPath("Talstrasse zum Hordorf", 100));
            connect(hortal, horwasser, new DefaultPath("Flusswärts bei Hor", 120));
            connect(horwasser, brueckencamp , new DefaultPath("Flusswärts zwischen den Bergen", 60));
            connect(brueckencamp, wasserstufen , new DefaultPath("Zu den Wasserstufen", 40));
            connect(mandelbergfuss, hoehenlagerwest , new DefaultPath("Bergpfad zum Mandel", 123));
            connect(hoehenlagerwest, diamantenmine , new DefaultPath("Zur Diamantenmine", 50));
            connect(hoehenlagerwest, mandelbergspitze , new DefaultPath("Von Westen zur Mandelspitze", 200));
            connect(hordorf, hoehenlagerost , new DefaultPath("Zwischen Hor und Mandel", 100));
            connect(hoehenlagerost, mandelbergspitze , new DefaultPath("Von Osten zur Mandelspitze", 210));
            connect(hoehenlagerost, westbruecke , new DefaultPath("Auf zur Brücke", 80));
            connect(westbruecke, ostbruecke , new DefaultPath("Auf der Himmelsbrücke", 100));
            connect(ostbruecke, zyrenbergwerk , new DefaultPath("Am Zyren noch wohl", 800));
            connect(zyrenbergwerk, zyrenbergsee , new DefaultPath("Am Zyren noch lebend", 400));
            connect(zyrenbergsee, minzschloss, new DefaultPath("Zwischen See und Schloss", 200));
            connect(minzschloss, minzplateau, new DefaultPath("Zwischen Schloss und Plateau", 150));
            connect(minzplateau, horcamp, new DefaultPath("Zum Horcamp", 70));
            connect(minzplateau, leitercamp, new DefaultPath("Zum Leitercamp", 70));
            connect(minzplateau, nordtor, new DefaultPath("Weitläufige Ebene", 500));
            connect(nordtor, priscillaaussenposten, new DefaultPath("Steinernes Tal", 300));
            connect(priscillaaussenposten, talausgang, new DefaultPath("Steinerne Ebene", 300));
            connect(talausgang, serenenplateau, new DefaultPath("Höhensand", 70));
            connect(minzplateau,minzwald, new DefaultPath("Wechselwiese", 100));
            connect(minzwald,leiterwald, new DefaultPath("Wechselwald", 200));
            connect(minzwald,heuermine, new DefaultPath("Pfad zur Heuermine", 150));
            connect(leiterwald,grosshof, new DefaultPath("Leiterwaldrand", 40));
            connect(grosshof,weitesfeld, new DefaultPath("Schlammstrasse", 10));
            connect(grosshof,leiterstadt, new DefaultPath("Die grosse Leiterstrasse", 100));
            connect(leiterstadt, leiterbasar, new DefaultPath("Basarstrasse", 9));
            connect(leiterstadt,leitermarkt, new DefaultPath("Zentrumsstrasse", 10));
            connect(leiterstadt,leiterbucht, new DefaultPath("Buchtlauf", 40));
            connect(leiterbucht,krabbenkauf, new DefaultPath("Buchtbogen", 10));
            connect(priscilla,wuestenposten1, new DefaultPath("Sonnenlauf", 1500));
            connect(wuestenposten1,wuestenposten2, new DefaultPath("Erster Wüstenabschnitt", 2000));
            connect(wuestenposten2,wuestenposten3, new DefaultPath("Zweiter Wüstenabschnitt", 1800));
            connect(wuestenposten3,wuestenposten4, new DefaultPath("Dritter Wüstenabschnitt", 1600));
            connect(wuestenposten4,wuestenposten5, new DefaultPath("Vierter Wüstenabschnitt", 1400));
            connect(wuestenposten5,wuestenposten6, new DefaultPath("Fünfter Wüstenabschnitt", 1200));
            connect(wuestenposten6,wuestenposten7, new DefaultPath("Letzter Wüstenabschnitt", 1000));
            connect(wuestenposten7,morganslager, new DefaultPath("Kühle Strasse", 100));
            connect(morganslager,kuryllinfeld, new DefaultPath("Allee der Heiler", 100));
            connect(morganslager,morganslabor, new DefaultPath("Lehrlingsstrasse", 100));
            connect(morganslager,suedwestglitterwaldrand, new DefaultPath("Zumwald-Südwest", 50));
            connect(suedwestglitterwaldrand,ring1, new DefaultPath("Zumring-Südwest", 50));
            connect(ring1,ring2, new DefaultPath("Eins Zwei", 30));
            connect(ring2,ring3, new DefaultPath("Zwei Drei", 30));
            connect(ring3,ring4, new DefaultPath("Drei Vier", 30));
            connect(ring4,ring5, new DefaultPath("Vier Fünf", 30));
            connect(ring5,ring6, new DefaultPath("Fünf Sechs", 30));
            connect(ring6,ring1, new DefaultPath("Sechs Eins", 30));
            connect(ring1,glitterlichtung, new DefaultPath("Eins zum Licht", 30));
            connect(ring2,glitterlichtung, new DefaultPath("Zwei zum Licht", 30));
            connect(ring3,glitterlichtung, new DefaultPath("Drei zum Licht", 30));
            connect(ring4,glitterlichtung, new DefaultPath("Vier zum Licht", 30));
            connect(ring5,glitterlichtung, new DefaultPath("Fünf zum Licht", 30));
            connect(ring6,glitterlichtung, new DefaultPath("Sechs zum Licht", 30));
            connect(ring5,suedostglitterwaldrand, new DefaultPath("Zumring-Südost", 50));
            connect(suedostglitterwaldrand, zinntal, new DefaultPath("Zumwald-Südost", 50));
            connect(zinntal, serenenplateau, new DefaultPath("Serenental", 200));
            connect(priscilla, steinbruch, new DefaultPath("Schlosswand",30));
            connect(horwald,spaeherunterschlupf, new DefaultPath("Versteckter Weg",50));
            connect(nordtor,pausenplatz, new DefaultPath("Entlang der Felswand nach Osten",60));
            connect(pausenplatz,blutbruch, new DefaultPath("Entlang der roten Felsen",40));*/

            //library.addLocality(redynia);
            //library.addLocality(stadthafen);
            //library.addLocality(sandstrand);
            //library.addLocality(klippe);
            //library.addLocality(riverlance);
            /*playerFactory = new DefaultPlayerFactory(this, redynia);
            try {
            npcConnector.connectNPC(new Stadtwache(this, redynia,1));
            npcConnector.connectNPC(new Stadtwache(this, redynia,2));
            npcConnector.connectNPC(new Stadtwache(this, redynia,3));
            npcConnector.connectNPC(new Stadtwache(this, redynia,4));
            npcConnector.connectNPC(new Kornwurm(this, kornfeld,1));
            npcConnector.connectNPC(new Kornwurm(this, kornfeld,2));
            npcConnector.connectNPC(new Killerkrabbe(this, klippe,1));
            npcConnector.connectNPC(new Killerkrabbe(this, klippe,2));
            npcConnector.connectNPC(new Killerkrabbe(this, klippe,3));
            npcConnector.connectNPC(new Wegelagerer(this, eulerlichtung,1));
            npcConnector.connectNPC(new Wegelagerer(this, dreiwegepunkt,2));
            npcConnector.connectNPC(new Wegelagerer(this, dreiwegepunkt,3));
            npcConnector.connectNPC(new Wegelagerer(this, andereklippe,4));
            npcConnector.connectNPC(new Wegelagerer(this, andereklippe,5));
            npcConnector.connectNPC(new Wegelagerer(this, andereklippe,6));
            npcConnector.connectNPC(new Wegelagerer(this, leuchtturm,7));
            npcConnector.connectNPC(new Bandit(this, leuchtturm,1));
            npcConnector.connectNPC(new Bandit(this, leuchtturm,2));
            npcConnector.connectNPC(new Bandit(this, priscillaaussenposten,3));
            npcConnector.connectNPC(new Schlossgespenst(this, priscilla,1));
            npcConnector.connectNPC(new Schlossgespenst(this, priscilla,2));
            npcConnector.connectNPC(new Schlossgespenst(this, steinbruch,3));
            npcConnector.connectNPC(new Bandit(this, wrackbucht,4));
            npcConnector.connectNPC(new Bandit(this, wrackbucht,5));
            npcConnector.connectNPC(new Bandit(this, wrackbucht,6));
            npcConnector.connectNPC(new Bandit(this, banditenlager,7));
            npcConnector.connectNPC(new Banditenwache(this, banditenlager,1));
            npcConnector.connectNPC(new Banditenwache(this, banditenlager,2));
            npcConnector.connectNPC(new Banditenwache(this, banditenhauptquartier,3));
            npcConnector.connectNPC(new Banditenwache(this, banditenhauptquartier,4));
            npcConnector.connectNPC(new Mandroke(this, banditenhauptquartier));
            npcConnector.connectNPC(new Wegelagerer(this, horwald,8));
            npcConnector.connectNPC(new Wegelagerer(this, tinkermine,9));
            npcConnector.connectNPC(new Wegelagerer(this, mandelbergfuss,10));
            npcConnector.connectNPC(new Wegelagerer(this, mandelbergfuss,11));
            npcConnector.connectNPC(new Bandit(this, hoehenlagerost,9));
            npcConnector.connectNPC(new MichaelHansHeinzPeterFritzFranz(this, waechteraussenposten));
            npcConnector.connectNPC(new Marko(this, stadthafen));
            npcConnector.connectNPC(new MandrokesSon(this, spaeherunterschlupf));


            npcConnector.connectNPC(new RedynianHuman(this, holzfaellerhuette,"Felix Holzfall",1));

            npcConnector.connectNPC(new RedynianHuman(this, hordorf,"Diener der Hor",4));
            npcConnector.connectNPC(new RedynianHuman(this, hordorf,"Derrick Hor",3));
            npcConnector.connectNPC(new RedynianHuman(this, hordorf,"Anita Hor",3));
            npcConnector.connectNPC(new RedynianHuman(this, hortal,"Horwächter",2));




            npcConnector.connectNPC(new Diamantenjaeger(this, diamantenmine,1));
            npcConnector.connectNPC(new Diamantenjaeger(this, diamantenmine,2));
            npcConnector.connectNPC(new Diamantenjaeger(this, diamantenmine,3));
            npcConnector.connectNPC(new Gipfelriese(this, mandelbergspitze));
            npcConnector.connectNPC(new Wolkenkratzer(this, zyrenbergsee));



            npcConnector.connectNPC(new RedynianHuman(this,morganslager,"Morgan der Alchemist",7));
            npcConnector.connectNPC(new RedynianHuman(this,morganslager,"Morgans rechte Hand",6));
            npcConnector.connectNPC(new RedynianHuman(this,morganslager,"Morgans linke Hand",6));

            npcConnector.connectNPC(new RedynianHuman(this,morganslager,"Verfechter des Kyrillins",5));
            npcConnector.connectNPC(new RedynianHuman(this,morganslager,"Kyrillinwächter",5));


            
            npcConnector.connectNPC(new RedynianHuman(this,morganslager,"Der Lehrling",4));
            npcConnector.connectNPC(new RedynianHuman(this,morganslager,"Kyrillin-Feldarbeiter",3));

            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten1,1));

            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten2,2));
            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten2,3));

            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten3,4));
            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten3,5));
            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten3,6));

            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten4,7));
            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten4,8));
            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten4,9));
            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten4,10));

            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten5,11));
            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten5,12));
            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten5,13));
            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten5,14));
            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten5,15));

            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten6,16));
            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten6,17));
            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten6,18));
            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten6,19));
            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten6,20));
            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten6,21));

            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten7,22));
            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten7,23));
            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten7,24));
            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten7,25));
            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten7,26));
            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten7,27));
            npcConnector.connectNPC(new Wuestenbandit(this,wuestenposten7,28));

            npcConnector.connectNPC(new Gnom(this, horwasser, 1, new Kurzschwert()));
            npcConnector.connectNPC(new Gnom(this, horwasser, 2, new Holzfaelleraxt()));
            npcConnector.connectNPC(new Gnom(this, horwasser, 3, new Kurzschwert()));
            npcConnector.connectNPC(new Gnom(this, brueckencamp, 4, new Sichel()));
            npcConnector.connectNPC(new Gnom(this, brueckencamp, 5, new Spitzhacke()));
            npcConnector.connectNPC(new Gnom(this, brueckencamp, 6, new Morgenstern()));

            npcConnector.connectNPC(new Eremit(this, wasserstufen));

            npcConnector.connectNPC(new Brueckentroll(this, westbruecke));

            npcConnector.connectNPC(new Minenkrabbler(this, zyrenbergwerk, 1));
            npcConnector.connectNPC(new Minenkrabbler(this, zyrenbergwerk, 2));*/



            /*} catch (RPGException ex) {ex.printStackTrace();throw new RuntimeException(ex);}*/



        


        super.init();
    }

}
