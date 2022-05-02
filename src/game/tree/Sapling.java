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
    public Sapling() {
        super("Sapling", 't', 80,20);
        this.registerInstance();
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
        location.setGround(new Mature());
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
            location.addItem(new Coin(20));
        }
    }

    /**
     * Method to turn mature into dirt
     *
     * @param location location of mature
     */
    @Override
    public void resetInstance(Location location) {
        Random rand = new Random();
        double chance = rand.nextDouble();
        if (chance <= 0.5) {
            location.setGround(new Dirt());
        }
    }

    /**
     * Method to check if mature is permanent
     *
     * @return boolean to check if mature is permanent
     */
    @Override
    public boolean isPermanent() {
        return false;
    }
}
