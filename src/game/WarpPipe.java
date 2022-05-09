package game;

import game.Application;
import game.implementedActions.TeleportAction;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

public class WarpPipe extends Ground {

    ActionList actions = new ActionList();

    public WarpPipe() {
        super('C');
    }

    public void addAction(Action action) {
        actions.add(action);
    }

    @Override
    public void tick(Location location) {
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList list = super.allowableActions(actor, location, direction);
        list.add(actions);
        return list;
    }
}
