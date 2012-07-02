/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.common;
import ircrpg2.core.*;
import java.util.Set;
import java.util.*;
/**
 *
 * @author testi
 */
public class ResourceCommon implements Resource {
    
    long time;
    Set<ItemResource> itemResources;
    public ResourceCommon()
    {
    time = System.currentTimeMillis()-10*3600*1000;
    itemResources = new HashSet<ItemResource>();
    }
    public void addItemResource(ItemFactory factory, double rate, long peak, Class<? extends Skill> requiredSkill, Class<? extends Item> requiredItemClass) {
    itemResources.add(new ItemResource(factory, rate, peak, requiredSkill, requiredItemClass));
    }

    public void addItemResource(ItemFactory factory, double rate, long peak, Class<? extends Skill> requiredSkill) {
    itemResources.add(new ItemResource(factory, rate, peak, requiredSkill));
    }
    public void addItemResource(Class<? extends Item> itemClass, double rate, long peak, Class<? extends Skill> requiredSkill, Class<? extends Item> requiredItemClass) {
    itemResources.add(new ItemResource(new ItemFactory(itemClass), rate, peak, requiredSkill, requiredItemClass));
    }

    public void addItemResource(Class<? extends Item> itemClass, double rate, long peak, Class<? extends Skill> requiredSkill) {
    itemResources.add(new ItemResource(new ItemFactory(itemClass), rate, peak, requiredSkill));
    }
    
    public void harvest(RPGCharacter harvester) {
    harvest(harvester,null);
    }
    public void harvest(RPGCharacter harvester, Class<? extends Item> itemClass) {
    harvest(harvester,itemClass,false);
    }

    public Set<Class<? extends Item>> itemsAvailable(RPGCharacter harvester) {
        return harvest(harvester,null,true);
    }
    
    private Set<Class<? extends Item>> harvest(RPGCharacter harvester, Class<? extends Item> itemClass, boolean dryRun) {
    Set<Class<? extends Item>> itemClasses = new HashSet<Class <? extends Item>>();
    Set<Item> items = new HashSet<Item>();
    String exceptionMessage = null;
    Set<Item> newItems = new HashSet<Item>();
    do {
    newItems.clear();
    for (ItemResource ir : itemResources) {
        try {
        itemClasses.addAll(harvestItem(harvester, ir, newItems,1,itemClass, dryRun));
        } catch (RPGException ex) {
        exceptionMessage = ex.getMessage();
        }
    }
    items.addAll(newItems);
    } while (!newItems.isEmpty());

    if (dryRun) return itemClasses;

    //Do the appropriate messaging
    if (items.isEmpty()) {
    if (exceptionMessage == null) {
        harvester.allMsg(harvester.getName() + " konnte nichts finden.");
    }
    else {
    harvester.allMsg(harvester.getName() + ", " + exceptionMessage + ".");
    }
    }


    else {
    StringBuffer itemList = new StringBuffer();
    for (Map.Entry e : StringUtils.itemList(items).entrySet()) {
    itemList.append(" " + e.getValue() + " " + e.getKey() + ";");
    }
    harvester.allMsg(harvester.getName() + " findet" + itemList.toString());
    }
    return itemClasses;
    }

    private Set<Class<? extends Item>> harvestItem(RPGCharacter harvester, ItemResource ir, Set<Item> items, int amount, Class<? extends Item> itemClass, boolean dryRun) throws RPGException {
    HashSet<Class<? extends Item>> itemClasses = new HashSet<Class<? extends Item>>();
        //System.out.println("Enter");
        if (!harvester.hasSkill(ir.getRequiredSkillClass()))
            return itemClasses;
    //System.out.println("Checkpoint 1");
    if (ir.getRequiredItemClass() != null && !harvester.getInventory().hasItem(ir.getRequiredItemClass()))
        return itemClasses;
    //System.out.println("Checkpoint 2");
    long elapsedTime = System.currentTimeMillis()-time;
    if (elapsedTime<0){elapsedTime=0;}
    double elapsedHours = elapsedTime/3600000.0;
    long itemsCreated = (long)(elapsedHours * ir.getRate());
    long itemsAvailable = itemsCreated - ir.getConsumption();
    Skill skill = harvester.getSkill(ir.getRequiredSkillClass());
    long itemsAvailableForHarvester = itemsAvailable-(long)((1-skill.getProgressAsDouble())*ir.getPeak());
   // System.out.println(elapsedHours + " " + itemsCreated + " " + itemsAvailable + " " + itemsAvailableForHarvester);
    for (int i = 0 ; i<itemsAvailableForHarvester && i < amount; i++) {
    
        Item item = ir.getFactory().create();
        if (itemClass != null && itemClass != item.getClass()) continue;
        itemClasses.add(item.getClass());
        if (dryRun) continue;
        harvester.getInventory().addItem(item);
        items.add(item);
        ir.increaseConsumption(1);
        int kgHarvested = item.getWeight()/1000;
        skill.increase(Math.max(1, kgHarvested));
    
    }
    return itemClasses;

    //Abrechnen
    //ir.increaseConsumption();

    //harvester.getSkill(ir.getRequiredSkillClass());
    }

    public static class ItemResource {
    ItemFactory factory;
    long consumption;
    double rate;
    Class<? extends Skill> requiredSkill;
    long peak; //If item amount reaches more than peak, then even lowest trained skill will find something.
    Class<? extends Item> requiredItemClass;

        public ItemResource(ItemFactory factory, double rate, long peak, Class<? extends Skill> requiredSkill, Class<? extends Item> requiredItemClass) {
            this.factory = factory;
            this.requiredItemClass = requiredItemClass;
            this.rate = rate;
            this.requiredSkill = requiredSkill;
            this.peak = peak;
            this.consumption = 0;
        }
        public ItemResource(ItemFactory factory, double rate, long peak, Class<? extends Skill> requiredSkill) {
        this(factory, rate, peak, requiredSkill, null);
        }

        public long getConsumption() {
            return consumption;
        }

        public ItemFactory getFactory() {
            return factory;
        }

        public long getPeak() {
            return peak;
        }

        public double getRate() {
            return rate;
        }

        public Class<? extends Item> getRequiredItemClass() {
            return requiredItemClass;
        }

        public Class<? extends Skill> getRequiredSkillClass() {
            return requiredSkill;
        }
        public void increaseConsumption(long add) {
        consumption+=add;
        }



    }

}
