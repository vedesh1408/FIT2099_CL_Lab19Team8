package game;

import edu.monash.fit2099.engine.positions.Ground;

public abstract class Tree extends Ground {

    // Integer to track tree's lifetime, used by all tree sub-types, and incremented in tick function.
    Integer treeLifetime;

    /**
     * Constructor.;
     *
     */
    public Tree(char displayChar) {
        super(displayChar);
        treeLifetime = 0;
    }

    // Spawning function to be overridden, used by all tree sub-types
    public void spawn() {}

}
