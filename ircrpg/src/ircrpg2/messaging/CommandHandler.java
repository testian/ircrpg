/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ircrpg2.messaging;

import ircrpg2.core.*;
import java.lang.reflect.*;

/**
 *
 * @author testi
 */
public class CommandHandler {
//Library library;
    World world;
    Commands commands;

    public CommandHandler(World world) {
        commands = new Commands(world);
        this.world = world;
    }

    public void execute(final String user, String commandLine) {
        if (!commandLine.startsWith("!")) {
            return;
        }
//System.out.println("Debug lol1");
        final SimpleStringTokenizer t = new SimpleStringTokenizer(commandLine.substring(1));
        String command = t.nextToken();



        try {
            final Method toExecute = Commands.class.getMethod(command, String.class, String.class);
            Runnable r = world.entailTask(new Runnable() {

                public void run() {
                    try {
                        toExecute.invoke(commands, user, t.remainingString());
                    } catch (IllegalAccessException ex) {
                        world.getPublicMessageTarget().msg("Schwerer Fehler: " + ex);

                    } catch (InvocationTargetException ex) {
                        world.getPublicMessageTarget().msg("Schwerer Fehler: " + ex.getTargetException());
                        ex.getTargetException().printStackTrace();

                    }
                }
            });
            r.run();





        } catch (NoSuchMethodException ex) {
            world.getPublicMessageTarget().msg("Diesen Befehl gibt es nicht, " + user + ".");

        }
    }
}
