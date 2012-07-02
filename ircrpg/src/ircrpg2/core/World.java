/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;
import ircrpg2.messaging.*;
import java.util.TimerTask;
/**
 *
 * @author testi
 */
public interface World {
public Library getLibrary();
public PlayerFactory getPlayerFactory();
public NPCConnector getNPCConnector();
public MessageTarget getPublicMessageTarget();
public void setMessagingService(MessagingService ms);
public MessagingService getMessagingService();
public CharacterEventMulticaster getGlobalListener();
public void init(InitSource... initSource);
public Runnable entailTask(Runnable runnable);
}
