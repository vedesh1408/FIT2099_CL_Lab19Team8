package game.implementedActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Player;
import game.implemetedItems.Coin;

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
	 * Actor collects the coin from the ground.
	 *
	 * @see Action#execute(Actor, GameMap)
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return a suitable description to display in the UI
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		// Add coin value to player wallet (type-cast player to actor to call the changeWallet method)
		// This use of instanceof would be avoidable by using polymorphism, that is, by declaring the wallet methods
		// in the parent class Actor, however, we are forbidden from modifying the engine, so this is the alternative.
		// Essentially we tell the program that the player is a type of actor so that it can accept the child class's method call changeWallet()
		if (actor instanceof Player) ((Player)actor).changeWallet(coin.getValue());
		map.locationOf(actor).removeItem(coin);
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
