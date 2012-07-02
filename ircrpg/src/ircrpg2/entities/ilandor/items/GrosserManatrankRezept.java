/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.items;
import ircrpg2.core.Item;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.Skill;
import ircrpg2.entities.common.*;
import ircrpg2.entities.ilandor.skills.Alchemist;
import java.util.*;
import java.util.Set;
/**
 *
 * @author testi
 */
public class GrosserManatrankRezept extends RecipeCommon {


    
    public Map<Item, Integer> getRequiredResources() {
        HashMap<Item, Integer> hashMap = new HashMap<Item, Integer>();
        hashMap.put(new Myrtille(), 20);
        return hashMap;
    }

    /*@Override
    public String itemInfo() {
        return "Rezept, um einen erheblichen Heiltrank zu brauen: " + super.itemInfo();
    }*/

    
    public Set<Skill> getRequiredSkills() {
        Set<Skill> s = new HashSet<Skill>();
        s.add(new Alchemist());
        return s;
    }

    
    public Item getResult() {
        return new GrosserManatrank();
    }

    public String getName() {
        return "Rezept Grosser Manatrank";
    }

    public int getWeight() {
        return 200;
    }

    public void onItemRemoved(RPGCharacter user) {

    }

}
