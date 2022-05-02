package game.tree;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Dirt;
import game.Utils;
import game.enums.Status;
import game.implementedActions.DestroyWallAction;
import game.implementedActions.JumpActorAction;
import game.interfaces.Resettable;

import java.util.Random;

/**
 * Abstract class for tree
 */
public abstract class Tree extends Ground implements Resettable {

    // Integer to track tree's lifetime, used by all tree sub-types, and incremented in tick function.
    protected Integer treeLifetime = 0;
    private String treeName;
    private int fallDamage;
    private int jumpRate;

    /**
     * Constructor.;
     */
    public Tree(String treeName,char displayChar, int jumpRate, int fallDamage) {
        super(displayChar);
        this.treeName=treeName;
        this. jumpRate = jumpRate;
        this. fallDamage = fallDamage;
        this.registerInstance();
    }

    /**
     * Spawning function to be overridden, used by all tree sub-types
     *
     * @param location location to spawn items
     */
    public void spawn(Location location) {
    }

    /**
     * @param actor     the Actor that might perform an action.
     * @param direction String representing the direction of the other Actor
     * @param location  current location
     * @return list of actions
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (actor.hasCapability(Status.TALL)) {
            actions.add(new JumpActorAction(this,treeName,direction,0,100,location));
        } else {
            if (!actor.hasCapability(Status.INVINCIBILITY)) {
                actions.add(new JumpActorAction(this, treeName, direction, fallDamage, jumpRate, location));
            } else {
                actions.add(new DestroyWallAction(this, location, treeName, direction));
            }
        }
        return actions;
    }

    /**
     * Method to turn Tree into dirt
     *
     * @param location location of Tree
     */
    @Override
    public void resetInstance(Location location) {
        if (Utils.ranNum(2) == 0) {
            location.setGround(new Dirt());
        }
    }

    /**
     * Method to check if Tree is permanent
     *
     * @return boolean to check if Tree is permanent
     */
    @Override
    public boolean isPermanent() {
        return false;
    }
}
