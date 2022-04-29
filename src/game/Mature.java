package game;

import edu.monash.fit2099.engine.positions.Location;

public class Mature extends Tree {

    /**
     * Constructor.
     *
     */
    public Mature() {
        super('T');
    }

    @Override
    public void tick(Location location) {
        // increment manual timer to track 10 turns to grow
        // every 5 turns call grow sprout method
        // every turn call wither function, spawn enemy function
    }

    // Method to wither tree into dirt
        // 20% chance to actually wither

    // Method to grow sprout (check if any free squares)

    // Spawn enemy function
        // 15% chance to actually spawn the koopa
        // If actor on ground, stops spawning ability
}
