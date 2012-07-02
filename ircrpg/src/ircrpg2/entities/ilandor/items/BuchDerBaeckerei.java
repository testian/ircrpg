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
public class BuchDerBaeckerei extends ItemCommon {

    public String getName() {
        return "Buch der Bäckerei";
    }

    public int getWeight() {
        return 500;
    }

    public void onItemRemoved(RPGCharacter user) {
    }

        public String itemInfo() {
        return super.itemInfo() + ". Benötigt keine Fähigkeitspunkte. ";
    }

    public void use(RPGCharacter user) throws RPGException {
                if (user.hasSkill(Baecker.class)) {
            user.msg("Du liest das Buch über die Bäckerei nochmal und dann merkst du, dass du nichts übersehen hast.");
            return;}
        user.msg("Du liest das Buch über die Bäckerei und erlernst Brot zu backen");
        user.learnSkill(new Baecker());
    }

}
