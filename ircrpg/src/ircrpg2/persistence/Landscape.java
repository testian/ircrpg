/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.persistence;

import ircrpg2.core.InitSource;
import ircrpg2.core.Locality;
import ircrpg2.core.Path;
import ircrpg2.core.RPGException;
import ircrpg2.core.World;
import ircrpg2.entities.common.DefaultLocality;
import ircrpg2.entities.common.DefaultPath;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author testi
 */
public class Landscape implements InitSource {
private String pathDir;
private String localityDir;
private Map<String, Path> paths;
private Map<String, Locality> localities;

    public Landscape(String pathDir, String localityDir) {
        this.pathDir = pathDir;
        this.localityDir = localityDir;
        paths = new HashMap<String, Path>();
        localities = new HashMap<String, Locality>();
    }
    private void load(World world) {
    File pd = new File(pathDir);
    if (pd.isDirectory()) {
    for (File f : pd.listFiles()) {
    loadPath(f.getName(),world);
    }
    }
    File ld = new File(localityDir);
    if (ld.isDirectory()) {
    for (File f : ld.listFiles()) {
    if (f.getName().startsWith("_")) loadLocality(f.getName().substring(1),world);
    else
    loadLocality(f.getName(),world);
    }
    }

    }

    private Locality loadLocality(String name, World world) {
    //System.out.println("Debug loadLocality: " + name);
    try {
    Locality worldProbe = world.getLibrary().getLocality(name);
    return worldProbe;
    } catch (RPGException ex) {}
    Locality probe = localities.get(name);
    if (probe != null) return probe;
    if (localities.containsKey(name)) throw new IllegalStateException("Cycle detected: trying to load locality " + name + " recursively that is already in the process of being loaded. Make sure there are no localities referencing each other in a cycle.");
    localities.put(name, null);
    //TODO: More sophisticated locality generation such as for stores and resourcebases
    File lfnn = new File(localityDir + "/_" + name);
    File lf = new File(localityDir + "/" + name);
    PersistedMap pm = new PersistedMap();
    Locality newLocality;
    try {
    if (lfnn.exists() && lfnn.isFile()) {
    pm.read(lfnn);
    String referenceString = pm.get("reference");
    newLocality = LocalityFactory.instantiate(pm.getEntries(), referenceString == null ? null : loadLocality(referenceString,world));
    } else if (lf.exists() && lf.isFile()) {
    pm.read(lf);
    pm.put("name", name);
    String referenceString = pm.get("reference");
    newLocality = LocalityFactory.instantiate(pm.getEntries(), referenceString == null ? null : loadLocality(referenceString,world));
    } else {
    newLocality = new DefaultLocality(name);
    }
    } catch (IOException ex) {throw new IllegalStateException(ex);}
    System.out.println("Creating new locality: " + newLocality.getName());

    if (!newLocality.getName().equals(name)) throw new IllegalArgumentException("Name mismatch, requested name " + name + " does not match name of generated instance " + newLocality.getName());
    localities.put(newLocality.getName(), newLocality);
    return newLocality;
    }
    private Path loadPath(String name, World world) {
    try { world.getLibrary().getPath(name);throw new IllegalArgumentException("Path " + name + " already exists in world");}catch (RPGException ex){}
    Path probe = paths.get(name);
    if (probe != null) return probe;
    
    File pf = new File(pathDir + "/" + name);
    if (!pf.exists() || !pf.isDirectory()) throw new IllegalArgumentException("Can't load path: " + pf.getAbsolutePath() + " does not exist or is not a directory");
    int pathLength = -1;
    Locality l1 = null;
    Locality l2 = null;
    
    for (File f : pf.listFiles()) {
        String propName = f.getName();
        if (propName.startsWith("_")) {
        try {
        pathLength = Integer.parseInt(propName.substring(1));
        } catch (NumberFormatException ex) {}
        } else {
        if (l1 == null) {
        l1 = loadLocality(propName,world);
        } else if (l2 == null) {
        l2 = loadLocality(propName,world);
        } else {
        throw new IllegalArgumentException("Can't load path " + name + ", because more than 2 localities have been specified");
        }
        }
    }
    if (pathLength < 0) {throw new IllegalArgumentException("Can't load path " + name + ", because no valid length property is contained");}
    if (l1 == null || l2 == null) throw new IllegalArgumentException("Can't load path " + name + ", because less than 2 localities have been specified");
    DefaultPath newPath = new DefaultPath(name,pathLength);
    newPath.setLocalities(l1, l2);
    l1.getPaths().add(newPath);
    l2.getPaths().add(newPath);
    paths.put(newPath.getName(), newPath);
    System.out.println("Creating new path: " + newPath.getName());
    return newPath;
    }

    public void connect(World world) {
    load(world);
    //List<Path> existingPaths = new LinkedList<Path>();
    /*for (String ps : paths.keySet()) {
    try {
        Path e = world.getLibrary().getPath(ps);
        throw new IllegalStateException("Path " + ps + " already contained");

    } catch (RPGException ex) {
    //throw new IllegalStateException(ex);
    }
    }*/

    /*List<Locality> existingLocalities = new LinkedList<Locality>();
    for (String ls : localities.keySet()) {
    try {
        Locality e = world.getLibrary().getLocality(ls);
        existingLocalities.add(e);

    } catch (RPGException ex) {
    //Everything is fine
    }
    }*/

    /*for (Path p : existingPaths) {
    replace(paths.get(p.getName()),p);
    paths.remove(p.getName());
    }*/
    /*for (Locality l : existingLocalities) {
    replace(localities.get(l.getName()),l);
    localities.remove(l.getName());
    }*/

    for (Path p : paths.values()) {
        try {
        world.getLibrary().addPath(p);
        } catch (RPGException ex) {
        System.err.println("Error loading landscape: Path " + p.getName() + " could not be inserted");
        }
    }

    for (Locality l : localities.values()) {
        try {
        world.getLibrary().addLocality(l);
        } catch (RPGException ex) {
        System.err.println("Error loading landscape: Locality " + l.getName() + " could not be inserted");
        }
    }





    }

    /*private void replace(Path oldPath, Path newPath) {
    System.out.println("Replacing " + oldPath.getName() + " with " + newPath.getName());
    paths.values().remove(oldPath);
    paths.put(newPath.getName(), newPath);
    for (Locality l : localities.values()) {
    if (l.getPaths().contains(oldPath)) {
    l.getPaths().remove(oldPath);
    l.getPaths().add(newPath);
    }
    }
    }*/
    /*private void replace(Locality oldLocality, Locality newLocality) {
    System.out.println("Replacing " + oldLocality.getName() + " with " + newLocality.getName());
    newLocality.getPaths().addAll(oldLocality.getPaths());

    



    System.out.println();
    localities.values().remove(oldLocality);
    localities.put(newLocality.getName(), newLocality);
    for (Path p : paths.values()) {
    if (p.getLocalities().contains(oldLocality)) {
    p.getLocalities().remove(oldLocality);
    p.getLocalities().add(newLocality);
    }
    }
    System.out.println("New connections:");
    for (Locality l : newLocality.getLocalities()) {
    System.out.println(l.getName());
    }
    }*/

}
