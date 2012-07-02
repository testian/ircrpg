/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ircrpg2.core;
import ircrpg2.core.*;
import ircrpg2.entities.common.*;
import ircrpg2.entities.ilandor.items.*;
import ircrpg2.messaging.*;
import java.util.*;
/**
 *
 * @author testi
 */
public class DefaultPlayerFactory implements PlayerFactory {


    Locality defaultLocation;
    //Class<Weapon> defaultWeapon;
    World world;

    public DefaultPlayerFactory(World world, Locality defaultLocation) {
        this.defaultLocation = defaultLocation;
        //this.defaultWeapon = defaultWeapon;
        this.world = world;
    }



public RPGCharacter createPlayer(String name) throws RPGException {

RPGCharacter character = new CharacterCommon(world, 40, 40, 5, defaultLocation, new Dolch(), null, name, 0, 0, 0, CharacterState.ALIVE, new HashSet<Skill>(), new Position(defaultLocation),0,0);
attachPlayer(character);
return character;


}

    public void attachPlayer(RPGCharacter player) throws RPGException {
    CharacterEventListener messager = new CharacterEventMessager(world.getMessagingService().createPrivateMessageTarget(player.getName()),world.getPublicMessageTarget());
    player.addCharacterEventListener(messager);
    player.addCharacterEventListener(world.getGlobalListener());
    world.getLibrary().addPlayer(player);
    }


}