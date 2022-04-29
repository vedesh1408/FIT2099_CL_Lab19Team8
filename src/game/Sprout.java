package game;

import edu.monash.fit2099.engine.positions.Location;

public class Sprout extends Tree implements Growable {

    // Timer attribute MOVE TO TREE


    /**
     * Constructor.
     *
     */
    public Sprout() {
        super('+');
        // start timer from 0 MOVE TO TREE
    }

    @Override
    public void tick(Location location) {
        // increment manual timer to track 10 turns to grow
        // check if 10 turns have passed, if so call growable function
    }

    // Implement growable function, check timer,

    // chance to Spawn enemy
        // actor on ground
        // Stops spawning ability
}
