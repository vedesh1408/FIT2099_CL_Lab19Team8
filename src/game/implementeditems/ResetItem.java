package game.implementeditems;

import edu.monash.fit2099.engine.items.Item;

/**
 * Class to reset the game, in the form of a special item in the inventory
 */
public class ResetItem extends Item {
    /**
     * constructor for the reset item
     */
    public ResetItem() {
        super("Reset", 'r', false);
    }
}
