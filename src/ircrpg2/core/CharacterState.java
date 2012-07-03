/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;

/**
 *
 * @author testi
 */
public enum CharacterState {
ALIVE ("Lebendig"),
DEAD ("Tot");

private String description;
CharacterState(String description) {
this.description = description;
}
public String getDescription() {
return description;
}
}
