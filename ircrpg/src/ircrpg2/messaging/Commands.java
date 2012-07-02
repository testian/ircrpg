/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ircrpg2.messaging;

import ircrpg2.core.*;
import java.util.*;
import java.lang.reflect.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author testi
 */
public class Commands {

    World world;

    public Commands(World world) {
        this.world = world;
    }

    public void buy(String user, String commandLine) {
        storeAction(user, commandLine, true, 1);
    }

    public void sell(String user, String commandLine) {
        storeAction(user, commandLine, false, 1);
    }

    public void buyall(String user, String commandLine) {
        storeAction(user, commandLine, true, Integer.MAX_VALUE);
    }

    public void sellall(String user, String commandLine) {
        storeAction(user, commandLine, false, Integer.MAX_VALUE);
    }

    private void storeAmount(String user, String commandLine, boolean buy) {
        SimpleStringTokenizer t = new SimpleStringTokenizer(commandLine);
        if (!t.hasMoreTokens()) {
            use(user, commandLine);
            return;
        }
        int amount = 1;
        try {
            amount = Integer.parseInt(t.nextToken());
        } catch (NumberFormatException ex) {
            world.getPublicMessageTarget().msg("Erstes Argument muss eine ganze Zahl sein, " + user + ".");
            return;
        }
        if (amount < 1) {
            world.getPublicMessageTarget().msg("Erstes Argument muss grösser als 0 sein, " + user + ".");
            return;
        }
        if (!t.hasMoreTokens()) {
            world.getPublicMessageTarget().msg("Du musst einen Gegenstand angeben, " + user + ".");
        }
        storeAction(user, t.remainingString(), buy, amount);
    }

    public void sellamount(String user, String commandLine) {
        storeAmount(user, commandLine, false);
    }

    public void buyamount(String user, String commandLine) {
        storeAmount(user, commandLine, true);
    }

    private void storeAction(String user, String commandLine, boolean buy, int amount) {
        if (amount < 1) {
            throw new IllegalArgumentException("amount must be >0");
        }
        RPGCharacter player = getPlayer(user);
        if (player == null) {
            return;
        }
        Location location = player.getPosition().getLocation();
        if (location instanceof Store) {
            if (commandLine.isEmpty()) {

                use(user, commandLine);

                return;

            }


            try {
                player.checkAlive();
                //Store store = (Store)location;
                Selection selection = ((Store) location).getSelection();

                Set<Class<? extends Item>> itemSet;
                if (buy) {
                    itemSet = selection.getItems().keySet();
                } else {
                    itemSet = new HashSet<Class<? extends Item>>();
                    for (Item i : player.getInventory().getItems()) {
                        itemSet.add(i.getClass());
                    }
                }

                for (Class<? extends Item> ic : itemSet) {
                    if (ItemFactory.itemName(ic).equals(commandLine)) {
                        if (buy) {
                            if (amount == 1) {
                                selection.buy(player, ic);
                            } else {
                                selection.buy(player, ic, amount);
                            }


                        } else {
                            if (amount == 1) {
                                selection.sell(player, ic);
                            } else {
                                selection.sell(player, ic, amount);
                            }
                        }
                        return;
                    }
                }
                player.allMsg("Keinen Gegenstand mit diesem Namen gefunden, " + player.getName() + ".");
            } catch (RPGException ex) {
                player.allMsg(ex.getMessage() + ", " + player.getName() + ".");
            }
        } else {
            player.allMsg("Hier kannst du nichts kaufen/verkaufen, " + player.getName() + ".");
        }
    }

    public void armor(String user, String commandLine) {
        RPGCharacter player = getPlayer(user);
        if (player == null) {
            return;
        }
        Body body = player.getBody();
        boolean anyArmor = false;
        if (body.head() != null) {
            player.msg(body.head().itemInfo());
            anyArmor = true;
        }
        if (body.chest() != null) {
            player.msg(body.chest().itemInfo());
            anyArmor = true;
        }
        if (body.hands() != null) {
            player.msg(body.hands().itemInfo());
            anyArmor = true;
        }
        if (body.legs() != null) {
            player.msg(body.legs().itemInfo());
            anyArmor = true;
        }
        if (body.feet() != null) {
            player.msg(body.feet().itemInfo());
            anyArmor = true;
        }
        if (anyArmor) {
            player.msg("Schutz gesamt: " + body.getRealBlock() + "/" + body.getBlock());
        } else {
            player.msg("Du trägst keine Schutzkleidung.");
        }

    }

