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
public class Kornwurm extends NPCCommon {

    @Override
    public boolean isFriendly(RPGCharacter character) {
        return character instanceof Kornwurm;
    }

    public Kornwurm(World world, Locality locality, int id) {
        super(world, 20, 20, 5, locality, new Giftzahn(), null, "Kornwurm " + id, 0, 0, 0, CharacterState.ALIVE, new HashSet<Skill>(), new Position(locality));
    }
private static class Giftzahn extends Weapon {

        @Override
        public int getDamageBlock() {
            return 0;
        }

        @Override
        public int getMaxDamage() {
            return 4;
        }

        @Override
        public int getMinDamage() {
            return 2;
        }

        @Override
        public double getRange() {
            return 2;
        }

        @Override
        public int getRequiredStrength() {
            return 0;
        }

        @Override
        public double getSpeed() {
            return 25.0;
        }

        public String getName() {
            return "Giftzähne";
        }

        public int getWeight() {
            return 0;
        }

}
}
