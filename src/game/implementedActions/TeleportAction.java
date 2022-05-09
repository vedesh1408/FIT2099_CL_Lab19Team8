package game.implementedActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class TeleportAction extends Action {

    private Location target;
    private GameMap map;

    public TeleportAction(GameMap map, Location location) {
        this.target = location;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Teleport to " + map;
    }
}
