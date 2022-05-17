package game.implementedactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.grounds.WarpPipe;
import game.maps.Map;

public class TeleportAction extends Action {

    private Location teleportToLocation;
    private Location teleportFromLocation;
    private Map mapTo;
    private Map mapFrom;

    public TeleportAction(Map mapFrom, Map mapTo, Location locationFrom, Location locationTo) {
        this.teleportToLocation = locationTo;
        this.teleportFromLocation = locationFrom;
        this.mapTo = mapTo;
        this.mapFrom = mapFrom;
    }

    @Override
    public String execute(Actor actor, GameMap gMap) {
        gMap.moveActor(actor, teleportToLocation);
        if (this.mapTo.menuName() == "Lava Zone") {
            teleportToLocation.setGround(new WarpPipe(mapTo, mapFrom, teleportFromLocation, teleportToLocation));
        }
        // teleportToLocation.setGround(new WarpPipe(mapTo, mapFrom, teleportToLocation, teleportFromLocation));
        return actor + " teleports to " + mapTo.menuName();
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Teleport to " + mapTo.menuName();
    }
}
