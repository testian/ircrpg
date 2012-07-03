/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.common;
import ircrpg2.core.ItemCommon;
import ircrpg2.core.*;
import java.util.*;
/**
 *
 * @author testi
 */
abstract public class RecipeCommon extends ItemCommon {

    public void use(RPGCharacter user) throws RPGException {
        for (Skill skill : getRequiredSkills())
        {
        Class<? extends Skill> skillClass = skill.getClass();
        if (!user.hasSkill(skillClass)) {
        printRecipe(user);
        return;
        }
        }
        Map<Item, Integer> resources = getRequiredResources();
        Inventory inventory = user.getInventory();
        for (Map.Entry<Item, Integer> entry : resources.entrySet()) {
        if (inventory.itemAmount(entry.getKey().getClass())<entry.getValue()) {
        printRecipe(user);
        return;
        }


        }

        for (Map.Entry<Item, Integer> entry : resources.entrySet()) {
            Class<? extends Item> itemClass = entry.getKey().getClass();
            int itemCount = entry.getValue();

            for (int i = 0;i<itemCount;i++) {
                try {
                inventory.removeItem(inventory.getItem(itemClass));
                } catch (RPGException ex) {
                user.allMsg("Interner Fehler: " + ex);
                }
            }
        }
        try {
            Item result = getResult();
            inventory.addItem(result);

                    for (Skill skill : getRequiredSkills())
        {
        Class<? extends Skill> skillClass = skill.getClass();
        user.getSkill(skillClass).increase(50);
        }

            user.allMsg(user.getName() + " erzeugt " + result.getName() + ".");

        } catch (RPGException ex) {
            giveEverythingBack(user);

            throw ex;
        }

    }
    abstract public Set<Skill> getRequiredSkills();
    abstract public Item getResult();
    abstract public Map<Item, Integer> getRequiredResources();

        public String itemInfo() {
        //String info = "";
        StringBuffer msg = new StringBuffer();
        msg.append("Zutaten: (");
        for (Map.Entry<Item, Integer> entry : getRequiredResources().entrySet()) {
        msg.append(entry.getKey().getName() + ": " + entry.getValue() + ";");
        }
        
        
        msg.append(") Fähigkeiten: (");
        for (Skill s : getRequiredSkills()) {
        msg.append(s.getName() + ";");
        }
        msg.append(")");
        return super.itemInfo() + ", " + msg.toString();
    }

    private void printRecipe(RPGCharacter user) {
    /*user.msg("Zutaten:");
        for (Map.Entry<Item, Integer> entry : getRequiredResources().entrySet()) {
        user.msg(entry.getKey().getName() + ": " + entry.getValue());
        }
        StringBuffer msg = new StringBuffer();
        msg.append("Fähigkeiten:");
        for (Skill s : getRequiredSkills()) {
        msg.append(" " + s.getName() + ";");
        }*/
        user.msg(itemInfo());
    }
    private void giveEverythingBack(RPGCharacter user) throws RPGException {
    Inventory inventory = user.getInventory();
        for (Map.Entry<Item, Integer> entry : getRequiredResources().entrySet()) {

            Class<? extends Item> itemClass = entry.getKey().getClass();
            int itemCount = entry.getValue();

            for (int i = 0;i<itemCount;i++) {
                try {
                inventory.addItem(itemClass.newInstance());
                } catch (RPGException ex) {
                user.allMsg("Interner Fehler, Art 2: " + ex);
                } catch (InstantiationException ex) {
                user.allMsg("Interner Fehler: " + ex);
                }
                catch (IllegalAccessException ex) {
                user.allMsg("Interner Fehler: " + ex);
                }
            }




        }
    }
    

}