    private String armorInfo(Armor armor) {
        return armor.getName() + " - Schutz: " + armor.getRealBlock() + "/" + armor.getBlock() + " - Integrität: " + (armor.getIntegrity() / 10) + "%;";
    }

    public String armor() {
        return "Gibt angelegte Rüstungsgegenstände an";
    }

    public void trainstrength(String user, String commandLine) {

        RPGCharacter player = getPlayer(user);
        if (player == null) {
            return;
        }
        try {
            player.checkAlive();
        } catch (RPGException ex) {
            player.allMsg(ex.getMessage() + ", " + player.getName() + ".");
            return;
        }
        try {
            int skillPoints = Integer.parseInt(commandLine);
            if (skillPoints > player.getSkillPoints()) {
                player.allMsg("Soviel Fähigkeitspunkte hast du nicht, " + player.getName() + ".");
                return;
            }
            if (skillPoints < 1) {
                player.allMsg("Wert muss grösser als 0 sein, " + player.getName() + ".");
                return;
            }

            player.decreaseSkillPoints(skillPoints);
            player.increaseStrength(skillPoints);
        } catch (NumberFormatException ex) {
            player.allMsg("Ungültige Syntax: " + trainstrength());
        } catch (RPGException ex) {
            player.allMsg(ex.getMessage() + player.getName() + ".");
        }

    }

    public void trainmana(String user, String commandLine) {

        RPGCharacter player = getPlayer(user);
        if (player == null) {
            return;
        }
        try {
            player.checkAlive();
        } catch (RPGException ex) {
            player.allMsg(ex.getMessage() + ", " + player.getName() + ".");
            return;
        }
        try {
            int skillPoints = Integer.parseInt(commandLine);
            if (skillPoints > player.getSkillPoints()) {
                player.allMsg("Soviel Fähigkeitspunkte hast du nicht, " + player.getName() + ".");
                return;
            }
            if (skillPoints < 1) {
                player.allMsg("Wert muss grösser als 0 sein, " + player.getName() + ".");
                return;
            }

            player.decreaseSkillPoints(skillPoints);
            player.increaseMaxMana(skillPoints);
        } catch (NumberFormatException ex) {
            player.allMsg("Ungültige Syntax: " + trainmana());
        } catch (RPGException ex) {
            player.allMsg(ex.getMessage() + player.getName() + ".");
        }

    }

    public void time(String user, String commandLine) {


        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        world.getPublicMessageTarget().msg("Zeit: " + df.format(new Date()));
    }

    public String time() {
        return "Gibt die Zeit im Spiel aus";
    }

    public void giveitem(String user, String commandLine) {
        giveItem(user, commandLine, 1);
    }

    public void giveall(String user, String commandLine) {
        giveItem(user, commandLine, Integer.MAX_VALUE);
    }

    public void giveamount(String user, String commandLine) {
        SimpleStringTokenizer t = new SimpleStringTokenizer(commandLine);
        if (!t.hasMoreTokens()) {
            use(user, commandLine);
            return;
        }
        int amount = 1;
        try {
            amount = Integer.parseInt(t.nextToken());
        } catch (NumberFormatException ex) {
            world.getPublicMessageTarget().msg("Erstes Argument muss eine ganze Zahl sein, " + user + ".");
            return;
        }
        if (amount < 1) {
            world.getPublicMessageTarget().msg("Erstes Argument muss grösser als 0 sein, " + user + ".");
            return;
        }
        if (!t.hasMoreTokens()) {
            world.getPublicMessageTarget().msg("Du musst einen Gegenstand angeben, " + user + ".");
        }
        giveItem(user, t.remainingString(), amount);
    }

