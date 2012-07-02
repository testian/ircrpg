/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;
import java.util.*;
import java.io.*;
import ircrpg2.persistence.*;
/**
 *
 * @author testi
 */
public class Library {
Map<String, RPGCharacter> players;
Map<String, RPGCharacter> npcs;
Map<String, Locality> localities;
Map<String, Path> paths;
File persistenceDir;
World world;
public Library(World world) {
    this(new File(new File(System.getProperty("user.home")),".ircrpg"), world);
}
public Library(File persistenceDir, World world) {
players = new HashMap<String, RPGCharacter>();
npcs = new HashMap<String, RPGCharacter>();
localities = new HashMap<String, Locality>();
paths = new HashMap<String, Path>();
this.persistenceDir = persistenceDir;
this.world = world;
}

synchronized public void persistPlayers() {
setupPersistence();
CharacterPersistence persistence = new CharacterPersistence(world);
for (RPGCharacter p : players.values()) {
    try {
persistence.persistCharacter(p, new File(persistenceDir,"players/" + StringToHex(p.getName())));
    } catch (IOException ex) {System.err.println(ex);}
}
}

public static String StringToHex(String o) {

StringBuffer hexString = new StringBuffer();
for (int i = 0; i < o.length();i++) {
char c = o.charAt(i);
String hexPart = Integer.toHexString(c);
for (int j = hexPart.length(); j < 4; j++) {
hexString.append("0");
}
hexString.append(hexPart);

}
return hexString.toString();
}
public Collection<RPGCharacter> getPlayers() {
return players.values();
}
public Collection<RPGCharacter> getNPCs() {
return npcs.values();
}

synchronized public void loadPlayers() {

    CharacterPersistence persistence = new CharacterPersistence(world);

    File p = new File(persistenceDir,"players");
    
    File[] list = p.listFiles();
    if (list != null) {
    for (File playerFile : list) {
        try {

        persistence.loadCharacter(playerFile);
        } catch (IOException ex) {
        System.err.println("loadPlayers: " + ex);
        }
    }
    }
}

private void setupPersistence()
{
File p = new File(persistenceDir,"players");
File n = new File(persistenceDir,"npcs");

if (!p.exists()) {
p.mkdirs();
}
if (!n.exists()) {
n.mkdirs();
}
//File i = new File(persistenceDir,"items");
}
synchronized public void addPlayer(RPGCharacter player) throws RPGException {
if (players.containsKey(player.getName()) || npcs.containsKey(player.getName())) { throw new RPGException(RPGException.Type.IDENTITY);

}
players.put(player.getName(), player);
}
synchronized public void removePlayer(String key) throws RPGException {
    if (players.containsKey(key))
    {players.remove(key);}
    else {
    throw new RPGException(RPGException.Type.NOT_CONTAINED);
    }
}


synchronized public void addNPC(RPGCharacter player) throws RPGException {
if (npcs.containsKey(player.getName()) || players.containsKey(player.getName())) { throw new RPGException(RPGException.Type.IDENTITY);

}
npcs.put(player.getName(), player);
}
synchronized public void removeNPC(String key) throws RPGException {
    if (npcs.containsKey(key))
    {npcs.remove(key);}
    else {
    throw new RPGException(RPGException.Type.NOT_CONTAINED);
    }
}

public void addLocality(Locality locality) throws RPGException {
if (localities.containsKey(locality.getName())) { throw new RPGException(RPGException.Type.IDENTITY);

}
localities.put(locality.getName(), locality);
}
public void removeLocality(String key) throws RPGException {
    if (localities.containsKey(key))
    {localities.remove(key);}
    else {
    throw new RPGException(RPGException.Type.NOT_CONTAINED);
    }
}
public void addPath(Path path) throws RPGException {
if (paths.containsKey(path.getName())) { throw new RPGException(RPGException.Type.IDENTITY);

}
paths.put(path.getName(), path);
}
public void removePath(String key) throws RPGException {
    if (paths.containsKey(key))
    {paths.remove(key);}
    else {
    throw new RPGException(RPGException.Type.NOT_CONTAINED);
    }
}


public RPGCharacter getPlayer(String name) throws RPGException {
RPGCharacter object = players.get(name);
if (object == null) {throw new RPGException(RPGException.Type.NOT_CONTAINED);}
return object;
}

public RPGCharacter getNPC(String name) throws RPGException {
RPGCharacter object = npcs.get(name);
if (object == null) {throw new RPGException(RPGException.Type.NOT_CONTAINED);}
return object;
}

public Locality getLocality(String name) throws RPGException {
Locality object = localities.get(name);
if (object == null) {throw new RPGException(RPGException.Type.NOT_CONTAINED);}
return object;
}

public Path getPath(String name) throws RPGException {
Path object = paths.get(name);
if (object == null) {throw new RPGException(RPGException.Type.NOT_CONTAINED);}
return object;
}

/*public static <T extends Named> Named getByName(Set<T> set, String name) {
for (T t : set) {
if (name.equals(t.getName())) {
return t;
}
}
return null;
}*/
}
