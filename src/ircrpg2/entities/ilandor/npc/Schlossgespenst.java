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
public class Schlossgespenst extends NPCCommon {

    @Override
    public boolean isFriendly(RPGCharacter character) {
        return character instanceof Schlossgespenst;
    }

    public Schlossgespenst(World world, Locality locality, int id) {
        super(world, 4, locality, new Kaeltestrahl(), null, "Schlossgespenst " + id);
        //super(world, 80, 80, 5, locality, new Kaeltestrahl(), null, "Schlossgespenst " + id, 0, 0, 0, CharacterState.ALIVE, new HashSet<Skill>(), new Position(locality));
    }
private static class Kaeltestrahl extends Weapon {

        @Override
        public int getDamageBlock() {
            return 0;
        }

        @Override
        public int getMaxDamage() {
            return 30;
        }

        @Override
        public int getMinDamage() {
            return 10;
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
            return 18;
        }

        public String getName() {
            return "Kältestrahl";
        }

        public int getWeight() {
            return 0;
        }

}
}