    private void giveItem(String user, String commandLine, int amount) {
        if (amount < 1) {
            throw new IllegalArgumentException("amount must be >0");
        }
        RPGCharacter player = getPlayer(user);
        if (player == null) {
            return;
        }
        Item item = null;
        for (Item i : player.getInventory().getItems()) {
            if (i.getName().equals(commandLine)) {
                item = i;
                break;
            }
        }
        if (item == null) {
            player.allMsg("Du verfügst nicht über diesen Gegenstand, " + player.getName() + ".");
            return;
        }
        try {
            if (amount == 1) {
                player.giveItem(item);
            } else {
                player.giveItems(item.getClass(), amount);
            }
        } catch (RPGException ex) {
            if (ex.getType() == RPGException.Type.INVENTORY_FULL) {
                player.allMsg("Inventar des Spielers voll, " + player.getName() + ".");
            } else {
                player.allMsg(ex.getMessage() + ", " + player.getName() + ".");
            }
        }
    }

    public void givegold(String user, String commandLine) {
        RPGCharacter player = getPlayer(user);
        if (player == null) {
            return;
        }



        try {
            int amount = Integer.parseInt(commandLine);
            if (amount < 1) {
                player.allMsg("Wert muss grösser als 0 sein, " + player.getName() + ".");
                return;
            }
            player.giveGold(amount);
            ;
        } catch (NumberFormatException ex) {
            player.allMsg("Ungültige Syntax: " + givegold());
        } catch (RPGException ex) {
            player.allMsg(ex.getMessage() + ", " + player.getName() + ".");
        }


    }

    public String givegold() {
        return "Gib dem mit !settarget ausgewählten Ziel Gold - !givegold <Menge>";
    }

    public String giveitem() {
        return "Gib dem mit !settarget ausgewählten Ziel einen Gegenstand - !giveitem <Name des Gegenstands>";
    }

    public String giveall() {
        return "Gib dem mit !settarget ausgewählten Ziel alle Gegenstände mit entsprechendem Namen - !giveitem <Name des Gegenstands>";
    }

    public String giveamount() {
        return "Gib dem mit !settarget ausgewählten Ziel eine Anzahl Gegenstände mit entsprechendem Namen - !giveitem <Anzahl> <Name des Gegenstands>";
    }

    public String sell() {
        return "Verkaufe einen Gegenstand - !sell <Name des Gegenstands>";
    }

    public String buy() {
        return "Kaufe einen Gegenstand - !buy <Name des Gegenstands>";
    }

    public String sellall() {
        return "Verkaufe alle Gegenstände mit entsprechendem Namen - !sellall <Name des Gegenstands>";
    }

    public String buyall() {
        return "Kaufe soviele Gegenstände mit entsprechendem Namen wie möglich - !buyall <Name des Gegenstands>";
    }

    public String sellamount() {
        return "Verkaufe eine bestimmte Anzahl Gegenstände - !sellamount <Anzahl> <Name des Gegenstands>";
    }

    public String buyamount() {
        return "Kaufe eine bestimmte Anzahl Gegenstände - !buyamount <Anzahl> <Name des Gegenstands>";
    }

    public String drop() {
        return "Verliere einen Gegenstand - !drop <Name des Gegenstands>";
    }

    public String dropall() {
        return "Verliere alle Gegenstände mit angegebenem Namen - !dropall <Name des Gegenstands>";
    }

    public String trainstrength() {
        return "Wandle Fähigkeitspunkte in Stärke um mit !trainstrength <Anzahl einzusetzende Fähigkeitspunkte>";
    }

    public String trainmana() {
        return "Wandle Fähigkeitspunkte in maximale Mana um mit !trainmana <Anzahl einzusetzende Fähigkeitspunkte>";
    }

    public void drop(String user, String commandLine) {
        RPGCharacter player = getPlayer(user);
        if (player == null) {
            return;
        }
        drop(player, commandLine, false);
    }

