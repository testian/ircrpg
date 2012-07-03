/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.messaging.irc;

import ircrpg2.messaging.MessageTarget;

/**
 *
 * @author testi
 */
public class LBPrivateMessageTarget implements MessageTarget {

    private LoadBalancer lb;
    private String nickName;

    public LBPrivateMessageTarget(LoadBalancer lb, String nickName) {
        this.lb = lb;
        this.nickName = nickName;
    }

    public void msg(String message) {
        lb.msg(nickName, message, true);
    }

}
