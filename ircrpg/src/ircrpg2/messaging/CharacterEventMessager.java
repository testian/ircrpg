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
public class CharacterEventMessager implements CharacterEventListener {

    private MessageTarget player, all;

    public CharacterEventMessager(MessageTarget player, MessageTarget all) {
        this.player = player;
        this.all = all;
    }

    public void onAllMsg(RPGCharacter character, String msg) {
        all.msg(msg);
    }

    public void onAttack(RPGCharacter attacker, RPGCharacter target, Destructive weapon, int damage, int dealtDamage) {
        String targetName = (target != attacker ? target.getName() : "sich selbst");

        if (target.getState() == CharacterState.DEAD) {
        all.msg(attacker.getName() + " tötet " + targetName + " mit " + weapon.getName() + ". Schaden: " + dealtDamage);
        } else {
        all.msg(attacker.getName() + " greift " + targetName + " mit " + weapon.getName() + " an. Schaden: " + dealtDamage + (dealtDamage < damage ? ", Blockiert: " + (damage - dealtDamage) : "") + ", Gesundheit: " + target.getHealth() + "/" + target.getMaxHealth());
        }
    }

    public void onManaIncrease(RPGCharacter character, int mana) {
        
        if (character.getMana() == character.getMaxMana()) {
        all.msg(character.getName() + " hat volle Mana: " + character.getMana() + "/" + character.getMaxMana() + ".");
        } else {
        all.msg(character.getName() + " erhöht Mana um " + mana + " Punkte: " + character.getMana() + "/" + character.getMaxMana() + ".");
        }
    
    }



    public void onEquip(RPGCharacter user, Item equip) {
        all.msg(user.getName() + " legt " + equip.getName() + " an.");
    }

    public void onGiveGold(RPGCharacter character, RPGCharacter target, long amount) {
        all.msg(character.getName() + " gibt " + target.getName() + " " + amount + " Gold.");
    }

    public void onGiveItem(RPGCharacter character, RPGCharacter target, Class<? extends Item> itemClass, int amount) {
        all.msg(character.getName() + " gibt " + target.getName() + " " + amount + " " + ItemFactory.itemName(itemClass) + ".");
    }

    public void onHeal(RPGCharacter character, int healing) {
        if (character.getHealth() == character.getMaxHealth()) {
        all.msg(character.getName() + " ist vollständig geheilt: " + character.getHealth() + "/" + character.getMaxHealth() + ".");
        } else {
        all.msg(character.getName() + " wird um " + healing + " Punkte geheilt: " + character.getHealth() + "/" + character.getMaxHealth() + ".");
        }
    }

    public void onLevelUp(RPGCharacter character) {
            all.msg("Level Up " + character.getLevel() + ": " + character.getName());
    }

    public void onMove(RPGCharacter character, Locality locality) {
            all.msg(character.getName() + " macht sich auf den Weg nach " + locality.getName() + ".");
    }

    public void onMsg(RPGCharacter character, String msg) {
        player.msg(msg);
    }

    public void onReach(RPGCharacter character, Locality locality) {
            all.msg(character.getName() + " erreicht " + locality.getName() + ".");
    }

    public void onRevive(RPGCharacter character) {
            all.msg(character.getName() + " ist wieder am Leben.");
    }

    public void onSetHome(RPGCharacter character, Locality locality) {
                all.msg(locality.getName() + " ist von nun an " + character.getName() + "'s zuhause.");
    }

    public void onSetTarget(RPGCharacter character, RPGCharacter target) {
                player.msg("Ziel gesetzt auf: " + target.getName() +".");
    }

    public void onSkillPointIncrease(RPGCharacter character, int skillPoints) {
                all.msg("Du erhältst " + skillPoints + " Fähigkeitspunkte, " + character.getName() + ".");
    }

    public void onStop(RPGCharacter character) {
                all.msg(character.getName() + " bleibt an Ort und Stelle stehen.");
    }

    public void onStrengthIncrease(RPGCharacter character, int strength) {
        all.msg("Du wirst um " + strength + " Punkte stärker, " + character.getName() + ".");
    }
    public void onMaxManaIncrease(RPGCharacter character, int maxMana) {
        all.msg("Du erhöhst deine maximale Mana um " + maxMana + ", " + character.getName() + ".");
    }

    public void onMaxHealthIncrease(RPGCharacter character, int maxHealth) {
        all.msg(character.getName() + " erhält zusätzlich " + maxHealth + " maximale Lebensenergie.");
    }


    public void onUnequip(RPGCharacter user, Item equip) {
                all.msg(user.getName() + " legt " + equip.getName() + " ab.");
    }

    public void onUnsetTarget(RPGCharacter character) {
                player.msg("Ziel aufgehoben.");
    }

    public void onXPIncrease(RPGCharacter character, int xp) {

       all.msg(character.getName() + " erhält " + xp + " Erfahrungspunkte.");
    }

    public void onKill(RPGCharacter character) {
        all.msg(character.getName() + " stirbt.");
    }

    public void onAttackFinished(RPGCharacter character) {
    }
    public void onUsageFinished(RPGCharacter character) {
    }


}
