package game.implemetedItems;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.implementedActions.CollectCoinAction;
import game.implementedActions.ResetAction;
import game.interfaces.Resettable;

public class ResetItem extends Item {

    public ResetItem() {
        super("Reset", 'r', false);
        addAction(new ResetAction(this));
    }
}
