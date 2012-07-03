/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.common;

import ircrpg2.core.CharacterEventMulticaster;
import ircrpg2.core.DefaultNPCConnector;
import ircrpg2.core.InitSource;
import ircrpg2.core.Library;
import ircrpg2.core.NPCConnector;
import ircrpg2.core.PlayerFactory;
import ircrpg2.core.RPGException;
import ircrpg2.core.Util;
import ircrpg2.core.World;
import ircrpg2.messaging.MessageTarget;
import ircrpg2.messaging.MessagingService;
import java.util.Timer;

/**
 *
 * @author testi
 */
public abstract class WorldCommon implements World {

    protected Library library;
    protected PlayerFactory playerFactory;
    protected NPCConnector npcConnector;
    protected MessagingService ms;
    protected CharacterEventMulticaster globalListener;
    public WorldCommon() {
    this.ms = null;
        library = new Library(this);
        globalListener = new CharacterEventMulticaster();
        playerFactory = null;
        npcConnector = new DefaultNPCConnector(this);
    }

    public void init(InitSource... initSources) {
        for (InitSource is : initSources) {
        is.connect(this);
        }
        library.loadPlayers();
        new Timer().schedule(Util.tott(this.entailTask(new Runnable() {

            
            public void run() {
                library.persistPlayers();
                System.out.println("Persisting..");
            }

        })), 300*1000,300*1000);
    }


    public void connect(DefaultLocality l1, DefaultLocality l2, DefaultPath p) {
        l1.addPath(p);
        l2.addPath(p);
        p.setLocalities(l1, l2);
        try {
            library.addLocality(l1);
        } catch (RPGException ex) {
        }
        try {
            library.addLocality(l2);
        } catch (RPGException ex) {
        }
        try {
            library.addPath(p);
        } catch (RPGException ex) {
        }
    }


    public Runnable entailTask(final Runnable runnable) {
        return new Runnable() {

            public void run() {
                synchronized (WorldCommon.this) {
                    globalListener.hold();
                    runnable.run();
                    globalListener.commit();
                }
            }
        };
    }

    public CharacterEventMulticaster getGlobalListener() {
        return globalListener;
    }

    public Library getLibrary() {
        return library;
    }

    public MessagingService getMessagingService() {
        return ms;
    }

    public NPCConnector getNPCConnector() {
        return npcConnector;
    }

    public PlayerFactory getPlayerFactory() {
        return playerFactory;
    }

    public MessageTarget getPublicMessageTarget() {
        return ms.getPublicMessageTarget();
    }

    public void setMessagingService(MessagingService ms) {
        this.ms = ms;
    }

}