    public void dropall(String user, String commandLine) {
        RPGCharacter player = getPlayer(user);
        if (player == null) {
            return;
        }
        drop(player, commandLine, true);
    }

    private void drop(RPGCharacter player, String commandLine, boolean dropAll) {

        try {
            player.checkAlive();
        } catch (RPGException ex) {
            player.allMsg(ex.getMessage() + ", " + player.getName());
            return;
        }

        HashSet<Item> items = new HashSet<Item>();
        for (Item i : player.getInventory().getItems()) {

            if (i.getName().equals(commandLine)) {
                items.add(i);
                if (!dropAll) {
                    break;
                }
            }
        }
        if (items.isEmpty()) {
            player.allMsg("Du verfügst nicht über diesen Gegenstand: " + player.getName() + ".");
            return;
        }
        for (Item i : items) {
            try {
                player.getInventory().removeItem(i);
            } catch (RPGException ex) {
                player.allMsg(ex.getMessage() + ", " + player.getName() + ".");
                return;
            }
        }
        player.allMsg(player.getName() + " entfernt " + (dropAll ? "alle" : "einmal") + " " + commandLine + " aus dem Inventar.");
    }

    public void move(String user, String commandLine) {
        RPGCharacter player = getPlayer(user);
        if (player == null) {
            return;
        }
        //player.hold();
        try {
            Locality l = Matching.getBestMatch(player.getPosition().getLocation().getLocalities(), commandLine);
            if (l == null) {
                throw new RPGException(RPGException.Type.NOT_CONTAINED);
            }
            player.move(l);
            //player.move(world.getLibrary().getLocality(commandLine));
        } catch (MultipleMatchException ex) {
            world.getPublicMessageTarget().msg(player.getName() + ", " + ex.getMessage());
        } catch (RPGException ex) {
            if (ex.getType() == ex.getType().NOT_CONTAINED) {
                world.getPublicMessageTarget().msg("Dieser Ort ist hier unbekannt, " + player.getName() + ".");
            } else if (ex.getType() == ex.getType().NOT_REACHABLE) {
                world.getPublicMessageTarget().msg("Dieser Ort ist von hier aus nicht erreichbar, " + player.getName() + ". Interner Fehler!");
            } else {
                world.getPublicMessageTarget().msg(ex.getMessage() + ", " + player.getName() + ".");
            }
        } finally {
            //player.commit();
        }
    }

    public void watch(String user, String commandLine) {
        RPGCharacter player = getPlayer(user);
        if (player == null) {
            return;
        }
        Set<RPGCharacter> all = new HashSet<RPGCharacter>();
        all.addAll(world.getLibrary().getPlayers());
        all.addAll(world.getLibrary().getNPCs());
        player.msg("Andere Spieler/NPCs in der Nähe:");
        Position my = player.getPosition();
        for (RPGCharacter c : all) {
            Position other = c.getPosition();

            if (c != player && my.getDistance(other) < Double.MAX_VALUE) //if (c != player && other.getLocation() == my.getLocation()) {
            {
                player.msg(c.getName() + " - Distanz: " + my.getDistance(other) + "m");
            }
            //}
        }
    }

    public String watch() {
        return "Zeigt welche NPCs/Spieler in der Nähe sind";
    }

    public void harvest(String user, String commandLine) {
        RPGCharacter player = getPlayer(user);
        if (player == null) {
            return;
        }
        try {
            player.checkAlive();
            if (commandLine.isEmpty())
            player.harvest();
            else {
            Location current = player.getPosition().getLocation();
            Set<Class<? extends Item>> itemClasses;
            if (current instanceof ResourceBase) {
            ResourceBase r = (ResourceBase)current;
            itemClasses = r.getResource().itemsAvailable(player);
            } else {
            itemClasses = new HashSet<Class<? extends Item>>();
            }
            Set<Item> sampleItems = new HashSet<Item>();
            for (Class<? extends Item> ic : itemClasses) {
            sampleItems.add(ItemFactory.instantiate(ic));
            }
            Item searchForSample = Matching.getBestMatch(sampleItems, commandLine);
            if (searchForSample == null) {
            player.allMsg(player.getName() + ", keine Vorkommnisse dieses Gegenstands gefunden.");
            return;
            }
            player.harvest(searchForSample.getClass());


            }
        } catch (RPGException ex) {
            player.allMsg(ex.getMessage() + ", " + player.getName() + ".");
        }
        catch (MultipleMatchException ex) {
            world.getPublicMessageTarget().msg(player.getName() + ", " + ex.getMessage());
        }
    }

