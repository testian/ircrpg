/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.ai;

/**
 *
 * @author testi
 */
public interface Target {
public boolean satisfied();
public void followTarget();
public boolean related(Object o);
//public void discard();
}
