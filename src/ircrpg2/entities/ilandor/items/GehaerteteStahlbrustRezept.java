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
public class GehaerteteStahlbrustRezept extends RecipeCommon {

    @Override
    public Set<Skill> getRequiredSkills() {
        Set<Skill> s = new HashSet<Skill>();
        s.add(new Schmied());
        return s;
    }

    @Override
    public Item getResult() {
        return new GehaerteteStahlbrust();
    }

    @Override
    public Map<Item, Integer> getRequiredResources() {
        HashMap<Item, Integer> hashMap = new HashMap<Item, Integer>();
        hashMap.put(new Diamant(), 1);
        hashMap.put(new Silberstraehne(), 5);
        hashMap.put(new Stahlbrustpanzer(), 1);
        return hashMap;
    }

    public int getWeight() {
        return 200;
    }

    public void onItemRemoved(RPGCharacter user) {

    }

    public String getName() {
        return "Rezept für einen gehärteten Stahlbrustpanzer";
    }

}
