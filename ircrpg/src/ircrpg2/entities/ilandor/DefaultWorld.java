/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor;
import ircrpg2.core.*;
import ircrpg2.entities.common.*;
import ircrpg2.entities.ilandor.items.*;
import ircrpg2.entities.ilandor.locations.*;
import ircrpg2.entities.ilandor.npc.*;
/**
 *
 * @author testi
 */
public class DefaultWorld extends WorldCommon {



    public void init(InitSource... initSources) {

            DefaultLocality redynia = new Home("Redynia");
            DefaultLocality stadthafen = new DefaultLocality("Stadthafen von Redynia");
            DefaultLocality sandstrand = new DefaultLocality("Grosser Sandstrand");
            DefaultLocality klippe = new DefaultLocality("Gefährliche Klippe");
            DefaultLocality riverlance = new DefaultLocality("Riverlance-Dorf");
            DefaultLocality bauernhof = new DefaultLocality("Bauernhof");
            DefaultLocality waechteraussenposten = new DefaultLocality("Aussenposten des Wächters");
            DefaultLocality eulerlichtung = new Eulerlichtung();
            DefaultLocality spaeherunterschlupf = new DefaultLocality("Unterschlupf des Spähers");
            DefaultLocality priscilla = new DefaultLocality("Priscilla Kastell");
            DefaultLocality dreiwegepunkt = new DefaultLocality("Drei Wege Punkt");
            DefaultLocality andereklippe = new DefaultLocality("Andere Klippenseite");
            DefaultLocality leuchtturm = new DefaultLocality("Der grosse Leuchtturm");
            DefaultLocality wrackbucht = new DefaultLocality("Schiffswrack in der Bucht");
            DefaultLocality banditenlager = new DefaultLocality("Das Banditenlager von Mandroke");
            DefaultLocality banditenhauptquartier = new DefaultLocality("Mandroke's Unterschlupf");
            DefaultLocality mandrokesmine = new MandrokesMine();
            DefaultLocality fischmarkt = new DefaultLocality("Fischmarkt");
            
            DefaultLocality tinkermine = new Tinkermine();
            DefaultLocality mandelbergfuss = new DefaultLocality("Fuss des Mandelbergs");
            DefaultLocality hoehenlagerwest = new DefaultLocality("Westliches Höhenlager am Mandelberg");
            DefaultLocality mandelbergspitze = new DefaultLocality("Mandelbergspitze");
            DefaultLocality diamantenmine = new Diamantenmine();
            DefaultLocality hortal = new DefaultLocality("Hortal");
            DefaultLocality hordorf = new DefaultLocality("Hordorf");
            DefaultLocality hoehenlagerost = new DefaultLocality("Östliches Höhenlager am Mandelberg");
            DefaultLocality westbruecke = new DefaultLocality("Westliche Seite der Himmelbrücke");
            DefaultLocality ostbruecke = new DefaultLocality("Östliche Seite der Himmelbrücke");
            DefaultLocality horwasser = new DefaultLocality("Horwasser");
            DefaultLocality brueckencamp = new DefaultLocality("Camp unter der Himmelsbrücke");
            DefaultLocality wasserstufen = new DefaultLocality("Wasserstufen");
            DefaultLocality zyrenbergwerk = new Zyrenbergwerk();
            DefaultLocality zyrenbergsee = new DefaultLocality("Bergsee an der Bergspitze von Zyren");
            DefaultLocality minzschloss = new Minzschloss();
            DefaultLocality minzplateau = new DefaultLocality("Das grosse Minzplateau");
            DefaultLocality horcamp = new DefaultLocality("Horcamp");
            DefaultLocality leitercamp = new DefaultLocality("Leitercamp");
            Minzwald minzwald = new Minzwald();
            DefaultLocality heuermine = new DefaultLocality("Heuermine");
            Leiterwald leiterwald = new Leiterwald();
            DefaultLocality nordtor = new DefaultLocality("Tor im Norden");
            DefaultLocality priscillaaussenposten = new DefaultLocality("Nördlicher Priscilla-Aussenposten");
            DefaultLocality talausgang = new DefaultLocality("Talausgang zum Norden");
            DefaultLocality serenenplateau = new DefaultLocality("Serenenplateau");
            DefaultLocality wuestenposten1 = new DefaultLocality("Erster Wüstenposten");
            DefaultLocality wuestenposten2 = new DefaultLocality("Zweiter Wüstenposten");
            DefaultLocality wuestenposten3 = new DefaultLocality("Dritter Wüstenposten");
            DefaultLocality wuestenposten4 = new DefaultLocality("Vierter Wüstenposten");
            DefaultLocality wuestenposten5 = new DefaultLocality("Fünfter Wüstenposten");
            DefaultLocality wuestenposten6 = new DefaultLocality("Sechster Wüstenposten");
            DefaultLocality wuestenposten7 = new DefaultLocality("Siebter Wüstenposten");
            DefaultLocality morganslager = new DefaultLocality("Morgans Lager");
            DefaultLocality suedwestglitterwaldrand = new DefaultLocality("Südwestlicher Glitterwaldrand");
            DefaultLocality ring1 = new DefaultLocality("Erster Ringpunkt im Glitterwald");
            DefaultLocality ring2 = new DefaultLocality("Zweiter Ringpunkt im Glitterwald");
            DefaultLocality ring3 = new DefaultLocality("Dritter Ringpunkt im Glitterwald");
            DefaultLocality ring4 = new DefaultLocality("Vierter Ringpunkt im Glitterwald");
            DefaultLocality ring5 = new DefaultLocality("Fünfter Ringpunkt im Glitterwald");
            DefaultLocality ring6 = new DefaultLocality("Sechster Ringpunkt im Glitterwald");
            DefaultLocality glitterlichtung = new Glitterlichtung();//new DefaultLocality("Die Lichtung im Zentrum");
            DefaultLocality suedostglitterwaldrand = new DefaultLocality("Südöstlicher Glitterwaldrand");
            DefaultLocality zinntal = new DefaultLocality("Zinntal");
            DefaultLocality leiterstadt = new Home("Leiterstadt");
            DefaultLocality grosshof = new DefaultLocality("Grosshof der Leiter");
            DefaultLocality weitesfeld = new WeitesFeld();//new DefaultLocality("Weites Feld");
            DefaultLocality leiterbucht = new DefaultLocality("Leiterbucht");
            DefaultLocality krabbenkauf = new DefaultLocality("Krabbenkauf");
            DefaultLocality pausenplatz = new DefaultLocality("Pausenplatz");

            DefaultLocality bergwerkvorplatz = new DefaultLocality("Vorplatz des Bergwerks");
            DefaultLocality bergwerkeingang = new DefaultLocality("Eingang zum Bergwerk");
            DefaultLocality vertiefung = new DefaultLocality("Vertiefte Stelle im Minzplateau");
            DefaultLocality wasserloch = new DefaultLocality("Wasserloch");
            DefaultLocality berginneres = new DefaultLocality("Im Innern des Zyrenbergs");
            DefaultLocality berghalle = new DefaultLocality("Die grosse Berghalle");
            DefaultLocality zerfraestestelle = new DefaultLocality("Zerfräste Stelle");

            DefaultLocality portaleingangredynia = new DefaultLocality("Zu den Portalen in Redynia");
            DefaultLocality portalplatzredynia = new DefaultLocality("Portalplatz Redynia");

            DefaultLocality portaleingangleiterstadt = new DefaultLocality("Zu den Portalen in Leiterstadt");
            DefaultLocality portalplatzleiterstadt = new DefaultLocality("Portalplatz Leiterstadt");



            Kornfeld kornfeld = new Kornfeld();
            Bibliothek bibliothek = new Bibliothek();
            RedyniaMarkt markt = new RedyniaMarkt();
            RedyniaSchmiede schmiede = new RedyniaSchmiede();
            Kuryllinfeld kuryllinfeld = new Kuryllinfeld();
            MorgansLabor morganslabor = new MorgansLabor();
            Horwald horwald = new Horwald();//DefaultLocality("Horwald");
            Holzfaellerhuette holzfaellerhuette = new Holzfaellerhuette();
            Saegewerk saegewerk = new Saegewerk();
            Steinbruch steinbruch = new Steinbruch();
            Blutbruch blutbruch = new Blutbruch();

            Leiterbasar leiterbasar = new Leiterbasar();
            MagierKloster magierkloster = new MagierKloster();

            Station stationRedynia = new Station("Anlegestelle Redynia");
            Station stationLeiterstadt = new Station("Anlegestelle Leiterstadt");
            Transport schiff = new Transport("Redleit-Fähre", 3600);
            try {
            library.addLocality(schiff);
            } catch (RPGException ex) {}
            schiff.addStation(stationRedynia, 50*60, 0);
            schiff.addStation(stationLeiterstadt, 20*60, 30*60);

            Teleport redynialeiterstadt = new Teleport("Teleport von Redynia nach Leiterstadt",leiterstadt);
            Teleport redyniamorganslager = new Teleport("Teleport von Redynia nach Morgans Lager",morganslager);

            Teleport leiterstadtredynia = new Teleport("Teleport von Leiterstadt nach Redynia",redynia);
            Teleport leiterstadtmorganslager = new Teleport("Teleport von Leiterstadt nach Morgans Lager",morganslager);


            connect(portalplatzredynia,redynialeiterstadt, new DefaultPath("Zum Teleport Redynia - Leiterstadt",10));
            connect(portalplatzredynia,redyniamorganslager, new DefaultPath("Zum Teleport Redynia - Morgans Lager",10));

            connect(portalplatzleiterstadt,leiterstadtredynia, new DefaultPath("Zum Teleport Leiterstadt - Redynia",10));
            connect(portalplatzleiterstadt,leiterstadtmorganslager, new DefaultPath("Zum Teleport Redynia - Morgans Lager",10));


            connect(stadthafen, stationRedynia, new DefaultPath("Steg zur Anlegestelle in Redynia",5));
            connect(leiterbucht, stationLeiterstadt, new DefaultPath("Steg zur Anlegestelle in Leiterstadt",5));


            connect(redynia, markt, new DefaultPath("Marktgasse",5));
            connect(redynia,bibliothek,new DefaultPath("Akademikerstrasse",10));
            connect(redynia,stadthafen,new DefaultPath("Hafenstrasse",60));
            connect(stadthafen,sandstrand,new DefaultPath("Kanal",120));
            connect(sandstrand,klippe,new DefaultPath("Felspfad",30));
            connect(redynia,riverlance,new DefaultPath("Alte Wiese",100));

            connect(riverlance,klippe,new DefaultPath("Wasserschlucht",400));
            connect(riverlance,portaleingangredynia, new DefaultPath("Portalstrasse Redynia",20));
            connect(grosshof,portaleingangleiterstadt, new DefaultPath("Portalstrasse Leiterstadt",20));
            connect(portaleingangredynia,portalplatzredynia, new DefaultPath("Zum Portalplatz in Redynia",60));
            connect(portaleingangleiterstadt,portalplatzleiterstadt, new DefaultPath("Zum Portalplatz in Leiterstadt",60));
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
            connect(leiterwald, saegewerk, new DefaultPath("Lauberner Pfad zum Sägewerk",45));
            connect(mandelbergfuss, hortal, new DefaultPath("Talstrasse bei der Horquelle", 73));
            //connect(mandelbergfuss, hortal, new DefaultPath("Talstrasse bei der Horquelle", 73));
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
            connect(ostbruecke, bergwerkvorplatz , new DefaultPath("Am Zyren noch wohl", 800));
            connect(bergwerkvorplatz, bergwerkeingang, new DefaultPath("Zyrengeröll",10));
            connect(bergwerkeingang, zyrenbergwerk, new DefaultPath("Bergröhre",20));
            connect(bergwerkvorplatz, zyrenbergsee , new DefaultPath("Am Zyren noch lebend", 400));
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
            connect(pausenplatz,blutbruch, new DefaultPath("Entlang der roten Felsen",40));
            connect(minzplateau, vertiefung, new DefaultPath("Wasser-Blütepfad",25));
            connect(vertiefung, wasserloch, new DefaultPath("Im Schatten des Bergs",15));
            connect(wasserloch, berginneres, new DefaultPath("Lichtfreier Pfad", 50));
            connect(berginneres, zerfraestestelle, new DefaultPath("Unterer Lorenweg",40));
            connect(zerfraestestelle,zyrenbergwerk, new DefaultPath("Oberer Lorenweg",30));
            connect(berginneres, berghalle, new DefaultPath("Laternenstrasse", 30));
            connect(berghalle, magierkloster, new DefaultPath("Hallende Treppe", 70));


            //library.addLocality(redynia);
            //library.addLocality(stadthafen);
            //library.addLocality(sandstrand);
            //library.addLocality(klippe);
            //library.addLocality(riverlance);
            playerFactory = new DefaultPlayerFactory(this, redynia);
            try {
            npcConnector.connectNPC(new Stadtwache(this, redynia,1));
            npcConnector.connectNPC(new Stadtwache(this, redynia,2));
            npcConnector.connectNPC(new Stadtwache(this, redynia,3));
            npcConnector.connectNPC(new Stadtwache(this, redynia,4));
            npcConnector.connectNPC(new RedynianHuman(this,12, leiterstadt,"Leiterwache Nancy Hence"));
            npcConnector.connectNPC(new RedynianHuman(this,12, leiterstadt,"Leiterwache Rotling Keller"));
            npcConnector.connectNPC(new RedynianHuman(this,12, leiterstadt,"Leiterwache Gilles Mauerbach"));

            RedynianHuman portalwache1 = new RedynianHuman(this,40, portaleingangredynia,"Portalwächter Albert Koch");
            portalwache1.setNPCBehaviour(new WaechterBehaviour(3600,1000,portalplatzredynia));
            npcConnector.connectNPC(portalwache1);

            RedynianHuman portalwache2 = new RedynianHuman(this,40, portaleingangleiterstadt,"Portalwächter Andreas Leiter");
            portalwache2.setNPCBehaviour(new WaechterBehaviour(3600,1000,portalplatzleiterstadt));
            npcConnector.connectNPC(portalwache2);

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
            npcConnector.connectNPC(new Wegelagerer(this, andereklippe,7));
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
            npcConnector.connectNPC(new Zyrenbaerjunges(this, bergwerkeingang,1));
            npcConnector.connectNPC(new Zyrenbaerjunges(this, bergwerkeingang,2));
            npcConnector.connectNPC(new Zyrenbaerjunges(this, bergwerkeingang,3));
            npcConnector.connectNPC(new Zyrenbaerjunges(this, wasserloch,4));
            npcConnector.connectNPC(new Zyrenbaerjunges(this, wasserloch,5));

            npcConnector.connectNPC(new Zyrenbaermutter(this, zyrenbergwerk));
            npcConnector.connectNPC(new Zyrenbaervater(this, zyrenbergwerk));


            npcConnector.connectNPC(new RedynianHuman(this,7, holzfaellerhuette,"Felix Holzfall"));
            npcConnector.connectNPC(new RedynianHuman(this,9, saegewerk,"Ulrich Spalter"));

            npcConnector.connectNPC(new RedynianHuman(this,10, hordorf,"Diener der Hor"));
            npcConnector.connectNPC(new RedynianHuman(this,9, hordorf,"Derrick Hor"));
            Anita anita = new Anita(this,hordorf);
            npcConnector.connectNPC(anita);
            npcConnector.connectNPC(new RedynianHuman(this,8, hortal,"Horwächter"));




            npcConnector.connectNPC(new Diamantenjaeger(this, diamantenmine,1));
            npcConnector.connectNPC(new Diamantenjaeger(this, diamantenmine,2));
            npcConnector.connectNPC(new Diamantenjaeger(this, diamantenmine,3));
            npcConnector.connectNPC(new Gipfelriese(this, mandelbergspitze));
            npcConnector.connectNPC(new Wolkenkratzer(this, zyrenbergsee));



            npcConnector.connectNPC(new RedynianHuman(this,13,morganslager,"Morgan der Alchemist"));
            npcConnector.connectNPC(new RedynianHuman(this,12,morganslager,"Morgans rechte Hand"));
            npcConnector.connectNPC(new RedynianHuman(this,12,morganslager,"Morgans linke Hand"));

            npcConnector.connectNPC(new RedynianHuman(this,11,morganslager,"Verfechter des Kyrillins"));
            npcConnector.connectNPC(new RedynianHuman(this,11,morganslager,"Kyrillinwächter"));


            
            npcConnector.connectNPC(new RedynianHuman(this,10,morganslager,"Der Lehrling"));
            npcConnector.connectNPC(new RedynianHuman(this,9,morganslager,"Kyrillin-Feldarbeiter"));

            npcConnector.connectNPC(new RedynianHuman(this,14,berghalle,"Beschützer der Magier"));
            npcConnector.connectNPC(new RedynianHuman(this,15,berghalle,"Beschützer des Wissens"));
            npcConnector.connectNPC(new Mortera(this,magierkloster));
            npcConnector.connectNPC(new Rontaffnough(this,minzschloss));
            npcConnector.connectNPC(new RedynianHuman(this,30,magierkloster,"Lizor der Beschwörer"));
            npcConnector.connectNPC(new RedynianHuman(this,18,magierkloster,"Michael der Novize"));
            npcConnector.connectNPC(new RedynianHuman(this,22,magierkloster,"Kim der Alte"));
            npcConnector.connectNPC(new Simon(this,leiterwald));

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

            npcConnector.connectNPC(new Minenkrabbler(this, zerfraestestelle, 1));
            npcConnector.connectNPC(new Minenkrabbler(this, zerfraestestelle, 2));

            npcConnector.connectNPC(new Minzraeuber(this, minzwald, 1));
            npcConnector.connectNPC(new Minzraeuber(this, minzplateau, 2));
            npcConnector.connectNPC(new Minzraeuber(this, minzplateau, 3));

            npcConnector.connectNPC(new Riesenwurm(this, weitesfeld, 1));
            npcConnector.connectNPC(new Riesenwurm(this, weitesfeld, 2));



            } catch (RPGException ex) {ex.printStackTrace();throw new RuntimeException(ex);}



        


        super.init(initSources);
    }

}
