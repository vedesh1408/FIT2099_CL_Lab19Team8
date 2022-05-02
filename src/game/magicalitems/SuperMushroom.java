package game.magicalitems;

import edu.monash.fit2099.engine.items.Item;
import game.enums.Status;
import game.interfaces.BuyableItem;

/**
 * Class representing super mushroom
 */
public class SuperMushroom extends Item implements BuyableItem {
    /**
     * Constructor
     */
    public SuperMushroom() {
        super("Super Mushroom", '^', true);
    }

    /**
     * Method to return price of mushroom
     *
     * @return price of mushroom
     */
    public int getPrice() {
        return 400;
    }
}