    public String move() {
        return "Bewege dich zu einem anderen Ort mit !move <Ortsname>";
    }

    public void attack(String user, String commandLine) {
        RPGCharacter player = getPlayer(user);
        if (player == null) {
            return;
        }
        //player.hold();
        try {
            player.attack();
        } catch (RPGException ex) {
            world.getPublicMessageTarget().msg(ex.getMessage() + ", " + player.getName() + ".");
        } finally {
            //player.commit();
        }
    }

    public void block(String user, String commandLine) {
        RPGCharacter player = getPlayer(user);
        if (player == null) {
            return;
        }
        try {
            player.block();
        } catch (RPGException ex) {
            world.getPublicMessageTarget().msg(ex.getMessage() + ", " + player.getName() + ".");
        }
    }

    public String harvest() {
        return "Sucht/Erntet in der Umgebung wertvolle Rohstoffe. Für den Abbau von Ressourcen sind bestimmte Fähigkeiten zu erlernen.";
    }

    public String block() {
        return "Nutzt die derzeitig angelegten Waffen, um den Angriff zu blockieren";
    }

    public String attack() {
        return "Ein Angriff auf das mit !settarget ausgewählte Ziel wird ausgeführt";
    }

    public void settarget(String user, String commandLine) {
        RPGCharacter player = getPlayer(user);
        if (player == null) {
            return;
        }
        try {
            HashSet<RPGCharacter> all = new HashSet<RPGCharacter>();
            all.addAll(world.getLibrary().getPlayers());
            all.remove(player);
            all.addAll(world.getLibrary().getNPCs());
            RPGCharacter t = Matching.getExactMatch(all, commandLine);
            if (t == null) {

                Set<RPGCharacter> insens = Matching.getInsensitiveMatch(all, commandLine);
                if (insens.size() > 1) {
                    MultipleMatchException m = new MultipleMatchException();
                    for (Named n : insens) {
                        m.addMatch(n);
                    }
                    throw m; //TODO: This is functionality that other facilities should provide
                    //In fact Matching can be refactored using a more recursive (and reusable) way.
                }
                if (!insens.isEmpty()) {
                    t = insens.iterator().next();
                }
            }
            if (t == null) {
                Iterator<RPGCharacter> it = all.iterator();
                Position myPos = player.getPosition();
                while (it.hasNext()) {
                    RPGCharacter next = it.next();
                    double distance = next.getPosition().getDistance(myPos);
                    if (distance >= Double.MAX_VALUE) {
                        it.remove();
                    }
                }
                t = Matching.getBestMatch(all, commandLine);
            }
            if (t == null) {
                throw new RPGException(RPGException.Type.NOT_CONTAINED);
            }
            player.setTarget(t);
        } catch (RPGException ex) {
            if (ex.getType() == RPGException.Type.NOT_CONTAINED) {
                world.getPublicMessageTarget().msg("Weder Spieler noch NPC mit diesem Namen gefunden, " + player.getName() + ".");
            } else {
                world.getPublicMessageTarget().msg(ex.getMessage() + ", " + player.getName() + ".");
            }
        } catch (MultipleMatchException ex) {
            world.getPublicMessageTarget().msg(player.getName() + ", " + ex.getMessage());
        }
    }

    public String settarget() {
        return "Setze das Ziel mit !settarget <Name des Ziels>";
    }

    public void unsettarget(String user, String commandLine) {
        RPGCharacter player = getPlayer(user);
        if (player == null) {
            return;
        }
        player.unsetTarget();
    }

