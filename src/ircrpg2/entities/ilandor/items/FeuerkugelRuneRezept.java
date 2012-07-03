/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.items;
import ircrpg2.core.Item;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.Skill;
import ircrpg2.entities.common.*;
import ircrpg2.entities.ilandor.skills.Magier;
import ircrpg2.entities.ilandor.skills.Schmied;
import java.util.*;
import java.util.Set;
/**
 *
 * @author testi
 */
public class FeuerkugelRuneRezept extends RecipeCommon {


    
    public Map<Item, Integer> getRequiredResources() {
        HashMap<Item, Integer> hashMap = new HashMap<Item, Integer>();
        hashMap.put(new Eisenerz(), 1);
        hashMap.put(new Silberstraehne(), 1);
        hashMap.put(new Goldbrocken(), 1);
        hashMap.put(new Diamant(), 1);
        hashMap.put(new Esperit(), 10);
        hashMap.put(new FeuerkugelSpruchrolle(), 1);

        return hashMap;
    }

    /*@Override
    public String itemInfo() {
        return "Rezept, um einen erheblichen Heiltrank zu brauen: " + super.itemInfo();
    }*/

    
    public Set<Skill> getRequiredSkills() {
        Set<Skill> s = new HashSet<Skill>();
        s.add(new Schmied());
        s.add(new Magier());
        return s;
    }

    
    public Item getResult() {
        return new FeuerkugelRune();
    }

    public String getName() {
        return "Rezept Rune Feuerkugel";
    }

    public int getWeight() {
        return 200;
    }

    public void onItemRemoved(RPGCharacter user) {

    }

}
