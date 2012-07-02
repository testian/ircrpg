/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;

/**
 *
 * @author testi
 */
public interface Destructive extends Named {
public DestructionType getType();
public static enum DestructionType {
WEAPON,
MAGIC
}
}
