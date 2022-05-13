package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.PiranhaPlant;
import game.implementedActions.JumpActorAction;
import game.implementedActions.TeleportAction;
import game.interfaces.Resettable;
import game.maps.Map;


/**
 * Class for the WarpPipe.
 */
public class WarpPipe extends Ground implements Resettable {

    // Initialising all relevant variables for the class

    ActionList actions = new ActionList();
    Map mapTo;
    Map mapAt;
    Location destinationTo;
    Location destinationFrom;
    boolean hasAction = false;
    int counter = 1;
    // This is the piranha plant associated with this warp pipe.
    PiranhaPlant piPlant = new PiranhaPlant();

    /**
     * Constructor for our warp pipe.
     * @param mapAt     The map that this warp pipe is on.
     * @param mapTo     The map this warp pipe teleports the player to.
     * @param destinationTo     The location the pipe teleports the player to.
     * @param destinationFrom       The location the pipe teleports the player from.
     */
    public WarpPipe(Map mapAt, Map mapTo, Location destinationTo, Location destinationFrom) {
        super('C');
        this.destinationTo = destinationTo;
        this.destinationFrom = destinationFrom;
        this.mapTo = mapTo;
        this.mapAt = mapAt;
        this.registerInstance();
    }

    /**
     * Tick method for our warp pipe.
     * This is used because we need to firstly add a piranha plant after the first turn.
     * And we need to check if the player is on the pipe to allow them to teleport. We need the tick
     * method for both of these.
     */

    @Override
    public void tick(Location location) {
        // Check if this isn't the warp pipe in the Lava Zone
        if (this.mapAt.menuName() != "Lava Zone") {
            // If not, we increment the counter until we add a piranha plant on the pipe.
            if (this.counter < 1) {
                counter++;
            }
            // If counter is 1, add the piranha plant
            else if (this.counter == 1) {
                location.addActor(this.piPlant);
                counter++;
            }
        }
    }
    /**
     * Our available actions method to return all available actions to this ground.
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList list = super.allowableActions(actor, location, direction);
        // Checking if the pipe has the player on it and that a teleport action hasn't already been added.
        if (location.containsAnActor() && !hasAction && location.getActor() != this.piPlant) {
            // If so, add a new teleport action available and set hasAction to true
            list.add(new TeleportAction(this.mapAt, this.mapTo, this.destinationFrom, this.destinationTo));
            this.hasAction = true;
        }
        // If there is an action there but no player, clear the list and reset.
        else if (this.hasAction) {
            list.clear();
            this.hasAction = false;
        }
        // If there is no actor on the pipe, add a jump action to it available.
        if (!location.containsAnActor()) {
            list.add(new JumpActorAction(this, "Warp Pipe", direction, 0, 100, location));
        }
        return list;
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        // Only piranha plants can enter this ground.
        return actor instanceof PiranhaPlant;
    }

    @Override
    public void resetInstance(GameMap map) {
        // Getting x and y coordinates.
        int x = this.destinationFrom.x();
        int y = this.destinationFrom.y();
        // If there is no actor at the warp pipe, add a piranha plant.
        if (!map.at(x,y).containsAnActor()){
            map.at(x,y).addActor(this.piPlant);
        }
    }

    @Override
    public boolean isPermanent() {
        return true;
    }
}
