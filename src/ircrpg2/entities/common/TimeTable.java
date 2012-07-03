/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.entities.common;

import ircrpg2.core.Locality;
import java.util.Date;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author testi
 */
public class TimeTable {

    private long modulo;
    private TreeMap<Long, Locality> stations;
    public TimeTable(long modulo) {
    this.modulo = modulo;
    stations = new TreeMap<Long, Locality>();
    }

    /**
     * Adds a station to this timetable
     * @param s
     * @param arrivalTime
     * @param departureTime
     */
    public void addStation(Locality s, long arrivalTime, long departureTime) {
    
    if (arrivalTime >= modulo || arrivalTime < 0) throw new IllegalArgumentException("arrivalTime must be within range of 0-" + modulo);
    if (departureTime >= modulo || departureTime < 0) throw new IllegalArgumentException("departureTime must be within range of 0-" + modulo);
    if (arrivalTime == departureTime) throw new IllegalArgumentException("arrivalTime and departureTime must not be equal");
    
    if (arrivalTime < departureTime && !stations.subMap(arrivalTime, true, departureTime, true).isEmpty()) throw new IllegalArgumentException("Collides with existing entries");
    else if (arrivalTime > departureTime && (!stations.tailMap(arrivalTime).isEmpty() || !stations.headMap(departureTime, true).isEmpty())) throw new IllegalArgumentException("Collides with existing entries");

    stations.put(arrivalTime, s);
    stations.put(departureTime, null);
    }

    /**
     * 
     * @return the station the transport would be at that time according to this timetable, or null if the transport is currently on the way
     */
    public Locality currentStation() {
    return stationAtTime(System.currentTimeMillis()/1000);
    }
    /**
     * 
     * @param unixTime
     * @return the station the transport would be at UNIX Time unixTime according to this timetable, or null if the transport is currently on the way
     */
    public Locality stationAtTime(long unixTime) {
    if (stations.isEmpty()) throw new IllegalStateException("No stations ever added");
    long time = unixTime%modulo;
    Entry<Long, Locality> e = stations.floorEntry(time);
    if (e != null) return e.getValue();
    return stations.lastEntry().getValue();
    }
    /**
     *
     * @return the time in seconds until this TimeTable repeats
     */
    public long getModulo() {
    return modulo;
    }
    /**
     *
     * @return the next arrival and departure times (null-entries) until a roundtrip is made
     */
    public SortedMap<Date, TimeTableEvent> roundtrip() {
    return roundtrip(System.currentTimeMillis()/1000);
    }

    public static class TimeTableEvent {
    private Locality locality;
    boolean arrival;

        public TimeTableEvent(Locality locality, boolean arrival) {
            this.locality = locality;
            this.arrival = arrival;
        }

        public boolean isArrival() {
            return arrival;
        }

        public Locality getLocality() {
            return locality;
        }


    }

    /**
     * 
     * @param unixTime
     * @return the next arrival and departure times (null-entries) after UNIX-Time unixTime until a roundtrip is made
     */
    public SortedMap<Date, TimeTableEvent> roundtrip(long unixTime) {
    if (stations.isEmpty()) throw new IllegalStateException("No stations ever added");
    SortedMap<Date, TimeTableEvent> roundtrip = new TreeMap<Date, TimeTableEvent>();
    long time = unixTime%modulo;
    long initTime = unixTime-time;
    SortedMap<Long, Locality> tail = stations.tailMap(time);
    SortedMap<Long, Locality> head = stations.headMap(time);
    Locality last = null;
    for (Entry<Long, Locality> e : tail.entrySet()) {
        Locality current = e.getValue() == null ? last : e.getValue();
        boolean arrival = e.getValue() != null;
        roundtrip.put(new Date((initTime+e.getKey())*1000),new TimeTableEvent(current,arrival));
        last = e.getValue();
    }

    for (Entry<Long, Locality> e : head.entrySet()) {
        Locality current = e.getValue() == null ? last : e.getValue();
        boolean arrival = e.getValue() != null;
        roundtrip.put(new Date((initTime+modulo+e.getKey())*1000),new TimeTableEvent(current,arrival));
        last = e.getValue();
    }
    TimeTableEvent first = roundtrip.get(roundtrip.firstKey());
    if (first.getLocality() == null) first = new TimeTableEvent(roundtrip.get(roundtrip.lastKey()).getLocality(),first.isArrival());
    roundtrip.put(roundtrip.firstKey(), first);
    return roundtrip;

    }






}
