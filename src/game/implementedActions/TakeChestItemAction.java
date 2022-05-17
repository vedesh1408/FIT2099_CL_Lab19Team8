package game.implementedActions;

import java.util.ArrayList;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

public class TakeChestItemAction extends Action {

    private Item target;
    ArrayList<Item> inventory;


    /**
     * Constructor
     * @param target  The item to be taken by this action
     * @param inventory  The inventory of which we are taking items from
     */
    public TakeChestItemAction(Item target, ArrayList<Item> inventory) {
        this.target = target;
        this.inventory = inventory;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        // Add the item to the inventory
        actor.addItemToInventory(this.target);
        // Toggle portability because we can't drop these items
        this.target.togglePortability();
        // Remove the item from the inventory
        this.inventory.remove(target);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " takes " + this.target + " from the chest";
    }
}
