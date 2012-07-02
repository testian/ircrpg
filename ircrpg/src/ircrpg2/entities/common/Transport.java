/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.common;

import ircrpg2.core.Locality;
import ircrpg2.core.Named;
import ircrpg2.core.RPGCharacter;
import ircrpg2.core.RPGException;
import ircrpg2.core.Usable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map.Entry;

/**
 *
 * @author testi
 */
public class Transport extends DefaultLocality implements Usable {
private TimeTable timeTable;

public Transport(String name,long modulo) {
    super(name);
    timeTable = new TimeTable(modulo);
}




    public void addStation(Station s, long arrivalTime, long departureTime) {
        timeTable.addStation(s, arrivalTime, departureTime);
        s.setTransport(this);
    }

    public Locality currentStation() {
        return timeTable.currentStation();
    }

    public void printTimeTable(RPGCharacter user) {
    SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
    user.msg("Fahrplan: " + getName());
    for (Entry<Date, TimeTable.TimeTableEvent> e : timeTable.roundtrip().entrySet()) {
    String station = (e.getValue().isArrival() ? "Ankunft: " + e.getValue().getLocality().getName() : "Abfahrt: " + e.getValue().getLocality().getName());
    user.msg(df.format(e.getKey()) + " " + station);
    }

    }



    public void use(RPGCharacter user) throws RPGException {
        try {
        Locality c = currentStation();
        if (c != null) user.reach(c);
        } finally {
        printTimeTable(user);
        }
    }



}
