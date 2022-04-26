package edu.monash.fit2099.engine.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class JumpActorAction extends Action {

    /**
	 * Target location
	 */
	protected Location moveToLocation;
	/**
	 * One of the 8-d navigation
	 */
	protected String direction;
	/**
	 * Or the command key
	 */
	protected String hotKey;

    public JumpActorAction(Location location, String direction, String hotkey){

    }

    @Override
	public String execute(Actor actor, GameMap map) {
		map.moveActor(actor, moveToLocation);
		return menuDescription(actor);
    }

    /**
	 * Returns a description of this movement suitable to display in the menu.
	 *
	 * @param actor The actor performing the action.
	 * @return a String, e.g. "Player moves east"
	 */
	@Override
	public String menuDescription(Actor actor) {
		return actor + " jumps " + direction;
	}

	/**
	 * Returns this Action's hotkey.
	 *
	 * @return the hotkey
	 */
	@Override
	public String hotkey() {
		return hotKey;
    }
}
