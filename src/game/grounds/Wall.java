package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enums.Status;
import game.implementedActions.DestroyWallAction;
import game.implementedActions.JumpActorAction;

/**
 * Class representing walls
 */
public class Wall extends Ground {

    int jumpRate;
    int fallDamage;
    /**
     * Constructor
     */
    public Wall() {
        super('#');
        this.jumpRate = 80;
        this.fallDamage=20;

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
            if (!location.containsAnActor()) {
                actions.add(new JumpActorAction(this, "Wall", direction, 0, 100, location));
            }
        } else {
            if (!actor.hasCapability(Status.INVINCIBILITY)) {
                if (!location.containsAnActor()) {
                    actions.add(new JumpActorAction(this, "Wall", direction, fallDamage, jumpRate, location));
                }
            } else {
                if (!location.containsAnActor()) {
                    actions.add(new DestroyWallAction(this, location, "Wall", direction));
                }
            }
        }
        return actions;
    }

    /**
     * Method to check if an actor can enter a floor
     *
     * @param actor the Actor to check
     * @return boolean to check if an actor can enter a floor
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }

    /**
     * Override this to implement terrain that blocks thrown objects but not movement, or vice versa
     *
     * @return true
     */
    @Override
    public boolean blocksThrownObjects() {
        return true;
    }
}
