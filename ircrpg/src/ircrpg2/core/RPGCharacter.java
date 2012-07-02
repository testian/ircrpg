/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;

import java.util.Set;
//import ircrpg2.messaging.MessageTarget;
/**
 *
 * @author testi
 */
public interface RPGCharacter extends Named {
    /**
     * increases the strength of the character by strength
     * @param strength
     */
    public void increaseStrength(int strength);
    /**
     * 
     * @return strength of the character
     */
    public int getStrength();
    /**
     * increases the health of the character by health
     * @param health
     */
    public void increaseHealth(int health);
    public void hold();
    public void commit();
    /**
     * 
     * @return health of the character
     */
    public int getHealth();
    /**
     * increases the maximum health of the character by maxHealth
     * @param maxHealth
     */
    public void increaseMaxHealth(int maxHealth);
    /**
     * 
     * @return the maximum health of the character
     */
    public int getMaxHealth();
    /**
     * 
     * @return the current level of the character
     */
    public int getLevel();
    /**
     * increases the experience of the character by xp
     * @param xp
     */
    public void increaseXP(int xp);
    /**
     * sets the state of the character (DEAD, ALIVE)
     * @param state
     */
    public void setState(CharacterState state);
    /**
     * 
     * @return the state of the character (DEAD, ALIVE)
     */
    public CharacterState getState();
    /**
     * sets the characters home, the home is the place where the characters is respawned after dying
     * @param home
     */
    public void setHome(Locality home);
    /**
     * 
     * @return the home locality
     */
    public Locality getHome();
    /**
     * increases the characters skill points by skillPoints, which can be used to learn several things.
     * @param skillPoints
     */
    public void increaseSkillPoints(int skillPoints);
    public void revive();
    public void kill();
    public void revive(int health);
    /**
     * decreases the characters skill points by skillPoints
     * @param skillPoints
     * @throws RPGException in case the character doesn't have minimum skillPoints left
     */
    public void decreaseSkillPoints(int skillPoints) throws RPGException;
    /**
     * 
     * @return The amount of skill points the character has
     */
    public int getSkillPoints();
    /**
     * 
     * @return experience points of the character
     */
    public long getXP();
    /**
     * 
     * @return the inventory of the character
     */
    public Inventory getInventory();
    /**
     * 
     * @return the set of skills that the character learned so far.
     */
    public Set<Skill> getSkills();
    /**
     * 
     * @param skill
     * @return true if the character learned skill skill, false otherwise
     */
    public boolean hasSkill(Class<? extends Skill> skill);
    /**
     * 
     * @param skill
     * @return the skill-instance matching the class skill, null if the character hasn't learnt the skill yet
     */
    public Skill getSkill(Class<? extends Skill> skill);
    /**
     * lets the character learn the skill skill
     * @param skill
     */
    public void learnSkill(Skill skill);
    /**
     *
     * @return the amount of XP required in order to achieve the next level
     */
    public long getNextLevel();

    /**
     * lets the character move to locality location
     * @param location
     * @throws RPGException in case the user can't move there for some reason or is already there
     */
    public void move(Locality location) throws RPGException;
    /**
     * lets the character seek things at the current location
     * @throws RPGException if the character can't currently do that
     */
    public void harvest() throws RPGException;
    /**
     * lets the character seek items that are instances of itemClass
     * @param itemClass the item class to seek for
     * @throws RPGException
     */
    public void harvest(Class<? extends Item> itemClass) throws RPGException;
    /**
     * Lets the character stop at the current position, if moving
     */
    public void stop();
    /**
     * 
     * @return the characters current position
     */
    public Position getPosition();
    /**
     * lets the character choose a weapon of it's inventory for combat
     * @param weapon
     * @throws RPGException if the user can't currently do so
     */
    public void equipWeapon(Weapon weapon) throws RPGException;
    /**
     * lets the character unequip a weapon
     * @param weapon
     * @throws RPGException 
     */
    public void unequipWeapon(Weapon weapon) throws RPGException;

