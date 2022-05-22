package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.implementedactions.OpenChestAction;

public class Chest extends Ground {

    Location chestLocation;

    /**
     * Constructor
     * @param chestLocation The location of this chest
     */
    public Chest(Location chestLocation) {
        super('=');
        this.chestLocation = chestLocation;
    }
    /**
     * Method to check if an actor can enter a floor
     *
     * @param actor the Actor to check
     * @return boolean to check if an actor can enter a floor
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        // No one can enter this ground
        return false;
    }
    /**
     * @param actor     the Actor that might perform an action.
     * @param direction String representing the direction of the other Actor
     * @param location  current location
     * @return list of actions
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList list = new ActionList();
        // Adding the open chest action to this chest
        list.add(new OpenChestAction(this.chestLocation));
        return list;
    }
}
