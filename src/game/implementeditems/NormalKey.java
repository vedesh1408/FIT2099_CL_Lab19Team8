package game.implementeditems;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.enums.Status;

public class NormalKey extends Item {

    public NormalKey() {
        super("Key", 'Q', true);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (actor.getInventory().contains(this)){
            actor.addCapability(Status.BOWSER_DEFEATED);
        }
    }
}
