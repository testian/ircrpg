/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.persistence;

import ircrpg2.core.Locality;
import ircrpg2.core.RPGException;
import ircrpg2.core.World;
import ircrpg2.entities.common.DefaultLocality;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author testi
 */
public class LocalityFactory {
public static DefaultLocality instantiate(Class<? extends DefaultLocality> localityClass, Object... parameters) {
    Class[] parameterClasses = new Class[parameters.length];
    System.out.print("Searching constructor: " + localityClass.getName() + "(");
    for (int i = 0; i < parameters.length; i++) {
    parameterClasses[i] = parameters[i].getClass();
    if (parameterClasses[i] == Integer.class) {
    parameterClasses[i] = int.class;
    }
    System.out.print(parameterClasses[i].getName() + ";");
    }
    System.out.println(")");
    try {
    Constructor<? extends DefaultLocality> constructor = getConstructor(localityClass,parameterClasses);
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
public static DefaultLocality instantiate(Map<String, String> parameters, Locality reference) {
//(World world, int level,DefaultLocality home, Weapon primary, Weapon secondary, String name)
try {
    Class<? extends DefaultLocality> npcClass = (Class <? extends DefaultLocality>)Class.forName(parameters.get("class"));

    /*String referenceString = parameters.get("reference");
    Locality reference = null;
    if (referenceString != null) {
    try {
    reference = world.getLibrary().getLocality(referenceString);
    } catch (RPGException ex) {
    reference = references.get(referenceString);
    }
    if (reference == null) {throw new IllegalArgumentException("reference " + referenceString + " could not be found.");}
    }*/
    String name = parameters.get("name");


    /*String w1String = parameters.get("weapon1");
    Weapon primary = null;
    if (w1String != null) {
    primary = (Weapon)ItemFactory.instantiate((Class<? extends Item>)Class.forName(w1String));
    }

    String w2String = parameters.get("weapon2");
    Weapon secondary = null;
    if (w2String != null) {
    secondary = (Weapon)ItemFactory.instantiate((Class<? extends Item>)Class.forName(w1String));
    }*/



    /*
    Integer level = null;
    String levelString = parameters.get("level");
    if (levelString != null)
    level = Integer.parseInt(levelString);
    
    
    Integer id = null;
    String idString = parameters.get("id");
    if (idString != null)
    id = Integer.parseInt(idString);
    */

    List<Object> objects = new ArrayList<Object>();

    if (name != null) objects.add(name);
    if (reference != null) objects.add(reference);


    //if (level != null) objects.add(level);
    //objects.add(home);
    return instantiate(npcClass,objects.toArray());



} catch (ClassNotFoundException ex) {throw new IllegalArgumentException(ex);}
}

}
