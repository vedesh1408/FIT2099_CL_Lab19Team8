package game.implementedActions;

import game.actors.Player;
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
        /**
         * Just like the CollectCoinAction class, we have to use instanceof as we cannot edit the parent class Actor.
         * We tell the program that the actor is of Player type and then we can access the Player's wallet.
         */
        if (actor instanceof Player) {
            // Checking if the wallet has enough funds.
            if (((Player)actor).getWallet() >= price) {
                // If so, add the item to the inventory and update wallet.
                actor.addItemToInventory(target);
                // Toggle the portability as the items that are purchased cannot be dropped.
                target.togglePortability();
                ((Player)actor).changeWallet(-(price));
                return actor + " purchased " + target + " for " + price;
            }
            else {
                return "You don't have enough coins!";
            }
            }
        return "Only players can purchase items!";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " buys " + target + " ($" + price + ")";
    }
}
