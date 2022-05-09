package game.implementedActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.maps.Map;

public class TeleportAction extends Action {

    private Location teleportToLocation;
    private Map map;

    public TeleportAction(Map map, Location location) {
        this.teleportToLocation = location;
        this.map = map;
    }

    @Override
    public String execute(Actor actor, GameMap gMap) {
        gMap.moveActor(actor, teleportToLocation);
        return actor + " teleports to " + map.menuName();
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Teleport to " + map.menuName();
    }
}
