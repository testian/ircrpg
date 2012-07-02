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
public class Wolkenkratzer extends NPCCommon {

    @Override
    public boolean isFriendly(RPGCharacter character) {
        return character instanceof Wolkenkratzer;
    }

    public Wolkenkratzer(World world, Locality locality) {
        super(world, 496, locality, new Blitzstab(), null, "Marhassan der Wolkenkratzer");
        //super(world, 5000, 5000, 60, locality, new Blitzstab(), null, "Marhassan der Wolkenkratzer", 0, 0, 0, CharacterState.ALIVE, new HashSet<Skill>(), new Position(locality));
    }
private static class Blitzstab extends Weapon {

        @Override
        public int getDamageBlock() {
            return 0;
        }

        @Override
        public int getMaxDamage() {
            return 750;
        }

        @Override
        public int getMinDamage() {
            return 400;
        }

        @Override
        public double getRange() {
            return 100;
        }

        @Override
        public int getRequiredStrength() {
            return 0;
        }

        @Override
        public double getSpeed() {
            return 30;
        }

        public String getName() {
            return "Blitzstab";
        }

        public int getWeight() {
            return 0;
        }

}
}
