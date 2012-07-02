/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.persistence;

import ircrpg2.core.InitSource;
import ircrpg2.core.NPC;
import ircrpg2.core.RPGException;
import ircrpg2.core.World;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author testi
 */
public class NPCLoader implements InitSource {

    private File npcDir;
    public NPCLoader(String npcDir) {
    this.npcDir = new File(npcDir);
    }

    public void connect(World world) {
        for (File f : npcDir.listFiles()) {
        PersistedMap m = new PersistedMap();
        try {
        m.read(f);
        Map<String,String> entries = m.getEntries();
        if (!f.getName().startsWith("_")) {
        m.put("name", f.getName());
        }
        NPC npc = NPCFactory.instantiate(entries, world);
        try {
        world.getNPCConnector().connectNPC(npc);
        } catch (RPGException ex) {System.err.println("NPC already contained: " + npc.getName());}
        } catch (IOException ex) {throw new IllegalStateException(ex);}
        }
    }

}
