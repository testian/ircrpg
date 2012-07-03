/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;
import ircrpg2.core.*;
import ircrpg2.messaging.*;
/**
 *
 * @author testi
 */
public class DefaultNPCConnector implements NPCConnector {
World world;

    public DefaultNPCConnector(World world) {
        this.world = world;
    }

    public void connectNPC(final NPC npc) throws RPGException {
        world.getGlobalListener().addCharacterEventListener(npc.getNPCBehaviour());

        MessageTarget priv = new MessageTarget() {

            public void msg(String message) {
                System.out.println("PMSG for " + npc.getName() + ": " + message);
            }

        };
        MessageTarget all = new MessageTarget() {

            public void msg(String message) {
                System.out.println("GMSG for " + npc.getName() + ": " + message);
            }

        };
        
        npc.addCharacterEventListener(new CharacterEventMessager(priv,all));
        npc.addCharacterEventListener(new FilteredMessager(world.getPublicMessageTarget()));
        npc.addCharacterEventListener(world.getGlobalListener());
        world.getLibrary().addNPC(npc);
    }

}
