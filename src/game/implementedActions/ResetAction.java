package game.implementedActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ResetManager;

/**
 * An Action that resets the game.
 */
public class ResetAction extends Action {

    private Item item;

    /**
     * Constructor
     */
    public ResetAction(Item item) {
        this.item = item;
    }
    /**
     * When the actor dies, reset manager is run to execute RESET feature.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description to show if the player is killed or falls from valley, and show that
     * the world is resetting.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        ResetManager.getInstance().run(map.locationOf(actor));
        actor.removeItemFromInventory(item);
        return menuDescription(actor);
    }

    /**
     * This action will not be shown in the menu.
     *
     * @param actor the name of actor
     * @return an empty string
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " resets";
    }

    /**
     * Returns this Action's hotkey.
     *
     * @return the hotkey
     */
    @Override
    public String hotkey() {
        return "r";
    }
}
