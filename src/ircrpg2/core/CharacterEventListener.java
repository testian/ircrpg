/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;

/**
 *
 * @author testi
 */
public interface CharacterEventListener {
public void onAttack(RPGCharacter attacker, RPGCharacter target, Destructive weapon, int damage, int dealtDamage);
public void onEquip(RPGCharacter user, Item equip);
public void onUnequip(RPGCharacter user, Item equip);
public void onHeal(RPGCharacter character, int healing);
public void onManaIncrease(RPGCharacter character, int mana);
public void onMaxManaIncrease(RPGCharacter character, int maxMana);
public void onMaxHealthIncrease(RPGCharacter character, int maxHealth);
public void onSkillPointIncrease(RPGCharacter character, int skillPoints);
public void onStrengthIncrease(RPGCharacter character, int strength);
public void onXPIncrease(RPGCharacter character, int xp);
public void onLevelUp(RPGCharacter character);
public void onMove(RPGCharacter character, Locality locality);
public void onSetTarget(RPGCharacter character, RPGCharacter target);
public void onUnsetTarget(RPGCharacter character);
public void onReach(RPGCharacter character, Locality locality);
public void onSetHome(RPGCharacter character, Locality locality);
public void onStop(RPGCharacter character);
public void onKill(RPGCharacter character);
public void onRevive(RPGCharacter character);
public void onGiveGold(RPGCharacter character, RPGCharacter target, long amount);
public void onGiveItem(RPGCharacter character, RPGCharacter target, Class<? extends Item> itemClass, int amount);
public void onAllMsg(RPGCharacter character, String msg);
public void onMsg(RPGCharacter character, String msg);
public void onAttackFinished(RPGCharacter character);
public void onUsageFinished(RPGCharacter character);
}
