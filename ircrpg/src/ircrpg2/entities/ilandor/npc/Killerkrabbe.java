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
public class Killerkrabbe extends NPCCommon {

    @Override
    public boolean isFriendly(RPGCharacter character) {
        return character instanceof Killerkrabbe;
    }

    public Killerkrabbe(World world, Locality locality, int id) {
        super(world, 40, 40, 5, locality, new Killerschere(), null, "Killerkrabbe " + id, 0, 0, 0, CharacterState.ALIVE, new HashSet<Skill>(), new Position(locality));
    }
private static class Killerschere extends Weapon {

        @Override
        public int getDamageBlock() {
            return 0;
        }

        @Override
        public int getMaxDamage() {
            return 12;
        }

        @Override
        public int getMinDamage() {
            return 4;
        }

        @Override
        public double getRange() {
            return 3;
        }

        @Override
        public int getRequiredStrength() {
            return 0;
        }

        @Override
        public double getSpeed() {
            return 8;
        }

        public String getName() {
            return "Killerschere";
        }

        public int getWeight() {
            return 0;
        }

}
}
