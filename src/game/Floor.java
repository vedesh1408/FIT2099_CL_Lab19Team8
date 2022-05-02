package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.enums.Status;

/**
 * A class that represents the floor inside a building.
 */
public class Floor extends Ground{
	/**
	 * Constructor
	 */
	public Floor() {
		super('_');
	}

	/**
	 * Method to check if an actor can enter a floor
	 * @param actor the Actor to check
	 * @return boolean to check if an actor can enter a floor
	 */
	public boolean canActorEnter(Actor actor){ return actor.hasCapability(Status.HOSTILE_TO_ENEMY);}
}
