/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.ilandor.items;
import ircrpg2.core.*;
import ircrpg2.core.ItemCommon;
import ircrpg2.entities.ilandor.skills.*;
/**
 *
 * @author testi
 */
public class BuchDerSchmiede extends ItemCommon {

    public String getName() {
        return "Buch der Schmiede";
    }

    public int getWeight() {
        return 500;
    }

    public void onItemRemoved(RPGCharacter user) {
    }

    public String itemInfo() {
        return super.itemInfo() + ". Benötigt 8 Fähigkeitspunkte. ";
    }



    public void use(RPGCharacter user) throws RPGException {
        if (user.hasSkill(Schmied.class)) {
            user.msg("Du liest das Buch über die Schmiede nochmal und dann merkst du, dass du nichts übersehen hast.");
            return;}
        user.msg("8 Fähigkeitspunkte werden beim Lesen dieses Buches verbraucht.");
        user.decreaseSkillPoints(8);
        user.msg("Du liest das Buch über die Schmiede und erwirbst dadurch eine neue Fähigkeit.");
        user.msg("Für die Arbeit verbrauchst du einen Schleifstein.");
        user.learnSkill(new Schmied());
    }

}
