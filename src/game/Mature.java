package game;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Koopa;

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
        if (super.treeLifetime%5==0) { growSprout(); }
        // every turn call wither function, spawn enemy function
        spawn(location);
        wither();
    }

    // Method to wither tree into dirt
    public void wither() {
        // 20% chance to actually wither
    }

    // Method to grow sprout (check if any free squares)
    public void growSprout() {

    }

    // Chance to Spawn enemy Koopa
    @Override
    public void spawn(Location location) {
        super.spawn(location);

        // if actor on ground, stops Koopa spawning ability
        if (!location.containsAnActor()) {
            // 15% chance to actually spawn the koopa
            if (Utils.ranNum(100)<=15) {
                // Spawn Koopa
                location.addActor(new Koopa());
            }
        }
    }
}
