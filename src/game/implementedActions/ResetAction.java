package game.implementedActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ResetManager;

/**
 * An Action that resets the game.
 *
 *
 */
public class ResetAction extends Action {

	private Item item;

	/**
	 * Constructor
	 */
	public ResetAction(Item item) {
		this.item = item;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
        ResetManager.getInstance().run(map.locationOf(actor));
		actor.removeItemFromInventory(item);
        return menuDescription(actor);
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " resets";
	}

	@Override
	public String hotkey() {
		return "r";
	}
}
