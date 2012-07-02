/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.common;

import ircrpg2.core.*;
import java.util.*;

/**
 *
 * @author testi
 */
public class CharacterCommon implements RPGCharacter {

    private int health;
    private int maxHealth;
    private int strength;
    private Locality home;
    private RPGCharacter combatCharacter;
    private Weapon currentWeapon;
    private String name;
    private long xp;
    private int level;
    private int skillPoints;
    private CharacterState state;
    private CharacterInventory inventory;
    private Set<Skill> skills;
    private Position lastRecordedPosition;
    private MoveAction moveAction;
    private boolean attackPending;
    private boolean blockPending;
    private Weapon secondCurrentWeapon;
    private CharacterEventMulticaster listener;
    private Body body;
    protected final World world;
    private boolean usagePending;
    private int mana;
    private int maxMana;
    private Timer reviveTimer;

    public CharacterCommon(World world, int health, int maxHealth, int strength, Locality home, Weapon currentWeapon, Weapon secondCurrentWeapon, String name, long xp, int level, int skillPoints, CharacterState state, Set<Skill> skills, Position position, int mana, int maxMana) {
        this.world = world;
        this.health = health;
        this.maxHealth = maxHealth;
        this.strength = strength;
        this.home = home;
        this.combatCharacter = null;
        this.currentWeapon = currentWeapon;
        this.secondCurrentWeapon = secondCurrentWeapon;
        this.mana = mana;
        this.maxMana = maxMana;
        this.name = name;
        this.xp = xp;
        this.level = level;
        this.skillPoints = skillPoints;
        this.state = state;
        this.skills = skills;
        this.attackPending = false;
        this.blockPending = false;
        usagePending = false;
        moveAction = null;
        inventory = new CharacterInventory(this);
        try {
            if (currentWeapon != null)
            inventory.addItem(currentWeapon);}
        catch (RPGException ex) {this.currentWeapon = null;}
        try {
            if (secondCurrentWeapon != null)
            inventory.addItem(secondCurrentWeapon);}
        catch (RPGException ex) {this.secondCurrentWeapon = null;}
        if (this.currentWeapon == null) {this.currentWeapon = secondCurrentWeapon;this.secondCurrentWeapon = null;}
        this.lastRecordedPosition = position;


        listener = new CharacterEventMulticaster();
        body = new CharacterBody();
        reviveTimer = null;
        //Aspect Messaging:
        /*all = new MessageTarget() {

            public void msg(String message) {
             System.out.println("Public message: " + message);
            }

        };
        player = new MessageTarget() {

            public void msg(String message) {
                System.out.println("Message for "+ getName() + ": " + message);
            }

        };*/
    }
    public World getWorld() {
    return world;
    }
    public Body getBody() {
        return body;
    }
    /*public void hold(){
    listener.hold();
    }
    public void commit(){
    listener.commit();
    }*/

    public void addCharacterEventListener(CharacterEventListener listener) {
        this.listener.addCharacterEventListener(listener);
    }

    public void removeCharacterEventListener(CharacterEventListener listener) {
        this.listener.removeCharacterEventListener(listener);
    }



    public int simulatedDamage(RPGCharacter target) throws RPGException {
    Weapon w = new WeaponFusion(getCurrentWeapon(),getSecondCurrentWeapon());
    return target.simulatedDamage(w.calculateDamage(this, target));
    }

    public int simulatedDamage(int damage) {
    return damage(damage,true);
    }

    public boolean attackable(RPGCharacter target) {
    Weapon w = new WeaponFusion(getCurrentWeapon(),getSecondCurrentWeapon());
    try {
    return (w.calculateDamage(this, target) > 0); } catch (RPGException ex) {return false;}
    }

    /*public void setPublicMessageTarget(MessageTarget all) {
    this.all = all;
    }
    public void setPrivateMessageTarget(MessageTarget player) {
    this.player = player;
    }*/
    

