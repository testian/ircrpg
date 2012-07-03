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
 * @author testi
 */
public class DiamantenpanzerRezept extends RecipeCommon {

    @Override
    public Set<Skill> getRequiredSkills() {
        Set<Skill> s = new HashSet<Skill>();
        s.add(new Schmied());
        return s;
    }

    @Override
    public Item getResult() {
        return new Diamantenpanzer();
    }

    @Override
    public Map<Item, Integer> getRequiredResources() {
        HashMap<Item, Integer> hashMap = new HashMap<Item, Integer>();
        hashMap.put(new Diamant(), 100);
        hashMap.put(new Fortanit(), 200);
        hashMap.put(new Harz(), 77);
        hashMap.put(new Holzscheit(), 77);
        hashMap.put(new Schleifstein(), 20);
        return hashMap;
    }

    public int getWeight() {
        return 200;
    }

    public void onItemRemoved(RPGCharacter user) {

    }

    public String getName() {
        return "Rezept für einen fortanen Diamantenpanzer";
    }

}
