/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.messaging.irc;

import ircrpg2.messaging.MessageTarget;
import ircrpg2.messaging.MessagingService;

/**
 *
 * @author testi
 */
public class LoadBalancer implements MessageTarget, MessagingService {
    private Bot[] bots;
    private int current;
    private int batchSize;
    public LoadBalancer(int batchSize, Bot... bots) {
        if (bots == null || bots.length < 1) throw new IllegalArgumentException("Must provide at least one argument");
        if (batchSize < 1) throw new IllegalArgumentException("batchSize must be at least 1");
        this.bots = bots;
        current = 0;
        this.batchSize = batchSize;
    }
    public LoadBalancer(Bot... bots) {
    this(5,bots);
    }
    private void round() {
    current++;
    current = current%(bots.length*batchSize);
    }

    public void msg(String message) {
        bots[current/batchSize].msg(message);
        round();
    }
    public void msg(String nickName, String message, boolean notice) {
        bots[current/batchSize].msg(nickName, message, notice);
        round();
    }

    public MessageTarget createPrivateMessageTarget(String user) {
        return new LBPrivateMessageTarget(this, user);
    }

    public MessageTarget getPublicMessageTarget() {
        return this;
    }


    public synchronized void teardown(String quitMsg) {
        for (Bot bot : bots) {
        bot.teardown(quitMsg);
        }
    }

    public synchronized void teardown() {
        for (Bot bot : bots) {
        bot.teardown();
        }
    }

    public synchronized void connect() {
        for (Bot bot : bots) {
        bot.connect();
        }
    }


}
