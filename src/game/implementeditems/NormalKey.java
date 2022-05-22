package game.implementeditems;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.enums.Status;

public class NormalKey extends Item {

    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
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
