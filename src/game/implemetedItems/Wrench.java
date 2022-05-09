package game.implemetedItems;

import edu.monash.fit2099.engine.items.Item;
import game.enums.Status;
import game.interfaces.BuyableItem;

/**
 * Class for wrench to kill koopa
 */
public class Wrench extends Item implements BuyableItem {
    /**
     * Constructor
     */
    public Wrench() {
        super("Wrench", 'w', true);
        this.addCapability(Status.KILL_KOOPA);

    }

    /**
     * Return price of wrench
     *
     * @return price of wrench
     */
    public int getPrice() {
        return 200;
    }


}
