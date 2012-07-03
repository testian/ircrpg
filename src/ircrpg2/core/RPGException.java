/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;

/**
 *
 * @author testi
 */
public class RPGException extends Exception {

    Type exceptionType;
    public RPGException(Type exceptionType) {
        super();
        this.exceptionType = exceptionType;
    }
public enum Type {
CHARACTER_DEAD ("Dein Charakter ist tot"),
NOT_REACHABLE ("Dieser Ort ist von hier aus nicht erreichbar"),
WEIGHT_LIMIT_EXCEEDED ("Du trägst bereits zuviel Gewicht"),
INVENTORY_FULL ("Dein Inventar ist voll"),
NOT_CONTAINED ("Nicht enthalten"),
IDENTITY ("Bereits vorhanden"),
NOT_ENOUGH_GOLD("Du hast nicht genug Gold"),
ALREADY_THERE ("Du bist bereits vor Ort"),
OUT_OF_RANGE ("Du bist zu weit weg"),
NO_TARGET ("Du hast kein Ziel ausgewählt"),
ATTACK_PENDING ("Erstmal abwarten und Tee trinken"),
USAGE_PENDING ("Erstmal Tee trinken und abwarten"),
TARGET_DEAD ("Ziel ist bereits tot"),
NOT_STRONG_ENOUGH ("Du bist nicht stark genug"),
ILLEGAL_SELF_ACTION ("Aktion auf sich selbst nicht erlaubt"),
NO_DEAL ("Dieser Gegenstand wird nicht gehandelt"),
NO_DEAL_BUY ("Dieser Gegenstand wird hier nicht gekauft"),
NO_DEAL_SELL ("Dieser Gegenstand wird hier nicht verkauft"),
UNHANDLED ("Unbehandelter Fehler"),
NOT_EQUIPPED("Waffe nicht angelegt"),
ALREADY_EQUIPPED("Waffe bereits angelegt"),
NO_RESOURCES("Hier gibt es nichts zu finden"),
BAG_STILL_NEEDED("Behälter-Gegenstand ist noch in Gebrauch"),
NOT_ENOUGH_SKILLPOINTS ("Du hast nicht genug Fähigkeitspunkte"),
NOT_ENOUGH_MANA ("Du hast nicht genug Mana"),
ALREADY_DOING ("Das machst du bereits");



private String message;
Type(String message) {
this.message = message;
}
}
    public RPGException() {
    }
    public Type getType() {
    return exceptionType;
    }
public String getMessage() {
return exceptionType.message;
}
}
