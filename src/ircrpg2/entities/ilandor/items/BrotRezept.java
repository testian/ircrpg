/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.items;
import ircrpg2.core.Item;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.Skill;
import ircrpg2.entities.common.*;
import ircrpg2.entities.ilandor.skills.Baecker;
import java.util.*;
import java.util.Set;
/**
 *
 * @author testi
 */
public class BrotRezept extends RecipeCommon {


    
    public Map<Item, Integer> getRequiredResources() {
        HashMap<Item, Integer> hashMap = new HashMap<Item, Integer>();
        hashMap.put(new Weizensack(), 2);
        return hashMap;
    }

    /*public String itemInfo() {
        return super.itemInfo();
    }*/



    
    public Set<Skill> getRequiredSkills() {
        
        Set<Skill> s = new HashSet<Skill>();
        s.add(new Baecker());
        return s;
    }

    
    public Item getResult() {
        return new Brot();
    }

    public String getName() {
        return "Brotrezept";
    }

    public int getWeight() {
        return 200;
    }

    public void onItemRemoved(RPGCharacter user) {

    }

}
