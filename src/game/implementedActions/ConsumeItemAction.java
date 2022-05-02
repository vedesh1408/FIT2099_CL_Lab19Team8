package game.implementedActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.items.*;
import game.enums.Status;

/**
 * Action to allow items to be consumed.
 */
public class ConsumeItemAction extends Action {

	private Item item;

	/**
	 * Constructor.
	 *
	 * @param item the item to consume
	 */
	public ConsumeItemAction(Item item) {
		this.item = item;
	}

	/**
	 * Consume the item from the actor's inventory.
	 *
	 * @see Action#execute(Actor, GameMap)
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return a suitable description to display in the UI
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		actor.removeItemFromInventory(item);
		if (item.toString().equals("Super Mushroom")){
			actor.addCapability(Status.TALL);
			return actor + " consumes the" + item;
		}
		else {
			actor.addCapability(Status.INVINCIBILITY);
			return actor + " is INVINCIBLE";
		}
	}

	/**
	 * Describe the action in a format suitable for displaying in the menu.
	 *
	 * @see Action#menuDescription(Actor)
	 * @param actor The actor performing the action.
	 * @return a string, e.g. "Player consumes the juice"
	 */
	@Override
	public String menuDescription(Actor actor) {
		return actor + " consumes the " + item;
	}
}
