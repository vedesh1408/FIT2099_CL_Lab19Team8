package game.implementedActions;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.enums.Status;
import game.magicalitems.SuperMushroom;

/**
 * An action that remove an actor from map and show that the actor
 * is killed.
 */
public class KilledAction extends Action {
    protected Actor player;

    public KilledAction(Actor player) {
        this.player = player;
    }

    /**
     * Remove an actor from map and show that the actor is killed.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description to show that the actor is killed.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.at(map.locationOf(player).x(), map.locationOf(player).y()).addItem(new SuperMushroom());
        map.removeActor(player);
        return actor + " is killed.";
    }

    /**
     * This action will not be shown in the menu.
     *
     * @param actor the name of actor
     * @return an empty string
     */
    @Override
    public String menuDescription(Actor actor) {
        if (player.hasCapability(Status.DORMANT)) {
            return actor + " destroys Koopa's Shell";
        }
        return "";
    }
}
