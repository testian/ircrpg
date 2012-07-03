/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author testi
 */
public class MultipleMatchException extends Exception {
    private TreeMap<String,Named> nameds;
    public MultipleMatchException(Set<Named> nameds) {
    this(nameds.toArray(new Named[0]));
    }
    public MultipleMatchException(Named... nameds) {
    this();
        for (Named n : nameds) {
        
            
            if (this.nameds.containsKey(n.getName())) throw new IllegalArgumentException("Can't work with multiple exact matches");

                this.nameds.put(n.getName(), n);
        }
    }
    public MultipleMatchException() {
        nameds = new TreeMap<String, Named>();
    }
    public void addMatch(Named match) {
        if (this.nameds.containsKey(match.getName())) throw new IllegalArgumentException("Can't work with multiple exact matches");
        this.nameds.put(match.getName(), match);
    }

    @Override
    public String getMessage() {
        StringBuffer message = new StringBuffer();
        message.append("Mehrere Übereinstimmungen: ");
        for (Named n : nameds.values()) {
        message.append(n.getName() + "; ");
        }
        return message.toString().trim();
    }
    public List<Named> getMatches() {
    ArrayList<Named> al = new ArrayList<Named>();
    for (Named n : nameds.values()) {
    al.add(n);
    }
    return al;
    }


}

