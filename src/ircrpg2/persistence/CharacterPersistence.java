/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.persistence;
import ircrpg2.core.ItemCommon;
import ircrpg2.entities.common.*;

import ircrpg2.core.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author testi
 */
public class CharacterPersistence {

    final World world;
    final Library library;
    public CharacterPersistence(World world) {
    this.world = world;
    library = world.getLibrary();
    }

    public void persistCharacter(RPGCharacter c, File f) throws IOException {
        synchronized(world) {
    PersistedMap p = new PersistedMap();
    p.put("health", Integer.toString(c.getHealth()));
    p.put("maxhealth", Integer.toString(c.getMaxHealth()));
    p.put("home", c.getHome().getName());
    p.put("mana", Integer.toString(c.getMana()));
    p.put("maxmana", Integer.toString(c.getMaxMana()));
    Inventory inventory = c.getInventory();
    p.put("gold", Long.toString(inventory.getGold()));
    int counter = 0;
    for (Item i : inventory.getItems()) {
    if (i != c.getCurrentWeapon() && i != c.getSecondCurrentWeapon()) {
        p.put("inventory" + counter, i.getClass().getName() + "," + i.getIntegrity());
    counter++;
    }
    }
    p.put("name", c.getName());
    p.put("level", Integer.toString(c.getLevel()));
    p.put("skillpoints",Integer.toString(c.getSkillPoints()));
    Weapon currentWeapon = c.getCurrentWeapon();
    if (currentWeapon != null) {
    p.put("weapon", c.getCurrentWeapon().getClass().getName());
    }

        Weapon secondCurrentWeapon = c.getSecondCurrentWeapon();
    if (secondCurrentWeapon != null) {
    p.put("secondweapon", c.getSecondCurrentWeapon().getClass().getName());
    }

    p.put("strength", Integer.toString(c.getStrength()));
    p.put("xp", Long.toString(c.getXP()));

    counter = 0;
    for (Skill s : c.getSkills()) {
        p.put("skill" + counter, s.getClass().getName());
        p.put("skill_progress" + counter, Integer.toString(s.getProgress()));
    counter++;
    }
    Body body = c.getBody();
    Armor head = body.head();
    if (head != null) {
    p.put("body_head", head.getClass().getName());
    }
    Armor chest = body.chest();
    if (chest != null) {
    p.put("body_chest", chest.getClass().getName());
    }
    Armor hands = body.hands();
    if (hands != null) {
    p.put("body_hands", hands.getClass().getName());
    }
    Armor legs = body.legs();
    if (legs != null) {
    p.put("body_legs", legs.getClass().getName());
    }
    Armor feet = body.feet();
    if (feet != null) {
    p.put("body_feet", feet.getClass().getName());
    }

    p.put("state",c.getState().toString());
    Position position = c.getPosition();
    p.put("position_location", position.getLocation().getName());

    if (position.getDestination() != null && position.getStart() != null) {
    p.put("position_destination", position.getDestination().getName());
    p.put("position_start", position.getStart().getName());
    p.put("position_progress", Double.toString(position.getProgress()));
    }
    p.write(f);
    }
    }
    public RPGCharacter loadCharacter(File f) throws IOException {
        synchronized(library) {
    System.out.println("loadCharacter(" + f + ")");
    PersistedMap p = new PersistedMap();
    p.read(f);
    try {
    int health = Integer.valueOf(p.get("health"));
    int maxHealth = Integer.valueOf(p.get("maxhealth"));
    int strength = Integer.valueOf(p.get("strength"));

    int mana = 0;
    int maxMana = 0;

    try {
    mana = Integer.valueOf(p.get("mana"));
    maxMana = Integer.valueOf(p.get("maxmana"));
    } catch (NumberFormatException ex){}


    Locality home = library.getLocality(p.get("home"));
    String weaponClass = p.get("weapon");
    Weapon currentWeapon = null;
    if (weaponClass != null) {
    currentWeapon = (Weapon)Class.forName(weaponClass).newInstance();
    }

    String secondWeaponClass = p.get("secondweapon");
    Weapon secondCurrentWeapon = null;
    if (secondWeaponClass != null) {
    secondCurrentWeapon = (Weapon)Class.forName(secondWeaponClass).newInstance();
    }

    String name = p.get("name");
    long xp = Long.valueOf(p.get("xp"));
    int level = Integer.valueOf(p.get("level"));
    int skillPoints = Integer.valueOf(p.get("skillpoints"));
    
    CharacterState state = CharacterState.ALIVE;
    //CharacterState state = CharacterState.valueOf(p.get("state"));
    //if (state == null) {throw new NullPointerException();}


    Position finalPosition;

    String position_start = p.get("position_start");

    String position_destination = p.get("position_destination");
    if (position_start != null && position_destination != null) {
        Path location = library.getPath(p.get("position_location"));
        Locality start = library.getLocality(position_start);
        Locality destination = library.getLocality(position_destination);
        double progress = Double.valueOf(p.get("position_progress"));
        finalPosition = new Position(location,start,destination,progress);

    } else {
    finalPosition = new Position(library.getLocality(p.get("position_location")));

    }

    int counter = 0;
    String value;
    HashSet<Skill> skillSet = new HashSet<Skill>();
    while ((value = p.get("skill" + counter)) != null) {
    Skill skill = (Skill)Class.forName(value).newInstance();
    skill.setProgress(Integer.valueOf(p.get("skill_progress" + counter)));
    skillSet.add(skill);
    counter++;
    }
    counter = 0;
    LinkedList<Item> items = new LinkedList<Item>();
        while ((value = p.get("inventory" + counter)) != null) {
            String className = value;
            int integrity = ItemCommon.DEFAULT_INTEGRITY;
            String[] fields = value.split(",");
            if (fields.length == 2) {
            value = fields[0];
            try {
            integrity = Integer.parseInt(fields[1]); } catch (NumberFormatException ex) {}
            }

    Item item = (Item)Class.forName(value).newInstance();
    item.setIntegrity(integrity);
    items.add(item);
    counter++;
    }

    RPGCharacter finalCharacter = new CharacterCommon(world, health, maxHealth, strength, home, currentWeapon, secondCurrentWeapon, name, xp, level, skillPoints, state, skillSet, finalPosition, mana, maxMana);
    Inventory finalInventory = finalCharacter.getInventory();

    Collections.sort(items, new Comparator<Item>() {

                    public int compare(Item o1, Item o2) {
                        if (o1 instanceof Bag && o2 instanceof Bag) return 0;
                        if (o1 instanceof Bag) return -1;
                        return 1;
                    }

    } );
    for (Item i : items) {
        finalInventory.addItem(i);
    }
    finalInventory.addGold(Integer.valueOf(p.get("gold")));

    String head = p.get("body_head");
    if (head != null) {
    finalInventory.getItem((Class<Item>)Class.forName(head)).use(finalCharacter);
    }
    String chest = p.get("body_chest");
    if (chest != null) {
    finalInventory.getItem((Class<Item>)Class.forName(chest)).use(finalCharacter);
    }
    String hands = p.get("body_hands");
    if (hands != null) {
    finalInventory.getItem((Class<Item>)Class.forName(hands)).use(finalCharacter);
    }
    String legs = p.get("body_legs");
    if (legs != null) {
    finalInventory.getItem((Class<Item>)Class.forName(legs)).use(finalCharacter);
    }
    String feet = p.get("body_feet");
    if (feet != null) {
    finalInventory.getItem((Class<Item>)Class.forName(feet)).use(finalCharacter);
    }
    //finalCharacter.addCharacterEventListener(new CharacterEventMessager(world.getMessagingService().createPrivateMessageTarget(finalCharacter.getName()),world.getMessagingService().getPublicMessageTarget()));
    //finalCharacter.addCharacterEventListener(world.getGlobalListener());

    world.getPlayerFactory().attachPlayer(finalCharacter);
    //finalCharacter.setPrivateMessageTarget(world.getMessagingService().createPrivateMessageTarget(finalCharacter.getName()));
    //finalCharacter.setPublicMessageTarget(world.getMessagingService().getPublicMessageTarget());
    //System.err.println(finalCharacter.getCurrentWeapon() + " <- first - second ->" + finalCharacter.getSecondCurrentWeapon());
    return finalCharacter;
    } catch (NumberFormatException ex) {throw new IOException(ex);}
    catch (NullPointerException ex) {
        ex.printStackTrace();
        throw new IOException(ex);}
    catch (RPGException ex) {ex.printStackTrace();throw new IOException(ex);}
    catch (ClassNotFoundException ex) {throw new IOException(ex);}
    catch (InstantiationException ex) {throw new IOException(ex);}
    catch (IllegalAccessException ex) {throw new IOException(ex);}

    
    
    


        
        }
    }
}
