package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.implementedActions.JumpActorAction;
import game.implementedActions.TeleportAction;
import game.maps.Map;

public class WarpPipe extends Ground {

    ActionList actions = new ActionList();
    Map mapTo;
    Map mapAt;
    Location destinationTo;
    Location destinationFrom;
    boolean hasAction = false;

    public WarpPipe(Map mapAt, Map mapTo, Location destinationTo, Location destinationFrom) {
        super('C');
        this.destinationTo = destinationTo;
        this.destinationFrom = destinationFrom;
        this.mapTo = mapTo;
        this.mapAt = mapAt;
    }

    @Override
    public void tick(Location location) {
        if (location.containsAnActor() && !hasAction) {
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
        return false;
    }
}
