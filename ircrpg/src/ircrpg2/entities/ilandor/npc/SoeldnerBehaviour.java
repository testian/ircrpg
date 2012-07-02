/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.npc;

import ircrpg2.core.Armor;
import ircrpg2.core.CharacterState;
import ircrpg2.core.Item;
import ircrpg2.core.ItemFactory;
import ircrpg2.core.Locality;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.RPGException;
import ircrpg2.core.Weapon;
import ircrpg2.entities.common.DefaultNPCBehaviour;
import ircrpg2.entities.common.npc.ai.Assist;
import ircrpg2.entities.common.npc.ai.TimeAssist;
import ircrpg2.entities.common.npc.ai.UseItem;
import java.util.Set;

/**
 *
 * @author testi
 */
public class SoeldnerBehaviour extends DefaultNPCBehaviour {

    private long costPerMinute;
    private RPGCharacter current;
    int minLevel;
    

    public SoeldnerBehaviour(long costPerMinute, int minLevel) {
        this.costPerMinute = costPerMinute;
        current = null;
        this.minLevel = minLevel;
    }


    

    private boolean isOnJobWith(RPGCharacter target) {
    return (current == target && isOnJob());
    }
    private boolean isOnJob() {
    return current != null && targetStack().contains(new Assist(getNpc(),current,this.getAssistBehaviour()));
    }

    @Override
    public void onGiveItem(RPGCharacter character, RPGCharacter target, Class<? extends Item> itemClass, int amount) {
        super.onGiveItem(character, target, itemClass, amount);
        if (target != getNpc() || getNpc().getState() == CharacterState.DEAD) return;
        if (isOnJobWith(character) && !(ItemFactory.instantiate(itemClass) instanceof Armor) && !(ItemFactory.instantiate(itemClass) instanceof Weapon)) {

        Set<Item> allItems = getNpc().getInventory().getItems();
        int c = 0;
        for (Item currentItem : allItems) {
        if (currentItem.getClass() == itemClass) {
        //if (c < amount) {
        targetStack().addTarget(new UseItem(getNpc(),character,currentItem));
        c++;/*} else {break;}*/
        }
        }
        targetStack().proceed();
        } else {
        try {
        getNpc().setTarget(character);
        getNpc().giveItems(itemClass, amount);

        } catch (RPGException ex) {
        Item currentItem = null;
        try {
        while ((currentItem = getNpc().getInventory().getItem(itemClass)) != null) {
        getNpc().getInventory().removeItem(currentItem);
        }
        } catch (RPGException ex2) {getNpc().msg(ex2.getMessage());}
        }
        }
    }


    @Override
    public void onGiveGold(RPGCharacter character, RPGCharacter target, long amount) {
        super.onGiveGold(character, target, amount);
        if (target != getNpc()) return;
        if (!this.isCurrentlyFriendly(character)) return;
        if (isOnJob()) {
        if (current != character)
        character.allMsg(getNpc().getName() + " sagt: " + "Jetzt nicht, " + character.getName() + ". Ich bin noch damit beschäftigt " + current.getName() + " zu helfen.");
        else
        character.allMsg(getNpc().getName() + " sagt: " + "Du hast mich schon bezahlt, " + character.getName() + ".");

        try {
        getNpc().setTarget(character);
        getNpc().giveGold(amount);}
        catch (RPGException ex) {
        getNpc().allMsg("Geldtransfer hat nicht funktioniert: " + ex.getMessage());
        }
            return;
        }
        character.allMsg(getNpc().getName() + " sagt: " + "Wunderbar, " + character.getName() + ". Ich werde dir " + (amount/costPerMinute) + " Minuten beiseite stehen. Los gehts!");
        current = character;
        targetStack().addTarget(new TimeAssist(getNpc(),character,this.getAssistBehaviour(),(amount*60)/costPerMinute));
        targetStack().proceed();

    }



    /*@Override
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
    }*/

    @Override
    public void onReach(RPGCharacter character, Locality locality) {
        super.onReach(character, locality);

        if (getNpc().getState() == CharacterState.ALIVE && this.isCurrentlyFriendly(character) && !character.isNPC() && locality == getNpc().getHome()) {
        if (character.getLevel() >= minLevel && !isOnJob()) {
        character.allMsg(getNpc().getName() + " sagt: " + "Hey, " + character.getName() + ", Kannst du etwas Unterstützung gebrauchen? Ich verlange nur " + costPerMinute + " Goldstücke pro Minute.");
        }
        }
    }



}
