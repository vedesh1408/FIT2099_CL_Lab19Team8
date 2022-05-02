package game;

import java.util.Random;

import edu.monash.fit2099.engine.positions.Location;
import game.implemetedItems.Coin;
import game.interfaces.Growable;

public class Sapling extends Tree implements Growable {

    /**
     * Constructor.
     *
     */
    public Sapling() {
        super('t');
        this.registerInstance();
    }

    @Override
    public void tick(Location location) {
        super.treeLifetime++;
        // check if 10 turns have passed, if so call growable function
        if (super.treeLifetime==10) { grow(location); }
        // every turn call spawn coin function
        spawn(location);
    }

    // Implement growable function
    @Override
    public void grow(Location location) {
        location.setGround(new Mature());
    }

    // Method to spawn coin
    @Override
    public void spawn(Location location) {
        super.spawn(location);
        // 10% chance to actually spawn the coin
        if (Utils.ranNum(10)==0) {
            // Spawn Coin
            location.addItem(new Coin(20));
        }
    }

    @Override
    public void resetInstance(Location location) {
        Random rand = new Random();
        double chance = rand.nextDouble();
        if (chance <= 0.5) {
            location.setGround(new Dirt());
        }
    }

    @Override
    public boolean isPermanent() {
        return false;
    }
}
