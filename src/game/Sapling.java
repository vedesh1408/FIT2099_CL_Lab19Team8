package game;

import edu.monash.fit2099.engine.positions.Location;
import game.interfaces.Growable;

public class Sapling extends Tree implements Growable {

    /**
     * Constructor.
     *
     */
    public Sapling() {
        super('t');
    }

    @Override
    public void tick(Location location) {
        super.treeLifetime++;
        // check if 10 turns have passed, if so call growable function
        if (super.treeLifetime==10) { grow(); }
        // call spawn coin function
        spawn();
    }

    // Implement growable function, check timer,
    @Override
    public void grow() {

    }

    // Method to spawn coin
    @Override
    public void spawn() {
        super.spawn();
        // 10% chance to actually spawn the coin
    }
}
