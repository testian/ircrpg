/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.persistence;

import ircrpg2.core.Item;
import ircrpg2.core.ItemFactory;
import ircrpg2.core.Locality;
import ircrpg2.core.NPC;
import ircrpg2.core.RPGException;
import ircrpg2.core.Weapon;
import ircrpg2.core.World;
import ircrpg2.entities.common.NPCCommon;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author testi
 */
public class NPCFactory {
public static NPC instantiate(Class<? extends NPCCommon> npcClass, Object... parameters) {
    Class[] parameterClasses = new Class[parameters.length];
    System.out.print("Searching constructor: " + npcClass.getName() + "(");
    for (int i = 0; i < parameters.length; i++) {
    parameterClasses[i] = parameters[i].getClass();
    if (parameterClasses[i] == Integer.class) {
    parameterClasses[i] = int.class;
    }
    System.out.print(parameterClasses[i].getName() + ";");
    }
    System.out.println(")");
    try {
    Constructor<? extends NPCCommon> constructor = getConstructor(npcClass,parameterClasses);
    System.out.println("Calling constructor: " + constructor);
    return constructor.newInstance(parameters);
    } catch (NoSuchMethodException ex) {throw new IllegalArgumentException("Class provided doesn't have a matching constructor");}
    catch (InstantiationException ex) { throw new IllegalArgumentException(ex);}
    catch (IllegalAccessException ex) {throw new IllegalArgumentException(ex);}
    catch (InvocationTargetException ex) {throw new IllegalArgumentException(ex);}
}
private static Constructor getConstructor(Class clazz ,Class... parameterClasses) throws NoSuchMethodException {
for (Constructor c : clazz.getConstructors()) {
Class[] cParams = c.getParameterTypes();
    if (parameterClasses.length == cParams.length) {
    int i;
    for (i = 0; i < cParams.length; i++) {
    if (!cParams[i].isAssignableFrom(parameterClasses[i])) break;
    }
    if (i == cParams.length) return c;
    }
}
throw new NoSuchMethodException();
}
public static NPC instantiate(Map<String, String> parameters, World world) {
//(World world, int level, Locality home, Weapon primary, Weapon secondary, String name)
try {
    Class<? extends NPCCommon> npcClass = (Class <? extends NPCCommon>)Class.forName(parameters.get("class"));

    String localityString = parameters.get("home");
    if (localityString == null) throw new IllegalArgumentException("map doesn't contain an entry for 'home'");
    Locality home = world.getLibrary().getLocality(localityString);

    String name = parameters.get("name");


    String w1String = parameters.get("weapon1");
    Weapon primary = null;
    if (w1String != null) {
    primary = (Weapon)ItemFactory.instantiate((Class<? extends Item>)Class.forName(w1String));
    }

    String w2String = parameters.get("weapon2");
    Weapon secondary = null;
    if (w2String != null) {
    secondary = (Weapon)ItemFactory.instantiate((Class<? extends Item>)Class.forName(w1String));
    }




    Integer level = null;
    String levelString = parameters.get("level");
    if (levelString != null)
    level = Integer.parseInt(levelString);
    
    
    Integer id = null;
    String idString = parameters.get("id");
    if (idString != null)
    id = Integer.parseInt(idString);


    List<Object> objects = new ArrayList<Object>();

    objects.add(world);
    if (level != null) objects.add(level);
    objects.add(home);
    if (id != null) objects.add(id);
    if (primary != null) objects.add(primary);
    if (secondary != null) objects.add(secondary);
    if (name != null) objects.add(name);
    return instantiate(npcClass,objects.toArray());



} catch (ClassNotFoundException ex) {throw new IllegalArgumentException(ex);}
  catch (RPGException ex) {throw new IllegalArgumentException(ex);}
}

}
