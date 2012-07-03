/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2;

import ircrpg2.core.Locality;
import ircrpg2.entities.common.DefaultLocality;
import ircrpg2.entities.common.TimeTable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map.Entry;

/**
 *
 * @author testi
 */
public class TestTimeTable {
public static void main(String[] args) {
TimeTable t = new TimeTable(3600);

t.addStation(new DefaultLocality("Redinja!"), 2*60, 5*60);
t.addStation(new DefaultLocality("Leiterland"), 7*60, 20*60);
t.addStation(new DefaultLocality("Hansland"), 21*60, 25*60);
t.addStation(new DefaultLocality("Kinderwelt"), 50*60, 1*60);
Locality current = t.currentStation();
if (current != null) System.out.println("Station: " + current.getName());
SimpleDateFormat df = new SimpleDateFormat("HH:mm");
for (Entry<Date, TimeTable.TimeTableEvent> e : t.roundtrip((System.currentTimeMillis()/1000)+1000).entrySet()) {
String station = (e.getValue().isArrival() ? "Ankunft: " + e.getValue().getLocality().getName() : "Abfahrt: " + e.getValue().getLocality().getName());
System.out.println(df.format(e.getKey()) + " " + station);
}


}
}
