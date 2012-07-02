/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author testi
 */
public class Matching {
public static <T extends Named> T getBestMatch(Set<? extends T> nameds, String match) throws MultipleMatchException {



T exact = getExactMatch(nameds,match);
if (exact != null) return exact;
Set<T> startMatchList = getStartMatch(nameds,match,true);
if (startMatchList.size() > 1) {
MultipleMatchException mmex = new MultipleMatchException();
for (T n : startMatchList) {
mmex.addMatch(n);
}
throw mmex;
}
if (startMatchList.size() == 1) return startMatchList.iterator().next();



Set<T> insensitiveMatchList = getInsensitiveMatch(nameds,match);
if (insensitiveMatchList.size() > 1) {
MultipleMatchException mmex = new MultipleMatchException();
for (T n : insensitiveMatchList) {
mmex.addMatch(n);
}
throw mmex;
}
if (insensitiveMatchList.size() == 1) return insensitiveMatchList.iterator().next();

Set<T> startInsensitiveMatchList = getStartMatch(nameds,match,false);
if (startInsensitiveMatchList.size() > 1) {
MultipleMatchException mmex = new MultipleMatchException();
for (T n : startInsensitiveMatchList) {
mmex.addMatch(n);
}
throw mmex;
}
if (startInsensitiveMatchList.size() == 1) return startInsensitiveMatchList.iterator().next();


return null;

}

public static <T extends Named> T getExactMatch(Set<? extends T> nameds, String match) {
for (T n : nameds) {
boolean matches = n.getName().equals(match);
if (matches) return n;
}
return null;
}
public static <T extends Named> Set<T> getInsensitiveMatch(Set<? extends T> nameds, String match) {
HashSet<T> matchList = new HashSet<T>();
for (T n : nameds) {
boolean matches = n.getName().equalsIgnoreCase(match);
if (matches) matchList.add(n);
}
return matchList;
}
public static <T extends Named> Set<T> getStartMatch(Set<? extends T> nameds, String match, boolean caseSensitive) {
HashSet<T> matchList = new HashSet<T>();
for (T n : nameds) {
boolean matches = caseSensitive ? n.getName().startsWith(match): n.getName().toLowerCase().startsWith(match.toLowerCase());
if (matches) matchList.add(n);
}
return matchList;
}
}