    /**
     * lets the character equip an armor
     * @param armor
     * @throws RPGException
     */
    public void equipArmor(Armor armor) throws RPGException;
    /**
     * lets the character unequip an armor
     * @param armor
     * @throws RPGException
     */
    public void unequipArmor(Armor armor) throws RPGException;
        /**
     * lets the character choose a target for interaction (combat, dealing etc)
     * @param character
     * @throws RPGException upon invalid selection (such as selecting this)
     */
    public void setTarget(RPGCharacter character) throws RPGException;
    /**
     * resets target selection
     */
    public void unsetTarget();
    /**
     * invokes attack using the selected weapons against the character specified with setTarget()
     * @throws RPGException
     */
    public void attack() throws RPGException;
    /**
     * Lets the character start blocking, using the currently selected weapons
     * @throws RPGException
     */
    public void block() throws RPGException;
    /**
     * tries to harm character by damage
     * @param damage
     * @return the damage that effectively happened after block and armor
     */
    public int damage(int damage);
    /**
     *
     * @throws RPGException if the user is not alive
     */
    public void checkAlive() throws RPGException;

    //public void setPublicMessageTarget(MessageTarget all);
    //public void setPrivateMessageTarget(MessageTarget player);
    /**
     * adds the listener listener to listen to character events
     * @param listener
     */
    public void addCharacterEventListener(CharacterEventListener listener);
    /**
     * removes listener listener
     * @param listener
     */
    public void removeCharacterEventListener(CharacterEventListener listener);
    /**
     * sends a message to this character
     * @param message
     */
    public void msg(String message);
    /**
     * sends a message related to this character to everyone
     * @param message
     */
    public void allMsg(String message);
    /**
     * 
     * @return true if the character is currently moving, false otherwise
     */
    public boolean isMoving();
    /**
     * 
     * @return the primary weapon
     */
    public Weapon getCurrentWeapon();
    /**
     * 
     * @return the secondary weapon
     */
    public Weapon getSecondCurrentWeapon();
    /**
     * gives item item to getTarget()
     * @param item
     * @throws RPGException if the user doesn't have the item, is currently not able to do so or similar.
     */
    public void giveItem(Item item) throws RPGException;
    public void giveItems(Class<? extends Item> items, int amount) throws RPGException;
    /**
     * gives amount gold to getTarget()
     * @param amount
     * @throws RPGException if the user doesn't have at least amount gold or is not able to do so or similar.
     */
    public void giveGold(long amount) throws RPGException;
    /**
     * 
     * @return true if the character is controlled by the CPU
     */
    public boolean isNPC();
    /**
     * 
     * @return the body
     */
    public Body getBody();
    /**
     * 
     * @return the target selected with setTarget() or null if no target selection has been made
     */
    public RPGCharacter getTarget();
    /**
     * Lets the character use useable
     * @param useable the object to be used
     * @throws RPGException if the character can't do so currently
     */
    public void use(Usable useable) throws RPGException;
    /**
     * 
     * @return the world this character is placed in
     */
    public World getWorld();
    /**
     * lets the character simulate an attack on target
     * @param target
     * @return the damage that would happen on target under the current circumstances
     * @throws RPGException if some conditions don't apply in order to attack
     */
    public int simulatedDamage(RPGCharacter target) throws RPGException;
    /**
     * same as damage, but without actually causing damage
     * @param damage
     * @return
     */
    public int simulatedDamage(int damage);
    /**
     *
     * @param target
     * @return true if simulatedDamage(target) > 0, false otherwise
     */
    public boolean attackable(RPGCharacter target);

    /**
     * 
     * @return the amount of mana the character has
     */
    public int getMana();
    /**
     * increases the characters mana by mana
     * @param mana
     */
    public void increaseMana(int mana);
    /**
     * decreases the mana of the character by mana
     * @param mana
     * @throws RPGException if the character doesn't have at least mana mana
     */
    public void useMana(int mana) throws RPGException;
    /**
     * sets the characters mana to 0
     * @return the amount of mana that the character had remaining
     */
    public int useRemainingMana();
    /**
     * increases the maximum mana the character can have
     * @param maxMana
     */
    public void increaseMaxMana(int maxMana);
    /**
     * 
     * @return the maximum mana of the character
     */
    public int getMaxMana();


    /**
     * attack without conditions, not to be used by players. Externally to be used by non weapon destructives such as spells.
     * @param target
     * @param weapon
     * @param damage
     */
    public void attack(RPGCharacter target, Destructive weapon, int damage);

    /**
     * Lets the user reach locality
     * @param locality
     */
    public void reach(Locality locality);

}
