package game.implemetedItems;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.implementedActions.CollectCoinAction;
import game.interfaces.Resettable;

public class Coin extends Item implements Resettable {

    private Integer value;

    public Coin(Integer value) {
        super("Coin", '$', false);
        this.value = value;
        addAction(new CollectCoinAction(this));
    }

    public Integer getValue() { return value; }

    @Override
    public void resetInstance(GameMap map) {
    }

    @Override
    public boolean isPermanent() { return false; }
}
