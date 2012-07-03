/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2;

import ircrpg2.ai.ShortestPath;
import ircrpg2.core.Locality;
import ircrpg2.core.RPGException;
import ircrpg2.core.World;
import ircrpg2.entities.ilandor.DefaultWorld;
import ircrpg2.messaging.MessageTarget;
import ircrpg2.messaging.MessagingService;

/**
 *
 * @author testi
 */
public class TestPath {
public static void main(String[] args) {
World defaultWorld = new DefaultWorld();
defaultWorld.setMessagingService(new MessagingService() {

            public MessageTarget createPrivateMessageTarget(String user) {
                return new MessageTarget() {

                    public void msg(String message) {
                        System.out.println("msg " + message);
                    }

                };
            }

            public MessageTarget getPublicMessageTarget() {
                return new MessageTarget() {

                    public void msg(String message) {
                        System.out.println("msg " + message);
                    }

                };
            }

});
defaultWorld.init();
try {
Locality a = defaultWorld.getLibrary().getLocality("Redynia");
Locality b = defaultWorld.getLibrary().getLocality("Kuryllinfeld");
ShortestPath sp = new ShortestPath(a,b);
for (Locality n : sp.getPath()) {
System.out.println(n.getName());
}
} catch (RPGException ex) {System.err.println(ex);}
}

}
