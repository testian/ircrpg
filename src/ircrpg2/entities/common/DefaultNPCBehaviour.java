/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.common;

import ircrpg2.ai.TargetStack;
import ircrpg2.core.AssistBehaviour;
import ircrpg2.core.AttackBehaviour;
import ircrpg2.core.CharacterState;
import ircrpg2.core.Destructive;
import ircrpg2.core.Item;
import ircrpg2.core.Locality;
import ircrpg2.core.NPC;
import ircrpg2.core.NPCBehaviour;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.RPGException;
import ircrpg2.entities.common.npc.ai.FindAndKill;
import ircrpg2.entities.common.npc.ai.MoveHome;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author testi
 */
public class DefaultNPCBehaviour extends NPCBehaviour {

        private Set<RPGCharacter> tempEnemy;
        private TargetStack targetStack;
        private AttackBehaviour attackBehaviour;
        private AssistBehaviour assistBehaviour;
        public DefaultNPCBehaviour() {
        tempEnemy = new HashSet<RPGCharacter>();
        targetStack = new TargetStack();
        attackBehaviour = new DefaultAttackBehaviour();
        assistBehaviour = new AssistBehaviour() {

            public boolean assist(RPGCharacter subject, RPGCharacter target) {
                return false;
            }

        };
        }
        public TargetStack targetStack() {
        return targetStack;
        }

    @Override
    public void setNpc(NPC npc) {
        super.setNpc(npc);
        targetStack.setRootTarget(new MoveHome(npc));
    }


    protected void seekTarget() {
            HashSet<RPGCharacter> enemies = new HashSet<RPGCharacter>();
            enemies.addAll(getNpc().getWorld().getLibrary().getPlayers());
            enemies.addAll(getNpc().getWorld().getLibrary().getNPCs());
            for (RPGCharacter c : enemies) {

                if (!isCurrentlyFriendly(c) && c.getPosition().getLocation() == getNpc().getPosition().getLocation() && getNpc().attackable(c)) {
                targetStack.addTarget(new FindAndKill(getNpc(),c,this.getAttackBehaviour()));
                }

            }
        }




        protected void addTemporaryEnemy(RPGCharacter character) {
        if (getNpc().isFriendly(character)) {
        tempEnemy.add(character);
        }
        }

        




        protected void removeTemporaryEnemy(RPGCharacter character) {
        tempEnemy.remove(character);
        }
        protected boolean isCurrentlyFriendly(RPGCharacter character) {
        return (character == getNpc() || (!tempEnemy.contains(character) && getNpc().isFriendly(character)));
        }

    @Override
    public AttackBehaviour getAttackBehaviour() {
        return attackBehaviour;
    }

    @Override
    public void setAttackBehaviour(AttackBehaviour attackBehaviour) {
        this.attackBehaviour = attackBehaviour;
    }

    @Override
    public AssistBehaviour getAssistBehaviour() {
        return assistBehaviour;
    }

    @Override
    public void setAssistBehaviour(AssistBehaviour assistBehaviour) {
        this.assistBehaviour = assistBehaviour;
    }





        /*protected void moveHome() {
        moveHome = true;
        Location loc = getPosition().getLocation();

        if (loc == getHome()) {path.clear();moveHome = false;return;}
        if (path.isEmpty()) {
            try{move(getHome());}catch(RPGException ex){}
        }
        while (!path.isEmpty()) {
        try {
        move(path.removeLast());
        } catch (RPGException ex) {
        continue;
        }
        break;
        }
        }*/

        protected void friendAttackingMe(RPGCharacter attacker, RPGCharacter target, Destructive weapon, int damage, int dealtDamage) {
            addTemporaryEnemy(attacker);
            targetStack.addTarget(new FindAndKill(getNpc(),attacker,this.getAttackBehaviour()));
            targetStack.proceed();
        }

        protected void enemyAttackingMe(RPGCharacter attacker, RPGCharacter target, Destructive weapon, int damage, int dealtDamage) {
        targetStack.addTarget(new FindAndKill(getNpc(),attacker,this.getAttackBehaviour()));
        targetStack.proceed();
        }

        protected void enemyAttackingFriendLocal(RPGCharacter attacker, RPGCharacter target, Destructive weapon, int damage, int dealtDamage) {
        targetStack.addTarget(new FindAndKill(getNpc(),attacker,this.getAttackBehaviour()));
        targetStack.proceed();
        }
        protected void enemyAttackingFriendRemote(RPGCharacter attacker, RPGCharacter target, Destructive weapon, int damage, int dealtDamage) {
        //targetStack.addTarget(new FindAndKill(getNpc(),attacker)); //Only for test purposes..
        }

