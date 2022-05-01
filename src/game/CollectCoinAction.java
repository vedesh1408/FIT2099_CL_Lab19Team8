package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Action to allow coins to be collected.
 */
public class CollectCoinAction extends Action {

	private final Coin coin;

	/**
	 * Constructor.
	 *
	 * @param coin the coin to collect
	 */
	public CollectCoinAction(Coin coin) {
		this.coin = coin;
	}

	/**
	 * Consume the coin from the actor's inventory.
	 *
	 * @see Action#execute(Actor, GameMap)
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return a suitable description to display in the UI
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		map.locationOf(actor).removeItem(coin);
		// need to call method from player to add value to wallet here.
		return menuDescription(actor);
	}

	/**
	 * Describe the action in a format suitable for displaying in the menu.
	 *
	 * @see Action#menuDescription(Actor)
	 * @param actor The actor performing the action.
	 * @return a string, e.g. "Player consumes the juice"
	 */
	@Override
	public String menuDescription(Actor actor) { return actor + " collects the " + coin; }
}
