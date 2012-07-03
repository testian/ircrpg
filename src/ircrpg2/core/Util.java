/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;

import java.util.TimerTask;

/**
 *
 * @author testi
 */
public class Util {
public static TimerTask tott(final Runnable r) {
return new TimerTask() {

            @Override
            public void run() {
                r.run();
            }

};
}
}
