package game.magicalitems;

import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class PickUpMagicalItemAction extends Action {

    private final Item item;

    /**
     * Constructor.
     *
     * @param item the item to pick up
     */
    public PickUpMagicalItemAction(Item item) {
        this.item = item;
    }

    /**
     * Add the item to the actor's inventory.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a suitable description to display in the UI
     * @see Action#execute(Actor, GameMap)
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        System.out.println("EXECUTE!!");
        map.locationOf(actor).removeItem(item);
        actor.addItemToInventory(item);
        return menuDescription(actor);
    }

    /**
     * Describe the action in a format suitable for displaying in the menu.
     *
     * @param actor The actor performing the action.
     * @return a string, e.g. "Player picks up the rock"
     * @see Action#menuDescription(Actor)
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " picks up the magical " + item;
    }
}
