package game.implementedActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.grounds.OpenDoor;

public class UnlockDoorAction extends Action {
    private Location door;
    Location destination;

    public UnlockDoorAction(Location door, Location destination) {
        this.door = door;
        this.destination = destination;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        this.door.setGround(new OpenDoor(this.destination));
        return this.menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " unlocks the door";
    }
}
