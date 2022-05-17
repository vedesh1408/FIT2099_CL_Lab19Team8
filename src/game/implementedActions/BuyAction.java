package game.implementedActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.WalletManager;

public class BuyAction extends Action {
    private final Item target;
    int price;

    /**
     * Constructor for BuyAction
     *
     * @param target represents an item
     * @param price  represents price of item
     */
    public BuyAction(Item target, int price) {
        this.target = target;
        this.price = price;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        /**
         * Executes a trade/purchase of an item
         *
         * @param actor the actor conducting the purchase
         * @param map the map that the purchase is taking place on
         * @return display whether the purchase was successful or not
         */
        // Checking if the wallet has enough funds.
        if (WalletManager.getInstance().getWallet() >= price) {
            // If so, continue with purchase
            // Add the item to the inventory.
            actor.addItemToInventory(target);
            // Toggle the portability as the items that are purchased cannot be dropped.
            target.togglePortability();
            // Update the wallet to reflect purchase cost
            WalletManager.getInstance().changeWallet(-(price));
            return actor + " purchased " + target + " for " + price;
        } else //if (WalletManager.getInstance().getWallet() < price)
        {
            return "You don't have enough coins!";
        }
    }

    /**
     * Returns a descriptive string about this buy action.
     *
     * @param actor The actor performing the action.
     * @return the text to put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " buys " + target + " ($" + price + ")";
    }
}
