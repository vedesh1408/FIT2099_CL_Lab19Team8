package game.implementedactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.magicalitems.Bottle;
import game.magicalitems.HealthWater;
import game.magicalitems.PowerWater;

public class FillBottleAction extends Action {

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

    @Override
    public String menuDescription(Actor actor) {
        return actor + " fills up bottle" ;
    }
}
