package game;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enums.Status;
import game.implementedActions.DestroyWallAction;
import game.implementedActions.JumpActorAction;

public class Wall extends Ground {

	double jumpRate;

	public Wall() {
		super('#');
		this.jumpRate = 0.8;

	}

	@Override
	public ActionList allowableActions(Actor actor, Location location, String direction) {
		ActionList actions = new ActionList();
		if (actor.hasCapability(Status.TALL)){
			//actions.add(new JumpActorAction(this,"Wall",direction,0,100,location));
		}
		else
		{
			if (!actor.hasCapability(Status.INVISIBILITY)){
				//actions.add(new JumpActorAction(this, "Wall", direction, fallDamage, jumpRate, location));
			}
			else {
				actions.add(new DestroyWallAction(this,location,"Wall",direction));
			}
		}
		return actions;
	}

	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}