    synchronized public void attack() throws RPGException {
        checkAlive();
        checkReady();

        //hold();
        
        if (combatCharacter == null) {
        throw new RPGException(RPGException.Type.NO_TARGET);
        }

                if (combatCharacter.getState() == CharacterState.DEAD) {
        throw new RPGException(RPGException.Type.TARGET_DEAD);
        }

         
        
        
        Weapon weapon;
        if (currentWeapon == null) {
        weapon = new Fists();
        }
        else {
        weapon = new WeaponFusion(currentWeapon, secondCurrentWeapon);
        }

        int damage = weapon.calculateDamage(this, combatCharacter);


            attack(combatCharacter,weapon,damage);



            attackPending = true;

            new Timer().schedule(Util.tott(world.entailTask(new Runnable() {

            @Override
            public void run() {
                
                attackPending = false;
                blockPending = false;
                listener.onAttackFinished(CharacterCommon.this);
                
            }

        })), (long)(weapon.getSpeed()*1000));


        
        

        
    }
    synchronized public void attack(RPGCharacter target, Destructive weapon, int damage) {


        if (target.getState() == CharacterState.DEAD) return;



        target.hold();
        int realDamage = target.damage(damage);
        listener.onAttack(this, target, weapon, damage, realDamage);
        target.commit();
        if (target == this) return;
        int newXp = realDamage/2;
        if (target.getState() == CharacterState.DEAD) {
        newXp+=(target.getMaxHealth()/2);
        }
        

        this.increaseXP(newXp);
    }

    public void commit() {
        listener.commit();
    }

    public void hold() {
        listener.hold();
    }



    synchronized public void block() throws RPGException {
        checkAlive();
        checkReady();
        blockPending = true;
        Weapon weapon;
        if (currentWeapon == null) {
        weapon = new Fists();
        } else {
        weapon = new WeaponFusion(currentWeapon, secondCurrentWeapon);
        }

                new Timer().schedule(Util.tott(world.entailTask(new Runnable() {

            @Override
            public void run() {
                synchronized(world) {
                attackPending = false;
                blockPending = false;

                listener.onAttackFinished(CharacterCommon.this);
                }
            }

        })), (long)(weapon.getSpeed()*1000));

    }

    private void checkReady() throws RPGException {
        if (attackPending || blockPending) {
        throw new RPGException(RPGException.Type.ATTACK_PENDING);
        }
        if (usagePending) {
        throw new RPGException(RPGException.Type.USAGE_PENDING);
        }
    }

    synchronized public void use(Usable usable) throws RPGException {
    checkAlive();
    checkReady();
    usable.use(this);
    usagePending = true;
                    new Timer().schedule(Util.tott(world.entailTask(new Runnable() {

            @Override
            public void run() {
            usagePending = false;
            listener.onUsageFinished(CharacterCommon.this);
            }

        })), 1000);

    }
    public void checkAlive() throws RPGException {
        if (state != state.ALIVE) {throw new RPGException(RPGException.Type.CHARACTER_DEAD);}
    }
    private void checkOnSelf(RPGCharacter test) throws RPGException {
    if (this == test) {
    throw new RPGException(RPGException.Type.ILLEGAL_SELF_ACTION);
    }
    }
    public void equipWeapon(Weapon weapon) throws RPGException {
        if (currentWeapon == null) {
        currentWeapon = weapon;
        }
        else if (currentWeapon != weapon) {
        secondCurrentWeapon = weapon;
        } else {
        throw new RPGException(RPGException.Type.ALREADY_EQUIPPED);
        }
        listener.onEquip(this, weapon);
    }

    public void equipArmor(Armor armor) throws RPGException {
        if (!armor.equip(this)) throw new RPGException(RPGException.Type.ALREADY_EQUIPPED);
        listener.onEquip(this, armor);
    }

    public void unequipArmor(Armor armor) throws RPGException {
        if (!armor.unEquip(this)) throw new RPGException(RPGException.Type.NOT_EQUIPPED);
        listener.onUnequip(this, armor);
    }



    public int getHealth() {
        return health;
    }

