package game.interfaces;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Interface that implements whether something can be grown
 */
public interface Growable {
    // Implement growable function, check timer,

    /**
     * Method to grow a thing
     * @param location - location whether the thing to be grown is
     */
    public void grow(Location location);

    /**
     * Method to reset growable
     * @param location Location of growable item
     */
    void resetInstance(Location location);
}
