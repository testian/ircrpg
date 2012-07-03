/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;

/**
 *
 * @author testi
 */
public class ItemFactory {
public static String itemName(Class<? extends Item> itemClass) {
return instantiate(itemClass).getName();
}
public static Item instantiate(Class<? extends Item> itemClass) {
    try {
    return itemClass.newInstance();
    } catch (InstantiationException ex) {
    throw new IllegalArgumentException(ex);
    } catch (IllegalAccessException ex) {throw new IllegalArgumentException(ex);}

}
private Class<? extends Item> ic;
private String name;

    public ItemFactory(Class<? extends Item> ic) {
        if (ic == null) throw new IllegalArgumentException("ic must not be null");
        try {
        name = itemName(ic);
        }
        catch (IllegalArgumentException ex) {
        throw new IllegalArgumentException("Class " + ic.getName() + "cannot be instantiated: " + ex.getMessage());
        }
        this.ic = ic;
    }
    public Item create() {
    return instantiate(ic);
    }
    public String name() {
    return name;
    }




}
