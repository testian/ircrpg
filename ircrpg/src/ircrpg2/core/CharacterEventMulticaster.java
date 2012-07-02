/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ircrpg2.core;

import java.util.*;

/**
 *
 * @author testi
 */
public class CharacterEventMulticaster implements CharacterEventListener {

    private ArrayList<CharacterEventListener> listeners;
    private LinkedList<CharacterEvent> events;
    boolean hold;
    boolean reverse;

    private interface CharacterEvent {

        public void forward();
    }

    public CharacterEventMulticaster() {
        listeners = new ArrayList<CharacterEventListener>();
        events = new LinkedList<CharacterEvent>();
        hold = false;
    }

    public void hold() {
        if (hold) throw new IllegalStateException("Already in a transaction: commit() must be called before calling hold() again");
        hold = true;
    }

    synchronized public void commit() {
        if (!hold) throw new IllegalStateException("Not in a transaction: hold() must be called prior to commit");
        hold = true;
        int size = events.size();
        for (int i = 0; i < size; i++)
        {
            events.removeFirst().forward();
        }
                

     if (!events.isEmpty()) commit();
        hold = false;
    }

    private void queue(CharacterEvent event) {
        if (hold) {
            events.addLast(event);
        } else {
            hold();
            event.forward();
            commit();
        }
    }

