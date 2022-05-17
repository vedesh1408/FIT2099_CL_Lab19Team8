package game.implementedActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.WalletManager;
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
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a suitable description to display in the UI
     * @see Action#execute(Actor, GameMap)
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        // Add coin value to player wallet
        WalletManager.getInstance().changeWallet(coin.getValue());
        map.locationOf(actor).removeItem(coin);
        return menuDescription(actor);
    }

    /**
     * Describe the action in a format suitable for displaying in the menu.
     *
     * @param actor The actor performing the action.
     * @return a string, e.g. " Player consumes the juice "
     * @see Action#menuDescription(Actor)
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " collects the " + coin;
    }
}
