package game.implementedActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ResetManager;

/**
 * An Action that doesn't do anything.
 *
 * Use this to implement waiting or similar actions in game clients.
 */
public class ResetAction extends Action {

	/**
	 * Constructor
	 */
	public ResetAction() {
	}

	@Override
	public String execute(Actor actor, GameMap map) {
        ResetManager reset = new ResetManager();
        reset.run(map.locationOf(actor));
        return menuDescription(actor);
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " resets";
	}

	@Override
	public String hotkey() {
		return "r";
	}
}
