/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;

/**
 *
 * @author testi
 */
public abstract class NPCBehaviour implements CharacterEventListener {

    private NPC npc;
    public NPCBehaviour() {
    npc = null;
    }

    public NPC getNpc() {
        return npc;
    }

    public void setNpc(NPC npc) {
        this.npc = npc;
    }
    public abstract AttackBehaviour getAttackBehaviour();
    public abstract void setAttackBehaviour(AttackBehaviour assistBehaviour);
    public abstract AssistBehaviour getAssistBehaviour();
    public abstract void setAssistBehaviour(AssistBehaviour assistBehaviour);

}
