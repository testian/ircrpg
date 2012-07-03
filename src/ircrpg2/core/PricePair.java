/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;

/**
 *
 * @author testi
 */
public class PricePair {
    private long buy;
    private long sell;

        public long getBuy() {
            return buy;
        }

        public long getSell() {
            return sell;
        }

        public PricePair(long buy, long sell) {
            this.buy = buy;
            this.sell = sell;
        }
}