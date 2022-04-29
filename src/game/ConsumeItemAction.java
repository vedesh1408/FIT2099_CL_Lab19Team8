package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.items.*;

/**
 * Action to allow items to be consumed.
 */
public class ConsumeItemAction extends Action {

	private final Item item;

	/**
	 * Constructor.
	 *
	 * @param item the item to consume
	 */
	public ConsumeItemAction(Item item) {
		this.item = item;
	}

	/**
	 * Add the item to the actor's inventory.
	 *
	 * @see Action#execute(Actor, GameMap)
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return a suitable description to display in the UI
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		actor.removeItemFromInventory(item);
		return menuDescription(actor);
	}

	/**
	 * Describe the action in a format suitable for displaying in the menu.
	 *
	 * @see Action#menuDescription(Actor)
	 * @param actor The actor performing the action.
	 * @return a string, e.g. "Player picks up the rock"
	 */
	@Override
	public String menuDescription(Actor actor) {
		return actor + " consumes the " + item;
	}
}
