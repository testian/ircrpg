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
public class ManasteigerungRezept extends RecipeCommon {


    
    public Map<Item, Integer> getRequiredResources() {
        HashMap<Item, Integer> hashMap = new HashMap<Item, Integer>();
        hashMap.put(new Esperit(), 4);
        hashMap.put(new Myrtille(), 30);
        return hashMap;
    }

    
    public Set<Skill> getRequiredSkills() {
        Set<Skill> s = new HashSet<Skill>();
        s.add(new Alchemist());
        return s;
    }

    
    public Item getResult() {
        return new Manasteigerung();
    }

    public String getName() {
        return "Rezept, um einen Trank der magischen Energie zu brauen";
    }

    public int getWeight() {
        return 200;
    }

    public void onItemRemoved(RPGCharacter user) {

    }

}
