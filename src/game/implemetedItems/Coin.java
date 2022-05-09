package game.implemetedItems;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.implementedActions.CollectCoinAction;
import game.interfaces.Resettable;

/**
 * Class representing currency used in game
 */
public class Coin extends Item implements Resettable {

    private Integer value;
    private int xCoord;
    private int yCoord;

    /***
     * Constructor
     * @param value currency value
     */
    public Coin(Integer value, int xCoord, int yCoord) {
        super("Coin", '$', false);
        this.value = value;
        addAction(new CollectCoinAction(this));
        this.xCoord = xCoord;
        this.yCoord = yCoord;
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
    public void resetInstance(GameMap map) {
        map.at(xCoord, yCoord).removeItem(this);
    }

    /**
     * It returns true or false based if the item needs to be made permanent or not
     */
    @Override
    public boolean isPermanent() {
        return false;
    }
}