    public String unsettarget() {
        return "Wählt das mit !settarget ausgewählte Ziel ab";
    }
    /*public void equipweapon(String user, String commandLine) {
    RPGCharacter player = getPlayer(user);
    if (player == null) {return;}
    }*/
    /*public void unequipweapon(String user, String commandLine) {
    RPGCharacter player = getPlayer(user);
    if (player == null) {return;}
    if (player.getCurrentWeapon() != null) {
    player.unequipWeapon(player.getCurrentWeapon());
    } else {
    world.getPublicMessageTarget().msg("Du trägst keine Waffe, " + player.getName() + ".");
    }
    }*/

    public void target(String user, String commandLine) {
        RPGCharacter player = getPlayer(user);
        if (player == null) {
            return;
        }
        RPGCharacter target = player.getTarget();
        player.msg(target != null ? "Ziel: " + target.getName() : "Kein Ziel ausgewählt");
    }

    public String target() {
        return "Gibt das derzeit ausgewählt Ziel an";
    }

    public void iteminfo(String user, String commandLine) {
        RPGCharacter player = getPlayer(user);
        if (player == null) {
            return;
        }



        Inventory inventory = player.getInventory();

        if (commandLine.isEmpty()) {
            player.allMsg("Du musst einen Itemnamen angeben, " + player.getName() + ".");
            return;
        }

        try {
            Item i = Matching.getBestMatch(inventory.getItems(), commandLine);
            if (i != null) {

                player.msg(i.itemInfo());
                return;
            }
            player.allMsg("Kein Gegenstand mit diesem Namen im Inventar" + ", " + player.getName() + ".");
        } catch (MultipleMatchException ex) {
            world.getPublicMessageTarget().msg(player.getName() + ", " + ex.getMessage());
        }
    }

    public void use(String user, String commandLine) {
        RPGCharacter player = getPlayer(user);
        if (player == null) {
            return;
        }

        try {
            player.checkAlive();
        } catch (RPGException ex) {
            player.allMsg(ex.getMessage() + ", " + player.getName() + ".");
            return;
        }

        Inventory inventory = player.getInventory();
        try {
            if (commandLine.isEmpty()) {
                Location location = player.getPosition().getLocation();
                if (player.getPosition().getLocation() instanceof Usable) {
                    Usable usable = (Usable) location;
                    player.use(usable);
                } else {
                    world.getPublicMessageTarget().msg("Keine Interaktion mit dieser Umgebung möglich" + ", " + player.getName() + ".");
                }
                return;
            }
            //for (Item i : inventory.getItems()) {
            Set<Item> items = inventory.getItems();
            Iterator<Item> it = items.iterator();
            Set<Class<? extends Item>> itemClasses = new HashSet<Class<? extends Item>>();
            while (it.hasNext()) {
            Item next = it.next();
            if (itemClasses.contains(next.getClass())) {
            it.remove();
            }
                        itemClasses.add(next.getClass());
            }
            Item i = Matching.getBestMatch(items, commandLine);
            if (i == null) {
                world.getPublicMessageTarget().msg("Kein Gegenstand mit diesem Namen im Inventar" + ", " + player.getName() + ".");
                return;
            }
            player.use(i);
            return;
        } catch (RPGException ex) {
            world.getPublicMessageTarget().msg(ex.getMessage() + ", " + player.getName() + ".");
            return;
        } catch (MultipleMatchException ex) {
            world.getPublicMessageTarget().msg(player.getName() + ", " + ex.getMessage());
        }

    }

    public void useitemnumber(String user, String commandLine) {
        RPGCharacter player = getPlayer(user);
        if (player == null) {
            return;
        }
        try {
            player.checkAlive();
            int index = Integer.parseInt(commandLine);
            Object[] items = player.getInventory().getItems().toArray();
            if (index < 0 || index >= items.length) {
                player.allMsg("Kein Gegenstand mit dieser Nummer");
                return;
            }
            player.use(((Item) items[index]));
        } catch (NumberFormatException ex) {
            player.allMsg(player.getName() + ": " + useitemnumber());
        } catch (RPGException ex) {
            player.allMsg(ex.getMessage() + ", " + player.getName() + ".");
        }
        //TODO Everything
    }

