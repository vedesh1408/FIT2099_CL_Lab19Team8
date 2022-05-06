package game.tree;

import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.Exit;
import game.Dirt;
import game.Utils;
import game.actors.enemies.Koopa;
import game.enums.Status;

import java.util.*;
import java.util.Random;

/**
 * Class to represent a mature tree
 */
public class Mature extends Tree {

    /**
     * Constructor.
     */
    public Mature(int xCoord, int yCoord) {
        super("Mature", 'T', 70,30, xCoord, yCoord);
    }

    /**
     * Method to check how many turns mature has existed
     *
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        super.treeLifetime++;
        // every 5 turns call grow sprout method
        if (super.treeLifetime % 5 == 0) {
            growSprout(location);
        }
        // every turn call wither function, spawn enemy Koopa function
        spawn(location);
        wither(location);
    }

    /**
     * Method to make tree wither into dirt
     *
     * @param location location of mature tree
     */
    // Method to wither tree into dirt
    public void wither(Location location) {
        // 20% chance to actually wither
        if (Utils.ranNum(5) == 0) {
            // Wither tree into dirt
            location.setGround(new Dirt());
        }
    }

    /**
     * Method to grow sprout
     *
     * @param location location of mature
     */
    // Method to grow sprout
    public void growSprout(Location location) {
        // Get all possible exits from this tree (ie all nearby squares)
        List<Exit> myExits = new ArrayList<>(location.getExits());
        // Randomise order to exits, to make which square tree grows on randomly selected
        Collections.shuffle(myExits);
        for (Exit myExit : myExits) { // replaced basic for loop with java enhanced for loop upon suggestion
            // Check if the next (random) square is free
            if (myExit.getDestination().getGround().hasCapability(Status.FERTILE)) {
                int newX = myExit.getDestination().x();
                int newY = myExit.getDestination().y();
                // Grow a new sprout
                myExit.getDestination().setGround(new Sprout(newX, newY));
                break;
            }
        }
    }

    // Chance to Spawn enemy Koopa

    /**
     * Method to spawn koopa randomly
     *
     * @param location location of mature
     */
    @Override
    public void spawn(Location location) {
        super.spawn(location);
        // if actor on ground, stops Koopa spawning ability
        if (!location.containsAnActor()) {
            // 15% chance to actually spawn the koopa
            if (Utils.ranNum(20) < 3) {
                // Spawn Koopa
                location.addActor(new Koopa());
            }
        }
    }
}
