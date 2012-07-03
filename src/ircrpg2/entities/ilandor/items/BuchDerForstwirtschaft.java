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
public class BuchDerForstwirtschaft extends ItemCommon {

    public String getName() {
        return "Buch der Forstwirtschaft";
    }

    public int getWeight() {
        return 500;
    }

    public void onItemRemoved(RPGCharacter user) {
    }

        public String itemInfo() {
        return super.itemInfo() + ". Benötigt 12 Fähigkeitspunkte. ";
    }

    public void use(RPGCharacter user) throws RPGException {
        if (user.hasSkill(Foerster.class)) {
            user.msg("Du liest das Buch über die Forstwirtschaft nochmal und dann merkst du, dass du nichts übersehen hast.");
            return;}
        user.msg("12 Fähigkeitspunkte werden beim Lesen dieses Buches verbraucht.");
        user.decreaseSkillPoints(12);
        user.msg("Du liest das Buch über die Forstwirtschaft und erwirbst dadurch eine neue Fähigkeit.");
        user.msg("Für die Arbeit benötigst du meistens eine Holzfälleraxt.");
        user.learnSkill(new Foerster());
    }

}
