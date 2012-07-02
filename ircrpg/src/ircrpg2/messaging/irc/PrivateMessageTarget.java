/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.messaging.irc;
import ircrpg2.messaging.*;
/**
 *
 * @author testi
 */
public class PrivateMessageTarget implements MessageTarget {
    private Bot bot;
    private String nickName;

    public PrivateMessageTarget(Bot bot, String nickName) {
        this.bot = bot;
        this.nickName = nickName;
    }

    public void msg(String message) {
        bot.msg(nickName, message, true);
    }

}
