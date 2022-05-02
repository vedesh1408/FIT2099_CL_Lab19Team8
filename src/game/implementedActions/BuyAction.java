package game.implementedActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

public class BuyAction extends Action {
    private final Item target;
    int price;

    public BuyAction(Item target, int price) {
        this.target = target;
        this.price = price;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return "incomplete";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " buys " + target + " ($" + price + ")";
    }
}
