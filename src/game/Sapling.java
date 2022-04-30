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
        // increment manual timer to track 10 turns to grow
        // check if 10 turns have passed, if so call growable function
        // call spawn coin function
    }

    // Implement growable function from interface

    // Method to spawn coin
        // 10% chance to actually spawn the coin
}
