package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enums.Status;
import game.implementedActions.UnlockDoorAction;

public class LockedDoor extends Ground{

    private Location doorLocation;
    Location destination;

    public LockedDoor(){
        super(']');
    }

    public LockedDoor(Location doorLocation, Location destination) {
        super(']');
        this.doorLocation = doorLocation;
        this.destination = destination;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList list = new ActionList();
        if (actor.hasCapability(Status.HAS_KEY)) {
            list.add(new UnlockDoorAction(this.doorLocation, this.destination));
        }
        return list;
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }
}
