/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.persistence;
import java.util.*;
import java.io.*;
/**
 *
 * @author testi
 */
public class PersistedMap {
private Map<String, String> entries;

    public String get(String key) {
    return entries.get(key);
    }
public PersistedMap() {
entries = new TreeMap<String, String>();
}

public void read(File file) throws IOException {
read(new FileInputStream(file));
}
public void read(InputStream is) throws IOException {
BufferedReader reader = new BufferedReader(new InputStreamReader(is));
String line;
while ((line = reader.readLine()) != null) {

int index = line.indexOf("=");
if (index!=-1) {
String key = line.substring(0,index);
String value = line.substring(index+1);
entries.put(key, value);
}

}
    
}
public void write(OutputStream os) throws IOException {

PrintWriter p = new PrintWriter(os);

for (Map.Entry<String, String> e : entries.entrySet()) {
p.println(e.getKey() + "=" + e.getValue());
}

p.flush();
p.close();
}
public void write(File file) throws IOException {
write(new FileOutputStream(file));
}

public void put(String key, String value) {
if (key.contains("\n") || key.contains("=") || value.contains("\n")) {throw new IllegalArgumentException("Invalid characters used");}
entries.put(key, value);
}//persistenzschicht für mpc(bitte)
//ha di gärn ond i mach das rechtig!der händ aui ke ahnig!!!
public Map<String, String> getEntries() {
return entries;
}

}
