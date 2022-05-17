package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enums.Status;
import game.implementedactions.UnlockDoorAction;

public class LockedDoor extends Ground{

    private Location doorLocation;
    Location destination;

    /**
     * Constructor
     */
    public LockedDoor(){
        super(']');
    }

    /**
     * Constructor
     * @param doorLocation The location of this door
     * @param destination Where this door leads
     */
    public LockedDoor(Location doorLocation, Location destination) {
        super(']');
        this.doorLocation = doorLocation;
        this.destination = destination;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList list = new ActionList();
        // If the actor has the key, add a new unlock door action
        if (actor.hasCapability(Status.HAS_KEY)) {
            list.add(new UnlockDoorAction(this.doorLocation, this.destination));
        }
        return list;
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        // No one can walk onto the same ground as the door
        return false;
    }
}
