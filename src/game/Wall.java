package game;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enums.Status;
import game.implementedActions.DestroyWallAction;

/**
 * Class representing walls
 */
public class Wall extends Ground {

	double jumpRate;

	/**
	 * Constructor
	 */
	public Wall() {
		super('#');
		this.jumpRate = 0.8;

	}
	/**
	 * @param actor the Actor that might perform an action.
	 * @param direction  String representing the direction of the other Actor
	 * @param location        current location
	 * @return list of actions
	 */
	@Override
	public ActionList allowableActions(Actor actor, Location location, String direction) {
		ActionList actions = new ActionList();
		if (actor.hasCapability(Status.TALL)){
			//actions.add(new JumpActorAction(this,"Wall",direction,0,100,location));
		}
		else
		{
			if (!actor.hasCapability(Status.INVINCIBILITY)){
				//actions.add(new JumpActorAction(this, "Wall", direction, fallDamage, jumpRate, location));
			}
			else {
				actions.add(new DestroyWallAction(this,location,"Wall",direction));
			}
		}
		return actions;
	}
	/**
	 * Method to check if an actor can enter a floor
	 * @param actor the Actor to check
	 * @return boolean to check if an actor can enter a floor
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	/**
	 * Override this to implement terrain that blocks thrown objects but not movement, or vice versa
	 * @return true
	 */
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}