        private boolean friendlyAttackJustified(RPGCharacter attacker, RPGCharacter target) {
        int result = getNpc().compareFriends(attacker, target);
             return(result<0);
        }
        protected void friendAttackingFriendLocal(RPGCharacter attacker, RPGCharacter target, Destructive weapon, int damage, int dealtDamage) {
            if (friendlyAttackJustified(attacker, target))
            addTemporaryEnemy(target);
            else
            addTemporaryEnemy(attacker);
            targetStack.addTarget(new FindAndKill(getNpc(),attacker,this.getAttackBehaviour()));
        }

        protected void friendAttackingFriendRemote(RPGCharacter attacker, RPGCharacter target, Destructive weapon, int damage, int dealtDamage) {
            if (friendlyAttackJustified(attacker, target))
            addTemporaryEnemy(target);
            else
            addTemporaryEnemy(attacker);
           //targetStack.addTarget(new FindAndKill(getNpc(),attacker)); //Only for test purposes
        }

        protected void friendAttackingEnemyLocal(RPGCharacter attacker, RPGCharacter target, Destructive weapon, int damage, int dealtDamage) {
           //addTemporaryEnemy(attacker);
           //targetStack.addTarget(new FindAndKill(getNpc(),target)); //Only for test purposes
           //targetStack.proceed();
        }

        protected void friendAttackingEnemyRemote(RPGCharacter attacker, RPGCharacter target, Destructive weapon, int damage, int dealtDamage) {
        }
        protected void meAttacking(RPGCharacter attacker, RPGCharacter target, Destructive weapon, int damage, int dealtDamage) {
        
        //A bonus in percentage is calculated for the NPC refresh
        //This bonus is 100 at max and is equal to the damage done in relation to the own maximum health
        int refresh = 100;
        if (getNpc().getMaxHealth() > 0) {
        refresh = (dealtDamage*100)/getNpc().getMaxHealth();
        if (refresh > 100) refresh = 100;
        }
        
        getNpc().refresh(refresh);

        /*if (damage<=target.getBody().getBlock()) {
                //unset(target);
            }*/
        }




        public void onAllMsg(RPGCharacter character, String msg) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

    public void onMaxHealthIncrease(RPGCharacter character, int maxHealth) {
        
    }

    public void onMaxManaIncrease(RPGCharacter character, int maxMana) {

    }



        public void onAttack(RPGCharacter attacker, RPGCharacter target, Destructive weapon, int damage, int dealtDamage) {
        if (getNpc().getState() == CharacterState.DEAD) return;
            if (getNpc() == attacker) {
            meAttacking(attacker,target,weapon,damage,dealtDamage);
            return;
            }
            boolean near = false;
            try {
            int sdamage = getNpc().simulatedDamage(attacker);
            near = sdamage > 0 || target.getPosition().getLocation() == getNpc().getPosition().getLocation();

            } catch (RPGException ex){}

            if (target == getNpc() && isCurrentlyFriendly(attacker))
            friendAttackingMe(attacker, target, weapon, damage, dealtDamage);

            if (target == getNpc() && !isCurrentlyFriendly(attacker))
            enemyAttackingMe(attacker, target, weapon, damage, dealtDamage);

            else if (isCurrentlyFriendly(target) && isCurrentlyFriendly(attacker) && near)
            friendAttackingFriendLocal(attacker, target, weapon, damage, dealtDamage);

            else if (isCurrentlyFriendly(target) && isCurrentlyFriendly(attacker) && !near)
            friendAttackingFriendRemote(attacker, target, weapon, damage, dealtDamage);

            else if (isCurrentlyFriendly(target) && !isCurrentlyFriendly(attacker) && near)
            enemyAttackingFriendLocal(attacker, target, weapon, damage, dealtDamage);

            else if (isCurrentlyFriendly(target) && !isCurrentlyFriendly(attacker) && !near)
            enemyAttackingFriendRemote(attacker, target, weapon, damage, dealtDamage);

            else if (!isCurrentlyFriendly(target) && isCurrentlyFriendly(attacker) && near)
            friendAttackingEnemyLocal(attacker, target, weapon, damage, dealtDamage);

            else if (!isCurrentlyFriendly(target) && isCurrentlyFriendly(attacker) && !near)
            friendAttackingEnemyRemote(attacker, target, weapon, damage, dealtDamage);

        }

