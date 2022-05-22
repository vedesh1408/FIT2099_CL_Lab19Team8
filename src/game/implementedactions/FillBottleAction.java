package game.implementedactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.magicalitems.Bottle;
import game.magicalitems.HealthWater;
import game.magicalitems.PowerWater;

/**
 * Class to fill up bottle
 */
public class FillBottleAction extends Action {
    /**
     * Perform a fill action towards the target.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description to show if the jump is successfully performed by an actor
     * towards his target.
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        if (map.at(map.locationOf(actor).x(),map.locationOf(actor).y()).getGround().getDisplayChar() == 'H'){
            Item fountainWater = new HealthWater("Health water", 'w', true);
            Bottle.getBottle().push(fountainWater);
            return "Bottle is being filled with health water";
        }
        else if (map.at(map.locationOf(actor).x(),map.locationOf(actor).y()).getGround().getDisplayChar() == 'A'){
            Item fountainWater = new PowerWater("Power water", 'p', true);
            Bottle.getBottle().push(fountainWater);
            return "Bottle is being filled with power water";
        }
        return null;
    }
    /**
     * Returns a description of this movement suitable to display in the menu.
     *
     * @param actor The actor performing the action.
     * @return a String, e.g. "Player moves east"
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " fills up bottle" ;
    }
}
