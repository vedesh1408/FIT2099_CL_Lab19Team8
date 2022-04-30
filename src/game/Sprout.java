package game;

import edu.monash.fit2099.engine.positions.Location;
import game.interfaces.Growable;

public class Sprout extends Tree implements Growable {

    /**
     * Constructor.
     *
     */
    public Sprout() {
        super('+');
    }

    @Override
    public void tick(Location location) {
        super.treeLifetime++;
        // check if 10 turns have passed, if so call growable function
        if (super.treeLifetime==10) { grow(); }
        spawn();
    }

    // Implement growable function, check timer,
    @Override
    public void grow() {

    }

    // Chance to Spawn enemy
    @Override
    public void spawn() {
        super.spawn();

        // if actor on ground
            // Stops spawning ability
        // 10% chance to actually spawn goomba
    }
}
