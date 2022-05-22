package game.implementedactions;


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
    protected Actor actor;

    public KilledAction(Actor actor) {
        this.actor = actor;
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
        map.at(map.locationOf(this.actor).x(), map.locationOf(this.actor).y()).addItem(new SuperMushroom());
        map.removeActor(this.actor);
        return this.actor + " is killed.";
    }

    /**
     * This action will not be shown in the menu.
     *
     * @param actor the name of actor
     * @return an empty string
     */
    @Override
    public String menuDescription(Actor actor) {
        if (this.actor.hasCapability(Status.DORMANT)) {
            return "Mario destroys Koopa's Shell";
        }
        return "";
    }
}
