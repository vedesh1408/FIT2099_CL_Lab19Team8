package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.enums.Status;

/**
 * A class that represents the floor inside a building.
 */
public class Floor extends Ground{
	public Floor() {
		super('_');
	}
	public boolean canActorEnter(Actor actor){ return actor.hasCapability(Status.HOSTILE_TO_ENEMY);}
}