    public Locality getHome() {
        return home;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getLevel() {
        return level;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public String getName() {
        return name;
    }

    synchronized public Position getPosition() {
        if (moveAction == null) {
    return lastRecordedPosition;
    }
    long moveDuration = System.currentTimeMillis() - moveAction.start;
    return new Position(moveAction.on,moveAction.from,moveAction.to,moveAction.progress + moveDuration/(moveAction.on.getLength()*1000.0));
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public CharacterState getState() {
        return state;
    }

    public int getStrength() {
        return strength;
    }

    public long getXP() {
        return xp;
    }

    public void increaseHealth(int health) {
        this.health+=health;
        if (this.health>maxHealth){this.health=maxHealth;}
        listener.onHeal(this, health);
    }

    public int getMana() {
        return mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void increaseMana(int mana) {
        this.mana+=mana;
        if (this.mana>maxMana){this.mana=maxMana;}
        listener.onManaIncrease(this, mana);
    }

    public void increaseMaxMana(int maxMana) {
        this.maxMana+=maxMana;
        listener.onMaxManaIncrease(this, maxMana);
    }

    public void useMana(int mana) throws RPGException {
        if (mana<0) throw new IllegalArgumentException("mana must be >= 0");
        if (mana>this.mana) throw new RPGException(RPGException.Type.NOT_ENOUGH_MANA);
        this.mana-=mana;
        return;
    }

    public int useRemainingMana() {
        int remaining = mana;
        mana = 0;
        return remaining;
    }





    public void increaseMaxHealth(int maxHealth) {
        this.maxHealth+=maxHealth;
        listener.onMaxHealthIncrease(this, maxHealth);
    }

    public void increaseSkillPoints(int skillPoints) {
        this.skillPoints+=skillPoints;
        listener.onSkillPointIncrease(this, skillPoints);
    }

    public void decreaseSkillPoints(int skillPoints) throws RPGException {
        if (skillPoints>this.skillPoints) {throw new RPGException(RPGException.Type.NOT_ENOUGH_SKILLPOINTS);}
        this.skillPoints-=skillPoints;
    }

    public void increaseStrength(int strength) {
        this.strength+=strength;
        listener.onStrengthIncrease(this, strength);
    }

    public void increaseXP(int xp) {
        this.xp+=xp;
        if (this.xp>getNextLevel()){
            levelUp();
        }

        listener.onXPIncrease(this, xp);
    }
    private void levelUp() {
    level++;
    listener.onLevelUp(this);
    this.increaseSkillPoints(10);
    this.increaseMaxHealth(10);
    
    }
    synchronized public void move(Locality location) throws RPGException {
        checkAlive();
        Position currentPosition = getPosition();
        if (currentPosition.isOnPath()) {
        if (isMoving() && currentPosition.getDestination() == location) throw new RPGException(RPGException.Type.ALREADY_DOING);
        Path path = (Path)currentPosition.getLocation();

        if (path.getLocalities().contains(location)) {
        double progress;
        Locality from, to;
        if (currentPosition.getDestination() != location) {
        progress = 1 - currentPosition.getProgress();
        from = currentPosition.getDestination();
        to = currentPosition.getStart();
        }
        else {
        progress = currentPosition.getProgress();
        from = currentPosition.getStart();
        to = currentPosition.getDestination();
        }
            
        /*Locality[] fromto = (Locality[])path.getConnections().toArray();
        if (fromto[0] == location) {
        fromto[0] = fromto[1];
        fromto[1] = location;
        }*/
        MoveAction m = new MoveAction(from, to,path,progress);

        silentStop();
        m.start();
        moveAction = m;
        moveMsg(to);

        return;
        }
        } else {
        Locality locality = (Locality)currentPosition.getLocation();
        if (location == locality) {throw new RPGException(RPGException.Type.ALREADY_THERE);}
        for (Path p : locality.getPaths()) {
        for (final Locality l : p.getLocalities()) {
        if (l == location) {
            
            MoveAction m = new MoveAction(locality, l, p,0);

            silentStop();
            m.start();
            moveAction = m;
            moveMsg(l);
            return;
        }
        }
        }

        }
        throw new RPGException(RPGException.Type.NOT_REACHABLE);
    }
    private void moveMsg(Locality l) {
    listener.onMove(this, l);
    }
    synchronized public void setTarget(RPGCharacter character) throws RPGException {
        checkOnSelf(character);
        if (character == combatCharacter) return; //Only emit changes!
        this.combatCharacter=character;
        listener.onSetTarget(this, character);
    }
    synchronized public void reach(Locality locality)
    {
    if (moveAction != null) moveAction.timer.cancel();
    moveAction = null;
    if (lastRecordedPosition.getLocation() != locality) {
    lastRecordedPosition = new Position(locality);
    listener.onReach(this, locality);
    }
    }

    public void setHome(Locality home) {
        this.home = home;
        listener.onSetHome(this, home);
    }

    public void setState(CharacterState state) {
        this.state = state;
    }

    synchronized public void stop() {
        if (silentStop()) {
        listener.onStop(this);
        }
    }

    synchronized private boolean silentStop() {
        if (moveAction == null) {return false;}
        lastRecordedPosition = getPosition();
        moveAction.timer.cancel();
        moveAction = null;
        return true;
    }

    public void unequipWeapon(Weapon weapon) throws RPGException {
        if (this.currentWeapon == weapon) {
        this.currentWeapon = this.secondCurrentWeapon;
        this.secondCurrentWeapon = null;
        } else if (this.secondCurrentWeapon == weapon) {
        secondCurrentWeapon = null;
        } else {throw new RPGException(RPGException.Type.NOT_EQUIPPED);}
        listener.onUnequip(this, weapon);
    }

    synchronized public void unsetTarget() {
        this.combatCharacter = null;
        listener.onUnsetTarget(this);
    }

    public int damage(int damage) {
    return damage(damage,false);
    }
    private void armorDealDamage(int armorDealDamage) {
    body.dealDamage(armorDealDamage);
    }


    private int damage(int damage, boolean simulate) {
        int h = health;
        int blockDamage = blockDamage();
        int weaponBlock = blockDamage - body.getRealBlock();
        int armorDealDamage = Math.max(damage - weaponBlock, body.getRealBlock());
        if (!simulate) {armorDealDamage(armorDealDamage);}
        
        int blockedDamage = damage-blockDamage;
        if (blockedDamage < 0){blockedDamage=0;}
        h-=blockedDamage;
        int realDamage = blockedDamage;
        if (h<1) {
            
            realDamage+=h; h=0;
            if (!simulate) {health = h;if (blockedDamage>0) kill();return realDamage;}
        }

        if (!simulate) health = h;


        return realDamage;
    }




    private int blockDamage() {
    if (blockPending) {
        Weapon weapon = new WeaponFusion(getCurrentWeapon(),getSecondCurrentWeapon());
        //if (weapon == null) {weapon = new Fists();}
    return weapon.getDamageBlock()+body.getRealBlock();
    }
    return body.getRealBlock();
    }
    public void kill() {
    stop();
    //reach(home);
    state = CharacterState.DEAD;
    reviveTimer = new Timer();
    reviveTimer.schedule(Util.tott(world.entailTask(new Runnable() {

            @Override
            public void run() {
                //hold();
                reach(home);
                revive();
                
                //commit();
            }

    })), REVIVE_TIME*1000);
    listener.onKill(this);
    }
    final public static int REVIVE_TIME = 900;
    public void revive() {
    revive(maxHealth);
    }
    public void revive(int health) {
    reviveTimer.cancel();
    reviveTimer = null;
    if (state == CharacterState.ALIVE) return;
    if (health > maxHealth) health = maxHealth;
    else if (health < 0) health = 0;
    this.health = health;
    state = CharacterState.ALIVE;
    //reach(home);
    listener.onRevive(this);
    }
    public long getNextLevel() {
        return (getLevel()+1)*(getLevel()+1)*250;
    }


    private class MoveAction {
    Timer timer;
    long start;
    Locality from, to;
    Path on;
    double progress;
    public MoveAction(Locality from, Locality to, Path on, double progress) {
        this.from = from;
        this.to = to;
        this.on = on;
        this.progress = progress;
        start = 0;
    }

    public void start() {
            start = System.currentTimeMillis();
        timer = new Timer();
        timer.schedule(Util.tott(world.entailTask(new Runnable() {

                @Override
                public void run() {
                    synchronized(world) {
                    reach(to);
                    }
                    //commit();
                }

        })), (int)((1-progress)*on.getLength()*1000));
    }
    }
    public Weapon getCurrentWeapon() {
    return currentWeapon;
    }
    public Weapon getSecondCurrentWeapon() {
    return secondCurrentWeapon;
    }
    public void msg(String message) {
        //player.msg(message);
        listener.onMsg(this, message);
    }
    public void allMsg(String message) {
        //all.msg(message);
        listener.onAllMsg(this, message);
    }

    public boolean isMoving() {
    return (moveAction != null);
    }

    public void giveGold(long amount) throws RPGException {
        checkAlive();
        if (combatCharacter == null) {
        throw new RPGException(RPGException.Type.NO_TARGET);
        }
        if (getPosition().getDistance(combatCharacter.getPosition()) > 10.0) {
        throw new RPGException(RPGException.Type.OUT_OF_RANGE);
        }
        inventory.removeGold(amount);
        combatCharacter.getInventory().addGold(amount);
        listener.onGiveGold(this, combatCharacter, amount);
    }

    public void giveItem(Item item) throws RPGException {
    silentGiveItem(item);
    listener.onGiveItem(this, combatCharacter, item.getClass(), 1);
    }
    public void giveItems(Class<? extends Item> itemClass, int amount) throws RPGException {
        if (combatCharacter == null) throw new RPGException(RPGException.Type.NO_TARGET);
        
        int a = 0;
        try {
        for (Item i : this.getInventory().getItems()) {
        if (i.getClass() == itemClass && a < amount) {
            silentGiveItem(i);
            a++;
        }
        }
        } catch (RPGException ex) {
        if (a < 1) throw ex;
        }
        if (a>0)
        listener.onGiveItem(this, combatCharacter,itemClass, a);
    }
    private void silentGiveItem(Item item) throws RPGException {
        checkAlive();
        if (combatCharacter == null) {
        throw new RPGException(RPGException.Type.NO_TARGET);
        }
        if (getPosition().getDistance(combatCharacter.getPosition()) > 10.0) {
        throw new RPGException(RPGException.Type.OUT_OF_RANGE);
        }
        inventory.removeItem(item);
        try {
        combatCharacter.getInventory().addItem(item);
        } catch (RPGException ex) {
        inventory.addItem(item);
        throw ex;
        }
        
    }

    public boolean hasSkill(Class<? extends Skill> skill) {
    return getSkill(skill) != null;
    }

public Skill getSkill(Class<? extends Skill> skill) {

        for (Skill s : getSkills()) {
        if (s.getClass().equals(skill))
            return s;
        }
    return null;
    }

    public void learnSkill(Skill skill) {
        if (!hasSkill((Class<Skill>)(skill.getClass()))) {
        getSkills().add(skill);
        }
    }

    public void harvest(Class<? extends Item> itemClass) throws RPGException {
        checkAlive();
        if (getInventory().freeSlots()<1){
        throw new RPGException(RPGException.Type.INVENTORY_FULL);
        }
        Location current = getPosition().getLocation();
        if (current instanceof ResourceBase) {
        ResourceBase base = (ResourceBase)current;
        base.getResource().harvest(this, itemClass);
        } else {
        throw new RPGException(RPGException.Type.NO_RESOURCES);
        }
    }
    public void harvest() throws RPGException {
    harvest(null);
    }

    public RPGCharacter getTarget() {
        return combatCharacter;
    }



public boolean isNPC() {
return false; //Note that this is the default - NPC-classes should override this method, when inheriting from that class.
}


    private class Fists extends Weapon {

                @Override
                public int getMaxDamage() {
                    return getStrength();
                }

                @Override
                public int getMinDamage() {
                    return 0;
                }

                @Override
                public double getRange() {
                    return 1;
                }

                @Override
                public int getRequiredStrength() {
                    return 0;
                }

                @Override
                public double getSpeed() {
                    return 2;
                }

                public String getName() {
                    return "Fäuste";
                }


                public int getWeight() {
                    return 0;
                }

                @Override
                public int getDamageBlock() {
                    return 1;
                }


    }

}
