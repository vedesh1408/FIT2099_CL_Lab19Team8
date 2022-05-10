package game;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.PiranhaPlant;
import game.implementedActions.JumpActorAction;
import game.implementedActions.TeleportAction;
import game.interfaces.Resettable;
import game.maps.Map;

public class WarpPipe extends Ground implements Resettable {

    ActionList actions = new ActionList();
    Map mapTo;
    Map mapAt;
    Location destinationTo;
    Location destinationFrom;
    boolean hasAction = false;
    int counter = 1;
    PiranhaPlant piPlant = new PiranhaPlant();

    public WarpPipe(Map mapAt, Map mapTo, Location destinationTo, Location destinationFrom) {
        super('C');
        this.destinationTo = destinationTo;
        this.destinationFrom = destinationFrom;
        this.mapTo = mapTo;
        this.mapAt = mapAt;
        this.registerInstance();
    }

    @Override
    public void tick(Location location) {
        if (this.mapAt.menuName() != "Lava Zone") {
            if (this.counter < 1) {
                counter++;
            }
            else if (this.counter == 1) {
                location.addActor(this.piPlant);
                counter++;
            }
        }

        if (location.containsAnActor() && !hasAction && location.getActor() != this.piPlant) {
            actions.add(new TeleportAction(this.mapAt, this.mapTo, this.destinationFrom, this.destinationTo));
            this.hasAction = true;
        }
        else if (this.hasAction) {
            actions.clear();
            this.hasAction = false;
        }
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList list = super.allowableActions(actor, location, direction);
        list.add(actions);
        if (!location.containsAnActor()) {
            list.add(new JumpActorAction(this, "Warp Pipe", direction, 0, 100, location));
        }
        return list;
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return actor instanceof PiranhaPlant;
    }

    @Override
    public void resetInstance(GameMap map) {
        int x = this.destinationFrom.x();
        int y = this.destinationFrom.y();
        if (!map.at(x,y).containsAnActor()){
            map.at(x,y).addActor(this.piPlant);
        }
    }

    @Override
    public boolean isPermanent() {
        return true;
    }
}
