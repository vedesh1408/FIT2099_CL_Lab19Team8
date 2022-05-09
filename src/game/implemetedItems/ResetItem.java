package game.implemetedItems;

import edu.monash.fit2099.engine.items.Item;
import game.implementedActions.ResetAction;

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
