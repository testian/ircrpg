package ircrpg2.messaging.irc;

import ircrpg2.messaging.*;
import java.io.*;
import org.schwering.irc.lib.*;
import com.google.api.translate.Language;
import com.google.api.translate.Translate;
import java.util.*;

public class Bot implements MessageTarget, MessagingService {

    final static long CONNECTION_TIMER = 300000; //Check every 5 minutes if connected
    private IRCConnection conn;
    private String network;
    private int port;
    private String password;
    private String user;
    private String username;
    private String email;
    private Timer connectionTimer;
    private IRCEventListener eventHandler;
    private boolean timerOn;
    private boolean translate;
    String defaultChannel;

    public String getUser() {
        return user;
    }



    public IRCConnection getConnection() {
        return conn;
    }

    public MessageTarget createPrivateMessageTarget(String user) {
        return new PrivateMessageTarget(this, user);
    }

    public MessageTarget getPublicMessageTarget() {
        return this;
    }


    public Bot(String network, int port, String user, String password, String username, String email, String defaultChannel, CommandHandler commandHandler) {
        this.network = network;
        this.port = port;
        this.password = password;
        this.user = user;
        this.username = username;
        this.email = email;
        this.defaultChannel = defaultChannel;

        connectionTimer = new Timer();
        timerOn = false;
        translate = false;
        Translate.setHttpReferrer("http://violetsky.ch");
        this.eventHandler = new MainEventHandler(this, commandHandler);
        setupConn();



    }
    public void setTranslate(boolean translate) {
    this.translate = translate;
    }

    public synchronized void connect() {
        setupConn();
        try {
            conn.connect();
        } catch (IOException ex) {
            System.err.println(ex);
        }
        if (!timerOn) {

            startConnectionTimer();
        }
    }

    synchronized public void teardown() {
        teardown(null);
    }

    synchronized public void teardown(String quitMsg) {
        stopConnectionTimer();

        conn.removeIRCEventListener(eventHandler);
        if (quitMsg == null) {
            conn.doQuit();
        } else {
            conn.doQuit(quitMsg);
        }
        conn.close();

    }

    public String getDefaultChannel() {
        return defaultChannel;
    }

    public void setDefaultChannel(String defaultChannel) {
        this.defaultChannel = defaultChannel;
    }

    private void setupConn() {
        conn = new IRCConnection(network, port, port, password, user, username, email);

        conn.setDaemon(false);
        conn.setColors(false);
        conn.setPong(true);
        conn.setEncoding("UTF-8");
        conn.addIRCEventListener(eventHandler);


    }

    synchronized public void reconnect() {
        conn.removeIRCEventListener(eventHandler);
        conn.doQuit();
        conn.close();



        connect();
    }


    public void msg(String channel, String msg, boolean notice) {
        if (conn.isConnected()) {
            if (notice) {
                
                conn.doNotice(channel, msg);
                                if (translate) {
                try {
                    conn.doNotice(channel, "<Translation> " + Translate.execute(msg, Language.GERMAN, Language.ENGLISH));
                } catch (Exception ex) {System.err.println("Translation failed: " + ex);}
                }
            }
            else {
                conn.doPrivmsg(channel, msg);
                if (translate) {
                try {
                    conn.doPrivmsg(channel, "<Translation> " + Translate.execute(msg, Language.GERMAN, Language.ENGLISH));
                } catch (Exception ex) {System.err.println("Translation failed: " + ex);}
                }
            }
        } else {
            System.err.println("Not connected, cannot send: (" + channel + ") " + msg);
        }
    }

    public void msg(String msg) {
    msg(defaultChannel, msg, false);
    }





    private synchronized void startConnectionTimer() { //Starts a timer that triggers connection check to reconnect
        timerOn = true;
        connectionTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                synchronized (syncObject()) {
                    //System.out.print("Check connection state: ");
                    if (!conn.isConnected()) {
                        //System.out.println("not connected, reconnect");
                        connect();
                    }
                    /*else {
                    System.out.println("okay");
                    }*/
                }

            }
        }, CONNECTION_TIMER, CONNECTION_TIMER);

    }

    private Object syncObject() {
        return this;
    }

    private synchronized void stopConnectionTimer() {

        connectionTimer.cancel();
        connectionTimer.purge();
        timerOn = false;

    }
}
