package game.implementedActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Dirt;
import game.implemetedItems.Coin;

/**
 * Class that allows to destroy items when certain magical items are activated
 */
public class DestroyWallAction extends Action {
    private Ground targetDestroy;
    private Location locationDestroy;
    private String targetNameDestroy;
    private String direction;

    /**
     * Constructor
     *
     * @param target     The target to destroy
     * @param location   target location
     * @param targetName target name
     * @param direction  target direction from actor
     */
    public DestroyWallAction(Ground target, Location location, String targetName, String direction) {
        this.targetDestroy = target;
        this.locationDestroy = location;
        this.targetNameDestroy = targetName;
        this.direction = direction;
    }

    /**
     * Perform a destroy action towards the target.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description to show if the attack is successfully performed by an actor
     * towards his target.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.moveActor(actor, locationDestroy);
        Ground newDirt = new Dirt();
        locationDestroy.setGround(newDirt);
        locationDestroy.addItem(new Coin(5));
        return actor + " destroys " + targetNameDestroy;
    }

    /**
     * Returns a descriptive string about this destroy action.
     *
     * @param actor The actor performing the action.
     * @return the text to put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " move to the " + direction;
    }
}
