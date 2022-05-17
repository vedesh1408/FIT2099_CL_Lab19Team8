package game.implementedactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class EnterDoorAction extends Action {
    Location destination;

    /**
     * Constructor
     * @param destination The location of where this door leads
     */
    public EnterDoorAction(Location destination) {
        this.destination = destination;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        // Move the actor to the destination
        map.moveActor(actor, this.destination);
        return this.menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " enters the door";
    }
}
