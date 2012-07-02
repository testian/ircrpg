package ircrpg2.messaging.irc;
import org.schwering.irc.lib.*;
import ircrpg2.messaging.*;
import java.util.*;

public class MainEventHandler implements IRCEventListener {
	private Bot bot;
	private CommandHandler commandHandler;

	
	public MainEventHandler(Bot bot, CommandHandler commandHandler)
	{
	this.bot=bot;
	this.commandHandler = commandHandler;
	}
	
	
	
	
	public void onDisconnected() {
		// TODO Auto-generated method stub
		//System.out.println("Disconnected");
	bot.reconnect();
	}

	public void onError(String arg0) {
		// TODO Auto-generated method stub
		//System.err.println("Error: " + arg0);
	}

	public void onError(int arg0, String arg1) {
		// TODO Auto-generated method stub
		//System.err.println("Error: " + arg0);
		//System.err.println("       " + arg1);
	}

	public void onInvite(String arg0, IRCUser arg1, String arg2) {
		// TODO Auto-generated method stub
//		System.out.println("Invited by " + arg1 + " to " + arg2)
	}

	public void onJoin(String arg0, IRCUser arg1) {
		// TODO Auto-generated method stub
//		System.out.println(arg1 + " joined " + arg0);
	}

	public void onKick(String arg0, IRCUser arg1, String arg2, String arg3) {
		// TODO Auto-generated method stub
	//	System.out.println(arg0 + " " + arg1 + " " + arg2 + " " + arg3);

	}

	public void onMode(String arg0, IRCUser arg1, IRCModeParser arg2) {
		// TODO Auto-generated method stub
		//System.out.println("Mode1");
	}

	public void onMode(IRCUser arg0, String arg1, String arg2) {
		// TODO Auto-generated method stub
//		System.out.println("Mode2");

	}

	public void onNick(IRCUser arg0, String arg1) {
		// TODO Auto-generated method stub
	//	System.out.println("Nickchange");
	}

	public void onNotice(String arg0, IRCUser arg1, String arg2) {
        // TODO Auto-generated method stub
		//System.out.println("Notice");
	}

	public void onPart(String arg0, IRCUser arg1, String arg2) {
		// TODO Auto-generated method stub
		//System.out.println("Part");
	}

	public void onPing(String arg0) {
		// TODO Auto-generated method stub

	}

	public void onPrivmsg(String arg0, IRCUser arg1, String arg2) {
        //System.err.println("Got message: " + arg1 + " - " + arg2);
        if (arg0 == null) return;
        if (!arg0.equalsIgnoreCase(bot.getDefaultChannel())) return;
        if (commandHandler != null)
        commandHandler.execute(arg1.getNick(), arg2);

        //Stupid fix..
        /*if ("@join".equals(arg2))
        {
            bot.getConnection().doJoin(bot.getDefaultChannel());
        }*/
	}

	public void onQuit(IRCUser arg0, String arg1) {
		// TODO Auto-generated method stub
//		System.out.println("Quit");
	}

	public void onRegistered() {
		// TODO Auto-generated method stub
	//	System.out.println("Registered");
		//for (Iterator<String> i = bot.getChannels().iterator();i.hasNext();)

        new Timer().schedule(new TimerTask() {
        public void run() {
            bot.getConnection().doMode(bot.getUser(),"+B");
            bot.getConnection().doJoin(bot.getDefaultChannel());
        }
        }, 10000);
        

	}

	public void onReply(int arg0, String arg1, String arg2) {

	}

	public void onTopic(String arg0, IRCUser arg1, String arg2) {
		// TODO Auto-generated method stub
		//System.out.println("Topic change");
	}

	public void unknown(String arg0, String arg1, String arg2, String arg3) {
		// TODO Auto-generated method stub
		//System.out.println("UnknownEvent");
	}

}
