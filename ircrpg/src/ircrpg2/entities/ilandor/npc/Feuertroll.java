/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.npc;

import ircrpg2.core.Locality;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.Weapon;
import ircrpg2.core.World;
import ircrpg2.entities.common.NPCCommon;

/**
 *
 * @author simulity
 */
public class Feuertroll extends NPCCommon{

    @Override
    public boolean isFriendly(RPGCharacter character) {
        return character instanceof Feuertroll;
    }
    public Feuertroll(World world, int level, Locality locality, int id){
        super(world, level, locality, new Feuerkeule(level), null,  "Feuertroll " + id);
        //super(world, 130, 130, 50, locality, new Trollkeule(), null, "Brückentroll", 0, 0, 0, CharacterState.ALIVE, new HashSet<Skill>(), new Position(locality));
    }
    private static class Feuerkeule extends Weapon {

        public Feuerkeule(int level) {
        this.level = level;
        }
        private int level;
        @Override
        public int getDamageBlock() {
            return (level+1)*7;
        }

        @Override
        public int getMaxDamage() {
            return (level+1)*15;
        }

        @Override
        public int getMinDamage() {
            return (level+1)*11;
        }

        @Override
        public double getRange() {
            return (level+1)*10.0;
        }

        @Override
        public int getRequiredStrength() {
            return 0;
        }

        @Override
        public double getSpeed() {
            return 10.0;
        }

        public String getName() {
            return "Feuerkeule";
        }

        public int getWeight() {
            return 0;
        }

    }
}