        public void onEquip(RPGCharacter user, Item equip) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void onGiveGold(RPGCharacter character, RPGCharacter target, long amount) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void onGiveItem(RPGCharacter character, RPGCharacter target, Class<? extends Item> itemClass, int amount) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void onHeal(RPGCharacter character, int healing) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void onManaIncrease(RPGCharacter character, int mana) {

        }

        public void onKill(final RPGCharacter character) {


        removeTemporaryEnemy(character);

        if (character == getNpc()) {
        targetStack.reset();
        tempEnemy.clear();
        return;
        }
        if (targetStack.related(character)) {
        targetStack.proceed();
        }

        /*if (character == getTarget()) {
        unset(character);
        seekTarget();
        moveHome();
        }*/

        }

        public void onLevelUp(RPGCharacter character) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void onMove(RPGCharacter character, Locality locality) {

            if (targetStack.related(character)) {
            targetStack.proceed();
            }
            

            /*if (character == getNpc().getTarget()) {
                try {
                    //getNpc().hold();
                    move(locality);
                } catch (RPGException ex) {
                error(ex);
                } finally {
                //getNpc().commit();
                }
            }*/
        }

        public void onMsg(RPGCharacter character, String msg) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void onReach(RPGCharacter character, Locality locality) {
            if (getNpc().getState() == CharacterState.DEAD) return;
            if (!isCurrentlyFriendly(character) && locality == getNpc().getPosition().getLocation()) {
            targetStack.addTarget(new FindAndKill(getNpc(),character,this.getAttackBehaviour()));
            }
            if (targetStack.related(character)) {
            targetStack.proceed();
            }
            if (character == getNpc() && targetStack.fullySatisfied()) {
            seekTarget();
            }

            /*
            //System.err.println("onReach: " + character.getName() + " " + locality.getName());
            if (getTarget() == null) {
                //System.err.println("Debug 1");
                checkAttack(character);
                //System.err.println("Debug 2");
            } else {
                //System.err.println("DebugElse 1");
                checkAttack(getTarget());
                //System.err.println("DebugElse 2");
            }
            if (character != getNpc()) {return;}
            //if (character != getNpc()) {return;}
            seekTarget();
            //if (character != getNpc()) {return;}
            if (moveHome) {
            //if (character != getNpc()) {return;}
                moveHome();
                //if (character != getNpc()) {return;}
            } else {
            path.addLast(locality);
            }*/
            }



        public void onRevive(RPGCharacter character) {
            if (getNpc().getState() == CharacterState.DEAD) return;
            if (character == getNpc()) {
                getNpc().refresh();
                seekTarget();
            }

            if (!isCurrentlyFriendly(character) && character.getPosition().getLocation() == getNpc().getPosition().getLocation()) {
            targetStack.addTarget(new FindAndKill(getNpc(),character,this.getAttackBehaviour()));
            }


            if (targetStack.related(character)) {
            targetStack.proceed();
            }
            //removeTemporaryEnemy(character);

            /*if (getTarget() == null){checkAttack(character);}
            else {checkAttack(getTarget());return;}
            //moveHome();
            if (character == getNpc()) {
                seekTarget();
            }*/

        }

        public void onSetHome(RPGCharacter character, Locality locality) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void onSetTarget(RPGCharacter character, RPGCharacter target) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void onSkillPointIncrease(RPGCharacter character, int skillPoints) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void onStop(RPGCharacter character) {
            if (getNpc().getState() == CharacterState.DEAD) return;

            if (targetStack.related(character)) {
            targetStack.proceed();
            }
            /*if (character == getNpc().getTarget()) {
            if (nearEnough(character)) {
            stop();
            }
            }*/
        }

        public void onStrengthIncrease(RPGCharacter character, int strength) {
        }

        public void onUnequip(RPGCharacter user, Item equip) {

        }

        public void onUnsetTarget(RPGCharacter character) {

        }

        public void onXPIncrease(RPGCharacter character, int xp) {

        }

        public void onAttackFinished(RPGCharacter character) {
            //synchronized (getNpc().getWorld()) {
            //checkAttack(getTarget());
            //}
            if (character == getNpc())
            targetStack.proceed();
        }

    public void onUsageFinished(RPGCharacter character) {
        if (character == getNpc())
        targetStack.proceed();
    }

}
