/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.npc;

import ircrpg2.core.CharacterState;
import ircrpg2.core.Locality;
import ircrpg2.core.Position;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.Skill;
import ircrpg2.core.Weapon;
import ircrpg2.core.World;
import ircrpg2.entities.common.NPCCommon;
import java.util.HashSet;

/**
 *
 * @author simulity
 */
public class Riesenwurm extends NPCCommon{
    public Riesenwurm(World world, Locality locality, int id){
        super(world, 36, locality, new Giftspucke(), null, "Riesenwurm " + id);
        //super(world, 400, 400, 60, locality, new Giftspucke(), null, "Riesenwurm " + id, 0, 0, 0, CharacterState.ALIVE, new HashSet<Skill>(), new Position(locality));
    }

    @Override
    public boolean isFriendly(RPGCharacter character) {
        return character instanceof Riesenwurm;
    }
    public static class Giftspucke extends Weapon{

        @Override
        public int getMaxDamage() {
            return 60;
        }

        @Override
        public int getMinDamage() {
            return 40;
        }

        @Override
        public double getRange() {
            return 40;
        }

        @Override
        public double getSpeed() {
            return 8;
        }

        @Override
        public int getRequiredStrength() {
            return 60;
        }

        @Override
        public int getDamageBlock() {
            return 0;
        }

        public int getWeight() {
            return 10000;
        }

        public String getName() {
            return "Giftige Spucke";
        }
    }
}
