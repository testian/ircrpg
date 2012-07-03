/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2;

import ircrpg2.core.NPC;
import ircrpg2.entities.ilandor.DefaultWorld;
import ircrpg2.messaging.MessageTarget;
import ircrpg2.messaging.MessagingService;
import ircrpg2.persistence.NPCFactory;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author testi
 */
public class NPCFactoryTest {
public static void main(String[] args) {
Map<String, String> myMap = new HashMap<String, String>();
myMap.put("class", "ircrpg2.entities.ilandor.npc.Anita");
myMap.put("home", "Redynia");
//myMap.put("id", "51");
DefaultWorld ilandor = new ircrpg2.entities.ilandor.DefaultWorld();
ilandor.setMessagingService(new MessagingService() {

            public MessageTarget createPrivateMessageTarget(String user) {
                return new MessageTarget() {

                    public void msg(String message) {
                        
                    }

                };
            }

            public MessageTarget getPublicMessageTarget() {
                return new MessageTarget() {

                    public void msg(String message) {

                    }

                };
            }
        });

ilandor.init();
NPC myNPC  = NPCFactory.instantiate(myMap,ilandor);
System.out.println(myNPC.getName() + ": " + myNPC.getStrength() + " " + myNPC.getCurrentWeapon().getName());
}
}
