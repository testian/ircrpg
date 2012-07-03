/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.messaging;

/**
 *
 * @author testi
 */
public interface MessagingService {
public MessageTarget getPublicMessageTarget();
public MessageTarget createPrivateMessageTarget(String user);
}
