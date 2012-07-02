/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.npc;
import ircrpg2.core.*;
import ircrpg2.entities.common.*;
//import ircrpg2.entities.items.*;
import java.util.*;
/**
 *
 * @author testi
 */
public class Zyrenbaermutter extends Zyrenbaer {

    

    public Zyrenbaermutter(World world, Locality locality) {
        super(world,54, locality, new Pranke(), null, "Zyrenbärmutter");
        //super(world, 600, 600, 60, locality, new Pranke(), null, "Zyrenbärmutter", 0, 0, 0, CharacterState.ALIVE, new HashSet<Skill>(), new Position(locality));
    }
private static class Pranke extends Weapon {

        @Override
        public int getDamageBlock() {
            return 0;
        }

        @Override
        public int getMaxDamage() {
            return 120;
        }

        @Override
        public int getMinDamage() {
            return 80;
        }

        @Override
        public double getRange() {
            return 15;
        }

        @Override
        public int getRequiredStrength() {
            return 0;
        }

        @Override
        public double getSpeed() {
            return 15;
        }

        public String getName() {
            return "Pranke";
        }

        public int getWeight() {
            return 0;
        }

}
}
