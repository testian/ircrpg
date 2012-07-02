/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.messaging;
import ircrpg2.core.*;
/**
 *
 * @author testi
 */
public class FilteredMessager implements CharacterEventListener {

    CharacterEventMessager messager;
    public FilteredMessager(MessageTarget all) {
    messager = new CharacterEventMessager(new MessageTarget() {

            public void msg(String message) {
                //TODO, nice place for NPC debug messages eventually
            }

    } , all);
    }

    public void onXPIncrease(RPGCharacter character, int xp) {
        //messager.onXPIncrease(character, xp);
    }

    public void onUnsetTarget(RPGCharacter character) {
        //messager.onUnsetTarget(character);
    }

    public void onUnequip(RPGCharacter user, Item equip) {
        messager.onUnequip(user, equip);
    }

    public void onStrengthIncrease(RPGCharacter character, int strength) {
        //messager.onStrengthIncrease(character, strength);
    }

    public void onStop(RPGCharacter character) {
        messager.onStop(character);
    }

    public void onSkillPointIncrease(RPGCharacter character, int skillPoints) {
        //messager.onSkillPointIncrease(character, skillPoints);
    }

    public void onSetTarget(RPGCharacter character, RPGCharacter target) {
        //messager.onSetTarget(character, target);
    }

    public void onSetHome(RPGCharacter character, Locality locality) {
        messager.onSetHome(character, locality);
    }

    public void onRevive(RPGCharacter character) {
        //messager.onRevive(character);
    }

    public void onReach(RPGCharacter character, Locality locality) {
        messager.onReach(character, locality);
    }

    public void onMsg(RPGCharacter character, String msg) {
        //messager.onMsg(character, msg);
    }

    public void onMove(RPGCharacter character, Locality locality) {
        messager.onMove(character, locality);
    }

    public void onLevelUp(RPGCharacter character) {
        messager.onLevelUp(character);
    }

    public void onKill(RPGCharacter character) {
        messager.onKill(character);
    }

    public void onHeal(RPGCharacter character, int healing) {
        messager.onHeal(character, healing);
    }

    public void onGiveItem(RPGCharacter character, RPGCharacter target, Class<? extends Item> itemClass, int amount) {
        messager.onGiveItem(character, target, itemClass, amount);
    }

    public void onGiveGold(RPGCharacter character, RPGCharacter target, long amount) {
        messager.onGiveGold(character, target, amount);
    }

    public void onEquip(RPGCharacter user, Item equip) {
        messager.onEquip(user, equip);
    }

    public void onAttack(RPGCharacter attacker, RPGCharacter target, Destructive weapon, int damage, int dealtDamage) {
        messager.onAttack(attacker, target, weapon, damage, dealtDamage);
    }

    public void onManaIncrease(RPGCharacter character, int mana) {
        //messager.onManaIncrease(character, mana);
    }

    

    public void onAllMsg(RPGCharacter character, String msg) {
        messager.onAllMsg(character, msg);
    }

    public void onAttackFinished(RPGCharacter character) {
        
    }

    public void onUsageFinished(RPGCharacter character) {
        
    }

    public void onMaxHealthIncrease(RPGCharacter character, int maxHealth) {
        
    }

    public void onMaxManaIncrease(RPGCharacter character, int maxMana) {

    }




}