    public void addCharacterEventListener(CharacterEventListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    public void removeCharacterEventListener(CharacterEventListener listener) {
        listeners.remove(listener);
    }

    public void onAllMsg(final RPGCharacter character, final String msg) {
        CharacterEvent event = new CharacterEvent() {

            public void forward() {
                for (CharacterEventListener l : (List<CharacterEventListener>) listeners.clone()) {
                    l.onAllMsg(character, msg);
                }
            }
        };
        queue(event);
    }

    public void onAttack(final RPGCharacter attacker, final RPGCharacter target, final Destructive weapon, final int damage, final int dealtDamage) {
        CharacterEvent event = new CharacterEvent() {

            public void forward() {
                for (CharacterEventListener l : (List<CharacterEventListener>) listeners.clone()) {
                    l.onAttack(attacker, target, weapon, damage, dealtDamage);
                }
            }
        };
        queue(event);
    }

    public void onEquip(final RPGCharacter user, final Item equip) {
        CharacterEvent event = new CharacterEvent() {

            public void forward() {
                for (CharacterEventListener l : (List<CharacterEventListener>) listeners.clone()) {
                    l.onEquip(user, equip);
                }
            }
        };
        queue(event);
    }

    public void onGiveGold(final RPGCharacter character, final RPGCharacter target, final long amount) {
        CharacterEvent event = new CharacterEvent() {

            public void forward() {
                for (CharacterEventListener l : (List<CharacterEventListener>) listeners.clone()) {
                    l.onGiveGold(character, target, amount);
                }
            }
        };
        queue(event);
    }

    public void onGiveItem(final RPGCharacter character, final RPGCharacter target, final Class<? extends Item> itemClass, final int amount) {
        CharacterEvent event = new CharacterEvent() {

            public void forward() {
                for (CharacterEventListener l : (List<CharacterEventListener>) listeners.clone()) {
                    l.onGiveItem(character, target, itemClass, amount);
                }
            }
        };
        queue(event);
    }

    public void onHeal(final RPGCharacter character, final int healing) {
        CharacterEvent event = new CharacterEvent() {

            public void forward() {
                for (CharacterEventListener l : (List<CharacterEventListener>) listeners.clone()) {
                    l.onHeal(character, healing);
                }
            }
        };
        queue(event);
    }

        public void onManaIncrease(final RPGCharacter character, final int mana) {
        CharacterEvent event = new CharacterEvent() {

            public void forward() {
                for (CharacterEventListener l : (List<CharacterEventListener>) listeners.clone()) {
                    l.onManaIncrease(character, mana);
                }
            }
        };
        queue(event);
    }


     public void onMaxManaIncrease(final RPGCharacter character, final int maxMana) {
        CharacterEvent event = new CharacterEvent() {

            public void forward() {
                for (CharacterEventListener l : (List<CharacterEventListener>) listeners.clone()) {
                    l.onMaxManaIncrease(character, maxMana);
                }
            }
        };
        queue(event);
    }

     public void onMaxHealthIncrease(final RPGCharacter character, final int maxHealth) {
        CharacterEvent event = new CharacterEvent() {

            public void forward() {
                for (CharacterEventListener l : (List<CharacterEventListener>) listeners.clone()) {
                    l.onMaxHealthIncrease(character, maxHealth);
                }
            }
        };
        queue(event);
    }


    public void onLevelUp(final RPGCharacter character) {
        CharacterEvent event = new CharacterEvent() {

            public void forward() {
                for (CharacterEventListener l : (List<CharacterEventListener>) listeners.clone()) {
                    l.onLevelUp(character);
                }
            }
        };
        queue(event);
    }

    public void onMove(final RPGCharacter character, final Locality locality) {
        CharacterEvent event = new CharacterEvent() {

            public void forward() {
                for (CharacterEventListener l : (List<CharacterEventListener>) listeners.clone()) {
                    l.onMove(character, locality);
                }
            }
        };
        queue(event);
    }

    public void onMsg(final RPGCharacter character, final String msg) {
        CharacterEvent event = new CharacterEvent() {

            public void forward() {
                for (CharacterEventListener l : (List<CharacterEventListener>) listeners.clone()) {
                    l.onMsg(character, msg);
                }
            }
        };
        queue(event);
    }

    public void onReach(final RPGCharacter character, final Locality locality) {
        CharacterEvent event = new CharacterEvent() {

            public void forward() {
                for (CharacterEventListener l : (List<CharacterEventListener>) listeners.clone()) {
                    l.onReach(character, locality);
                }
            }
        };
        queue(event);
    }

    public void onRevive(final RPGCharacter character) {
        CharacterEvent event = new CharacterEvent() {

            public void forward() {
                for (CharacterEventListener l : (List<CharacterEventListener>) listeners.clone()) {
                    l.onRevive(character);
                }
            }
        };
        queue(event);
    }

    public void onSetHome(final RPGCharacter character, final Locality locality) {
        CharacterEvent event = new CharacterEvent() {

            public void forward() {
                for (CharacterEventListener l : (List<CharacterEventListener>) listeners.clone()) {
                    l.onSetHome(character, locality);
                }
            }
        };
        queue(event);
    }

    public void onSetTarget(final RPGCharacter character, final RPGCharacter target) {
        CharacterEvent event = new CharacterEvent() {

            public void forward() {
                for (CharacterEventListener l : (List<CharacterEventListener>) listeners.clone()) {
                    l.onSetTarget(character, target);
                }
            }
        };
        queue(event);
    }

    public void onSkillPointIncrease(final RPGCharacter character, final int skillPoints) {
        CharacterEvent event = new CharacterEvent() {

            public void forward() {
                for (CharacterEventListener l : (List<CharacterEventListener>) listeners.clone()) {
                    l.onSkillPointIncrease(character, skillPoints);
                }
            }
        };
        queue(event);
    }

    public void onStop(final RPGCharacter character) {
        CharacterEvent event = new CharacterEvent() {

            public void forward() {
                for (CharacterEventListener l : (List<CharacterEventListener>) listeners.clone()) {
                    l.onStop(character);
                }
            }
        };
        queue(event);
    }

    public void onStrengthIncrease(final RPGCharacter character, final int strength) {
        CharacterEvent event = new CharacterEvent() {

            public void forward() {
                for (CharacterEventListener l : (List<CharacterEventListener>) listeners.clone()) {
                    l.onStrengthIncrease(character, strength);
                }
            }
        };
        queue(event);
    }

    public void onUnequip(final RPGCharacter user, final Item equip) {
        CharacterEvent event = new CharacterEvent() {

            public void forward() {
                for (CharacterEventListener l : (List<CharacterEventListener>) listeners.clone()) {
                    l.onUnequip(user, equip);
                }
            }
        };
        queue(event);
    }

    public void onUnsetTarget(final RPGCharacter character) {
        CharacterEvent event = new CharacterEvent() {

            public void forward() {
                for (CharacterEventListener l : (List<CharacterEventListener>) listeners.clone()) {
                    l.onUnsetTarget(character);
                }
            }
        };
        queue(event);
    }

    public void onXPIncrease(final RPGCharacter character, final int xp) {
        CharacterEvent event = new CharacterEvent() {

            public void forward() {
                for (CharacterEventListener l : (List<CharacterEventListener>) listeners.clone()) {
                    l.onXPIncrease(character, xp);
                }
            }
        };
        queue(event);
    }

    public void onKill(final RPGCharacter character) {
        CharacterEvent event = new CharacterEvent() {

            public void forward() {
                for (CharacterEventListener l : (List<CharacterEventListener>) listeners.clone()) {
                    l.onKill(character);
                }
            }
        };
        queue(event);
    }

    public void onAttackFinished(final RPGCharacter character) {
        CharacterEvent event = new CharacterEvent() {

            public void forward() {
                for (CharacterEventListener l : (List<CharacterEventListener>) listeners.clone()) {
                    l.onAttackFinished(character);
                }
            }
        };
        queue(event);
    }

    public void onUsageFinished(final RPGCharacter character) {
        CharacterEvent event = new CharacterEvent() {

            public void forward() {
                for (CharacterEventListener l : (List<CharacterEventListener>) listeners.clone()) {
                    l.onUsageFinished(character);
                }
            }
        };
        queue(event);
    }

}
