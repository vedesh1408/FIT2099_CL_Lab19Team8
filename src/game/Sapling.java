package game;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Koopa;
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
        // every turn call spawn coin function
        spawn(location);
    }

    // Implement growable function, check timer,
    @Override
    public void grow() {

    }

    // Method to spawn coin
    @Override
    public void spawn(Location location) {
        super.spawn(location);
        // 10% chance to actually spawn the coin
        if (Utils.ranNum(10)==1) {
            // Spawn Coin
            //location.addItem(new Coin(20)); UNCOMMENT THIS LINE ONCE COIN CLASS IS DONE
        }
    }
}
