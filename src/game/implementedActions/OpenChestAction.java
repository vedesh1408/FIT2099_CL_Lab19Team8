package game.implementedActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.grounds.OpenChest;

public class OpenChestAction extends Action {

    Location chestLocation;


    /**
     * Constructor
     * @param chestLocation Location of the chest we are opening.
     */
    public OpenChestAction(Location chestLocation) {
        this.chestLocation = chestLocation;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        // Set the ground to the open chest object
        this.chestLocation.setGround(new OpenChest());
        return this.menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " opens the chest";
    }
}
