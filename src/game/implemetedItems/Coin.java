package game.implemetedItems;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.implementedActions.CollectCoinAction;
import game.interfaces.Resettable;

/**
 * Class representing currency used in game
 */
public class Coin extends Item implements Resettable {

    private Integer value;

    /***
     * Constructor
     * @param value currency value
     */
    public Coin(Integer value) {
        super("Coin", '$', false);
        this.value = value;
        addAction(new CollectCoinAction(this));
        this.registerInstance();
    }

    /**
     * Getter to get value of currency
     *
     * @return the value of the currency
     */
    public Integer getValue() {
        return value;
    }

    /**
     * When called, it removes the item from the map
     */
    @Override
    public void resetInstance(Location location) {
    }

    /**
     * It returns true or false based if the item needs to be made permanent or not
     */
    @Override
    public boolean isPermanent() {
        return false;
    }
}
