package game.implementedActions;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class KilledAction extends Action {

    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        return actor + " is killed.";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "";
    }
}
