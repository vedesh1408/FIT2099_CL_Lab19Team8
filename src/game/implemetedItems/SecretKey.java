package game.implemetedItems;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.enums.Status;

public class SecretKey extends Item {

    public SecretKey() {
        super("Secret Key",'!',true);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (actor.getInventory().contains(this)) {
            actor.addCapability(Status.HAS_KEY);
        }
        else if (!actor.hasCapability(Status.HAS_KEY)) {
            actor.removeCapability(Status.HAS_KEY);
        }
    }
}
