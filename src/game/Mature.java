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
        super.treeLifetime++;
        // every 5 turns call grow sprout method
        // every turn call wither function, spawn enemy function
        spawn();
        wither();
    }

    // Method to wither tree into dirt
    public void wither() {
        // 20% chance to actually wither
    }

    // Method to grow sprout (check if any free squares)
    public void growSprout() {

    }

    // Chance to Spawn enemy
    @Override
    public void spawn() {
        super.spawn();

        // if actor on ground
            // Stops spawning ability
        // 15% chance to actually spawn the koopa
    }
}
