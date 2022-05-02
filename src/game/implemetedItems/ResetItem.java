package game.implemetedItems;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.implementedActions.CollectCoinAction;
import game.implementedActions.ResetAction;
import game.interfaces.Resettable;

/**
 * Class to reset item
 */
public class ResetItem extends Item {
    /**
     * constructor
     */
    public ResetItem() {
        super("Reset", 'r', false);
        addAction(new ResetAction(this));
    }
}
