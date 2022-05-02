package edu.monash.fit2099.engine.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class JumpActorAction extends Action {

    /**
	 * Constructor
	 */
    public JumpActorAction() {
    }

    @Override
	public String execute(Actor actor, GameMap map) {
		return menuDescription(actor);
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " jumps to high ground!";
    }

}