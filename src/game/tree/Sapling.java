package game.tree;

import java.util.Random;

import edu.monash.fit2099.engine.positions.Location;
import game.Dirt;
import game.Utils;
import game.implemetedItems.Coin;
import game.interfaces.Growable;

/**
 * Class to represent sapling
 */
public class Sapling extends Tree implements Growable {

    /**
     * Constructor.
     */
    public Sapling(int xCoord, int yCoord) {
        super("Sapling", 't', 80,20, xCoord, yCoord);
    }

    /**
     * Method to check how many turns sapling has existed
     *
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        super.treeLifetime++;
        // check if 10 turns have passed, if so call growable function
        if (super.treeLifetime == 10) {
            grow(location);
        }
        // every turn call spawn coin function
        spawn(location);
    }

    // Implement growable function

    /**
     * Method to grow sapling into mature
     *
     * @param location - location whether the thing to be grown is
     */
    @Override
    public void grow(Location location) {
        location.setGround(new Mature(super.getX(), super.getY()));
    }

    // Method to spawn coin

    /**
     * Method to spawn coins
     *
     * @param location location whether the thing is
     */
    @Override
    public void spawn(Location location) {
        super.spawn(location);
        // 10% chance to actually spawn the coin
        if (Utils.ranNum(10) == 0) {
            // Spawn Coin
            location.addItem(new Coin(20, location.x(), location.y()));
        }
    }
}
