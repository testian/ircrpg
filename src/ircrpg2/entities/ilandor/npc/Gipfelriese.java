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
public class Gipfelriese extends NPCCommon {

    @Override
    public boolean isFriendly(RPGCharacter character) {
        return character instanceof Gipfelriese;
    }

    public Gipfelriese(World world, Locality locality) {
        super(world, 96, locality, new Donnerhand(), null, "Wutmar der Gipfelriese");
        //super(world, 1000, 1000, 60, locality, new Donnerhand(), null, "Wutmar der Gipfelriese", 0, 0, 0, CharacterState.ALIVE, new HashSet<Skill>(), new Position(locality));
    }
private static class Donnerhand extends Weapon {

        @Override
        public int getDamageBlock() {
            return 0;
        }

        @Override
        public int getMaxDamage() {
            return 150;
        }

        @Override
        public int getMinDamage() {
            return 80;
        }

        @Override
        public double getRange() {
            return 20;
        }

        @Override
        public int getRequiredStrength() {
            return 0;
        }

        @Override
        public double getSpeed() {
            return 20;
        }

        public String getName() {
            return "Donnerhand";
        }

        public int getWeight() {
            return 0;
        }

}
}
