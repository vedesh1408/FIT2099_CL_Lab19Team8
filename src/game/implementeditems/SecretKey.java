package game.implementeditems;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.enums.Status;
/**
 * Class of the secret key item, which is used to access the treasure room.
 */
public class SecretKey extends Item {

    public SecretKey() {
        super("Secret Key",'!',true);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (actor.getInventory().contains(this)) {
            actor.addCapability(Status.TREASURE_KEY);
        }
        else if (!actor.hasCapability(Status.TREASURE_KEY)) {
            actor.removeCapability(Status.TREASURE_KEY);
        }
    }
}
