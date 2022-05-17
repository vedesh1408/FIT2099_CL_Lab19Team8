package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enums.Status;
import game.implementedActions.EnterDoorAction;

public class OpenDoor extends Ground{

    Location destination;

    public OpenDoor(Location destination) {
        super('[');
        this.destination = destination;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList list = new ActionList();
        list.add(new EnterDoorAction(this.destination));
        return list;
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }
}
