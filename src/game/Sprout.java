package game;

import java.util.Random;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Goomba;
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
        if (super.treeLifetime==10) { grow(location); }
        // every turn call spawn enemy goomba function
        spawn(location);
    }

    // Implement growable function
    @Override
    public void grow(Location location) {
        location.setGround(new Sapling());
    }

    // Chance to Spawn enemy Goomba
    @Override
    public void spawn(Location location) {
        super.spawn(location);
        // If there is an actor here, stops Goomba spawning ability
        if (!location.containsAnActor()) {
            // 10% chance to actually spawn Goomba
            if (Utils.ranNum(10)==0) {
                // Spawn Goomba
                location.addActor(new Goomba());
            }
        }
    }

    public void resetInstance(Location location) {
        Random rand = new Random();
        double chance = rand.nextDouble();
        if (chance <= 0.5) {
            location.setGround(new Dirt());
        }
    }

}
