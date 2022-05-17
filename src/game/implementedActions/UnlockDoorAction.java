package game.implementedActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.grounds.OpenDoor;

public class UnlockDoorAction extends Action {

    private Location door;
    Location destination;

    /**
     * Constructor
     * @param door The location of this door
     * @param destination The location of where this door leads
     */
    public UnlockDoorAction(Location door, Location destination) {
        this.door = door;
        this.destination = destination;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        // Set the ground to the open door object
        this.door.setGround(new OpenDoor(this.destination));
        return this.menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " unlocks the door";
    }
}
