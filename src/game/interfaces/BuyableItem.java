package game.interfaces;

/**
 * Interface to check whether an item can be bought
 */
public interface BuyableItem {
    /**
     * Method that needs to be overriden to get price of item back
     *
     * @return integer that represents price of itme
     */
    public int getPrice();
}
