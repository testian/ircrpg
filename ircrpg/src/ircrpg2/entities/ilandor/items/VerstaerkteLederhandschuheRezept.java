/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.items;

import ircrpg2.core.Item;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.Skill;
import ircrpg2.entities.common.RecipeCommon;
import ircrpg2.entities.ilandor.skills.Schmied;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author simulity
 */
public class VerstaerkteLederhandschuheRezept extends RecipeCommon{

    @Override
    public Set<Skill> getRequiredSkills() {
        HashSet<Skill> s = new HashSet<Skill>();
        s.add(new Schmied());
        return s;
    }

    @Override
    public Item getResult() {
        return new VerstaerkteLederhandschuhe();
    }

    @Override
    public Map<Item, Integer> getRequiredResources() {
        HashMap<Item, Integer> hashMap = new HashMap<Item, Integer>();
        hashMap.put(new Harz(), 7);
        hashMap.put(new Silberstraehne(), 1);
        hashMap.put(new LederneHandschuhe(), 1);
        return hashMap;
    }

    public int getWeight() {
        return 200;
    }

    public void onItemRemoved(RPGCharacter user) {
        
    }

    public String getName() {
        return "Rezept für verstärkte Lederhandschuhe";
    }

}