    public String iteminfonumber() {
        return "!iteminfonumber <Inventarnummer> - gibt Informationen über den Gegenstand zurück";
    }

    public String iteminfo() {
        return "!iteminfo <Name des Gegenstands> - gibt Informationen über den Gegenstand zurück";
    }

    public void iteminfonumber(String user, String commandLine) {
        RPGCharacter player = getPlayer(user);
        if (player == null) {
            return;
        }
        try {
            int index = Integer.parseInt(commandLine);
            Object[] items = player.getInventory().getItems().toArray();
            if (index < 0 || index >= items.length) {
                player.allMsg("Kein Gegenstand mit dieser Nummer, " + player.getName() + ".");
                return;
            }
            player.msg(((Item) items[index]).itemInfo());
        } catch (NumberFormatException ex) {
            player.allMsg(player.getName() + ": " + iteminfonumber());
        }
        //TODO Everything
    }

    public String useitemnumber() {
        return "Benutze einen Gegenstand aus dem Inventar mit Angabe der Gegenstandsnummer: !useitemnumber <Nummer>";
    }

    public String use() {
        return "Interaktion mit der Umgebung, oder aber Benützung eines Gegenstands aus deinem Inventar mit !use <Name des Gegenstands>";
    }

    public void inventory(String user, String commandLine) {
        RPGCharacter player = getPlayer(user);
        if (player == null) {
            return;
        }
        Inventory inventory = player.getInventory();
        Map<String, Integer> itemMap = new HashMap<String, Integer>();
        Map<String, Set<Integer>> itemIds = new HashMap<String, Set<Integer>>();
        int counter = 0;
        for (Object o : inventory.getItems().toArray()) {
            Item i = (Item) o;
            if (itemMap.containsKey(i.getName())) {
                itemMap.put(i.getName(), itemMap.get(i.getName()) + 1);
                itemIds.get(i.getName()).add(counter);
            } else {
                itemMap.put(i.getName(), 1);
                HashSet<Integer> numbers = new HashSet<Integer>();
                numbers.add(counter);
                itemIds.put(i.getName(), numbers);
            }
            counter++;
        }
        player.msg("Gold: " + inventory.getGold());
        for (Map.Entry<String, Integer> e : itemMap.entrySet()) {
            String ids = "";
            for (Integer integer : itemIds.get(e.getKey())) {
                ids += "[" + integer + "]";
            }
            player.msg(e.getKey() + ": " + e.getValue() + " - Gegenstandsnummern: " + ids);
        }
        player.msg("Freie Plätze: " + inventory.freeSlots() + ", Freies Gewicht: " + inventory.freeWeight() + "g");
    }

    public String inventory() {
        return "Gibt dein Inventar aus";
    }

    public void weaponinfo(String user, String commandLine) {
        RPGCharacter player = getPlayer(user);
        if (player == null) {
            return;
        }


        Set<Weapon> weaponSet = new HashSet<Weapon>();
        for (Item i : player.getInventory().getItems()) {
            if (i instanceof Weapon) {
                weaponSet.add((Weapon) i);
            }
        }
        for (Weapon weapon : weaponSet) {
            String flag = "";
            if (weapon == player.getCurrentWeapon()) {
                flag = "(Primärwaffe) ";
            } else if (weapon == player.getSecondCurrentWeapon()) {
                flag = "(Sekundärwaffe) ";
            }
            player.msg(flag + weapon.itemInfo());

        }
    }

    public String weaponinfo() {
        return "Gibt dir Informationen über die Waffen, die du gerade trägst";
    }

