/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.npc;

import ircrpg2.core.CharacterState;
import ircrpg2.core.Locality;
import ircrpg2.core.RPGCharacter;
import ircrpg2.entities.common.DefaultNPCBehaviour;
import ircrpg2.entities.common.npc.ai.FindAndKill;
import java.util.HashMap;

/**
 *
 * @author testi
 */
public class WaechterBehaviour extends DefaultNPCBehaviour {

    private long validTime;
    private Locality defendLocality;
    private long cost;
    private HashMap<RPGCharacter,PayEntry> payList = new HashMap<RPGCharacter,PayEntry>();
    public WaechterBehaviour(long validTime, int cost, Locality defendLocality) {
    this.validTime = validTime;
    this.defendLocality = defendLocality;
    this.cost = cost;
    }

    private class PayEntry {
        private long gold;
        private long payTime;
        public PayEntry() {
        this.gold = 0;
        payTime = 0;
        }

        public long getGold() {
            return gold;
        }
        public void increase(long gold) {

        checkGold(gold);
        this.gold+=gold;
        }
        private void checkGold(long gold) {
        if (this.gold>=cost) return;
        if (this.gold+gold>=cost) {
        payTime=System.currentTimeMillis()/1000;
        }
        }
        public boolean isValid() {
        return System.currentTimeMillis()/1000<= payTime+validTime;
        }
        public long remainingTime() {
        long remain = (payTime+validTime)-System.currentTimeMillis()/1000;
        if (remain < 1) return 0;
        return remain;
        }
        public boolean wasValid() {
        return payTime != 0;
        }


    }

    @Override
    public void onGiveGold(RPGCharacter character, RPGCharacter target, long amount) {
        super.onGiveGold(character, target, amount);
        if (target != getNpc() || getNpc().getState() == CharacterState.DEAD) return;
        PayEntry p = payList.get(character);
        if (p == null || p.wasValid()) {
        p = new PayEntry();
        payList.put(character, p);
        }
        
        if (p.isValid()) {
        p.increase(amount);
        character.allMsg(getNpc().getName() + " sagt: " + "Vielen Dank für das Trinkgeld " + character.getName() + ". Ein harter Job hier Wache zu schieben.");
        }
        else {
        p.increase(amount);
        if (p.isValid()) {
        character.allMsg(getNpc().getName() + " sagt: " + character.getName() + ", du kannst " + (p.remainingTime()/60) + " Minuten lang passieren." + (p.getGold() > cost ? " Achja, und danke für das Trinkgeld.":""));
        } else {
        character.allMsg(getNpc().getName() + " sagt: " + "Danke für die Anzahlung, " + character.getName() + ". Es fehlen mir nur noch " + (cost-p.getGold()) + " Goldmünzen.");
        }

        }

    }



    @Override
    public void onMove(RPGCharacter character, Locality locality) {
        super.onMove(character, locality);
        if (getNpc().getState() == CharacterState.DEAD) return;
        if (locality != defendLocality || character.isNPC()) return;
        PayEntry p = payList.get(character);
        if (p == null || !p.isValid()) {
        this.addTemporaryEnemy(character);
        this.targetStack().addTarget(new FindAndKill(getNpc(),character,this.getAttackBehaviour()));
        this.targetStack().proceed();
        }
    }

    @Override
    public void onReach(RPGCharacter character, Locality locality) {
        super.onReach(character, locality);

        if (getNpc().getState() == CharacterState.ALIVE && this.isCurrentlyFriendly(character) && !character.isNPC() && locality == getNpc().getHome()) {

            PayEntry p = payList.get(character);
            if (p == null) {
            character.allMsg(getNpc().getName() + " sagt: " + "Halt, " + character.getName() + "! Wenn du nach " + defendLocality.getName() + " gehen möchtest, musst du " + cost + " Gold bezahlen.");
            }
            else if (p.isValid()) {
            character.allMsg(getNpc().getName() + " sagt: " + "Gut " + character.getName() + ". Deine Einzahlung ist noch gültig. Du kannst noch während " + (p.remainingTime()/60) + " Minuten passieren.");
            } else if (p.wasValid()) {
            payList.remove(character);
            character.allMsg(getNpc().getName() + " sagt: " + character.getName() + ". Deine Einzahlung ist nicht mehr gültig. Du musst erneut " + cost + " Gold bezahlen.");
            }
            else {
            character.allMsg(getNpc().getName() + " sagt: " + character.getName() + ". Deine Einzahlung ist noch ungenügend. Es fehlen noch " + (cost-p.getGold()) + " Gold.");
            }

        }
    }



}
