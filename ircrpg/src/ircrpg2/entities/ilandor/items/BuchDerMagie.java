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
public class BuchDerMagie extends ItemCommon {

    public String getName() {
        return "Das grosse Buch der Magie";
    }

    public int getWeight() {
        return 2000;
    }

    public void onItemRemoved(RPGCharacter user) {
    }

    public String itemInfo() {
        return super.itemInfo() + ". Benötigt 20 Fähigkeitspunkte und Alchemie 20%";
    }



    public void use(RPGCharacter user) throws RPGException {
        if (user.hasSkill(Magier.class)) {
            user.msg("Du liest das Buch über die Magie nochmal und dann merkst du, dass du nichts übersehen hast.");
            return;}
        Skill a = user.getSkill(Alchemist.class);
        if (a == null) {
        user.msg("Du brauchst Alchemie erlernt zu haben");
            return;
        }
        if (a.getProgress() < 2000) {
        user.msg("Du benötigst 20% Erfahrung in Alchemie.");
        return;
        }

        user.msg("20 Fähigkeitspunkte werden beim Lesen dieses Buches verbraucht.");
        user.decreaseSkillPoints(20);
        user.msg("Du liest das grosse Buch über die Magie und erwirbst dadurch eine neue Fähigkeit.");
        //user.msg("Für die Arbeit verbrauchst du einen Schleifstein.");
        user.learnSkill(new Magier());
    }

}