    public void markers(String user, String commandLine) {
        RPGCharacter player = getPlayer(user);
        if (player == null) {
            return;
        }
        String message = "Wegweiser nach:";
        if (!player.getPosition().isOnPath()) {
            Location location = player.getPosition().getLocation();
            for (Path p : ((Locality) location).getPaths()) {
                for (Locality l : p.getLocalities()) {
                    if (l != location) {
                        message += " " + l.getName() + ";";
                    }
                }
            }
        } else {
            message = "Bereits unterwegs.";
        }
        player.msg(message);
    }

    public String markers() {
        return "Zeigt die von deiner derzeitigen Position direkt erreichbaren Orte an";
    }

    public void info(String user, String commandLine) {
        RPGCharacter player = getPlayer(user);
        if (player == null) {
            return;
        }
        player.msg("Name: " + player.getName() + ", Heimat: " + player.getHome().getName() + ", Stufe: " + player.getLevel() + ", XP: " + player.getXP() + ", Level-Up: " + player.getNextLevel() + ", Gesundheit: " + player.getHealth() + "/" + player.getMaxHealth() + ", Stärke: " + player.getStrength() + ", Mana: " + player.getMana() + "/" + player.getMaxMana() + ", Status: " + player.getState().getDescription() + ", Fähigkeitspunkte: " + player.getSkillPoints());
        StringBuffer skills = new StringBuffer();
        skills.append("Fähigkeiten:");
        for (Skill s : player.getSkills()) {
            skills.append(" " + s.getName() + "(" + s.getProgress() / 100 + "%);");
        }
        player.msg(skills.toString());
        //player.msg("Fähigkeiten: ");
    }

    public String info() {
        return "Gibt Informationen über deinen Charakter aus";
    }

    public void location(String user, String commandLine) {
        RPGCharacter player = getPlayer(user);
        if (player == null) {
            return;
        }
        Position p = player.getPosition();
        if (p.isOnPath()) {



            player.msg("Ort: " + p.getLocation().getName() + (player.isMoving() ? ", du bist unterwegs von " : ", du stehst auf dem Weg von ") + p.getStart().getName() + " nach " + p.getDestination().getName() + ", Fortschritt: " + (int) (p.getProgress() * 100) + "%");


        } else {
            player.msg("Ort: " + p.getLocation().getName());
        }
    }

    public String location() {
        return "Gibt deine derzeitige Position an";
    }

    public void stop(String user, String commandLine) {
        RPGCharacter player = getPlayer(user);
        if (player == null) {
            return;
        }
        //player.hold();
        player.stop();
        //player.commit();
    }

    public String stop() {
        return "Auf dem Weg stehen bleiben";
    }

    public void create(String user, String commandLine) {
        try {
            world.getPlayerFactory().createPlayer(user);
            world.getPublicMessageTarget().msg("Charakter für " + user + " erzeugt.");
        } catch (RPGException ex) {
            if (ex.getType() == RPGException.Type.IDENTITY) {
                world.getPublicMessageTarget().msg("Du verfügst bereits über einen Charakter, " + user + ".");
            } else {
                world.getPublicMessageTarget().msg(ex.getMessage());
            }
        }
    }

    public String create() {
        return "Erzeugt einen Charakter mit deinem Nicknamen";
    }

    public void help(String user, String commandLine) {
        for (Method m : this.getClass().getMethods()) {
            Class[] pt = m.getParameterTypes();
            if (pt.length == 2 && String.class.equals(pt[0]) && String.class.equals(pt[1])) {
                String usage = "Keine Hilfe vorhanden.";
                try {
                    usage = this.getClass().getMethod(m.getName()).invoke(this).toString();
                } catch (NoSuchMethodException ex) {
                } catch (IllegalAccessException ex) {
                } catch (InvocationTargetException ex) {
                }
                world.getMessagingService().createPrivateMessageTarget(user).msg("!" + m.getName() + ": " + usage);
            }
        }
    }

    public String help() {
        return "Gibt diese Hilfe aus";
    }

    private RPGCharacter getPlayer(String user) {
        try {
            return world.getLibrary().getPlayer(user);
        } catch (RPGException ex) {
            world.getPublicMessageTarget().msg("Du verfügst nicht über einen Charakter, " + user + ".");
            return null;
        }
    }
}
