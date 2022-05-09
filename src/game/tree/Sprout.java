package game.tree;

import edu.monash.fit2099.engine.positions.Location;
import game.Utils;
import game.actors.enemies.Goomba;
import game.interfaces.Growable;

public class Sprout extends Tree implements Growable {

    /**
     * Constructor.
     */
    public Sprout(int xCoord, int yCoord) {
        super("Sprout", '+', 90,10, xCoord, yCoord);

    }

    /**
     * Method to check how many turns sapling has existed
     *
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        super.treeLifetime++;
        // check if 10 turns have passed, if so call growable function
        if (super.treeLifetime == 10) {
            grow(location);
        }
        // every turn call spawn enemy goomba function
        spawn(location);
    }

    // Implement growable function

    /**
     * Method to grow sprout into sapling
     *
     * @param location - location whether the thing to be grown is
     */
    @Override
    public void grow(Location location) {
        location.setGround(new Sapling(super.getX(), super.getY()));
    }

    // Chance to Spawn enemy Goomba

    /**
     * Method to spawn goomba randomly
     *
     * @param location location of sprout
     */
    @Override
    public void spawn(Location location) {
        super.spawn(location);
        // If there is an actor here, stops Goomba spawning ability
        if (!location.containsAnActor()) {
            // 10% chance to actually spawn Goomba
            if (Utils.ranNum(10) == 0) {
                // Spawn Goomba
                location.addActor(new Goomba());
            }
        }
    }
}
