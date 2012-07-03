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
public class Zyrenbaerjunges extends Zyrenbaer {



    public Zyrenbaerjunges(World world, Locality locality, int id) {
        super(world,26, locality, new Pranke(), null, "Junger Zyrenbär " + id);
        //super(world, 300, 300, 60, locality, new Pranke(), null, "Junger Zyrenbär " + id, 0, 0, 0, CharacterState.ALIVE, new HashSet<Skill>(), new Position(locality));
    }
private static class Pranke extends Weapon {

        @Override
        public int getDamageBlock() {
            return 0;
        }

        @Override
        public int getMaxDamage() {
            return 80;
        }

        @Override
        public int getMinDamage() {
            return 60;
        }

        @Override
        public double getRange() {
            return 8;
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
            return "Kleine Pranke";
        }

        public int getWeight() {
            return 0;
        }

}
}
