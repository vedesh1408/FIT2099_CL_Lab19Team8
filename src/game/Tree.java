package game;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enums.Status;
import game.implementedActions.DestroyWallAction;

public abstract class Tree extends Ground {

    // Integer to track tree's lifetime, used by all tree sub-types, and incremented in tick function.
    protected Integer treeLifetime;
    private String treeName;
    /**
     * Constructor.;
     *
     */
    public Tree(char displayChar) {
        super(displayChar);
        treeLifetime = 0;
    }

    // Spawning function to be overridden, used by all tree sub-types
    public void spawn(Location location) {}

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (actor.hasCapability(Status.TALL)){
            //actions.add(new JumpActorAction(this,treeName,direction,0,100,location));
        }
        else
        {
            if (!actor.hasCapability(Status.INVISIBILITY)){
                //actions.add(new JumpActorAction(this, treeName, direction, fallDamage, jumpRate, location));
            }
            else {
                actions.add(new DestroyWallAction(this,location,treeName,direction));
            }
        }
        return actions;
    }
}
