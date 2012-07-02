/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.items;
import ircrpg2.core.Item;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.Skill;
import ircrpg2.entities.common.*;
import ircrpg2.entities.ilandor.skills.Schmied;
import java.util.*;
import java.util.Set;
/**
 *
 * @author testi
 */
public class PunktfeuerRezept extends RecipeCommon {


    
    public Map<Item, Integer> getRequiredResources() {
        HashMap<Item, Integer> hashMap = new HashMap<Item, Integer>();
        hashMap.put(new Holzbogen(), 1);
        hashMap.put(new Diamant(), 15);
        hashMap.put(new Eisenerz(), 6);
        hashMap.put(new Goldbrocken(), 2);
        hashMap.put(new Schleifstein(), 1);
        return hashMap;
    }

    
    public Set<Skill> getRequiredSkills() {
        Set<Skill> s = new HashSet<Skill>();
        s.add(new Schmied());
        return s;
    }

    
    public Item getResult() {
        return new Punktfeuer();
    }

    public String getName() {
        return "Rezept für den Punktfeuerbogen";
    }

    public int getWeight() {
        return 200;
    }

    public void onItemRemoved(RPGCharacter user) {

    }

}
