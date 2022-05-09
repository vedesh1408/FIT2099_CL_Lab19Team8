package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.implementedActions.JumpActorAction;

public class WarpPipe extends Ground {

    ActionList finalActions = new ActionList();
    ActionList actions = new ActionList();
    int jumpRate;
    int fallDamage;

    public WarpPipe() {
        super('C');
        this.jumpRate = 100;
        this.fallDamage = 0;
    }

    public void addAction(Action action) {
        actions.add(action);
    }

    @Override
    public void tick(Location location) {
        if (location.containsAnActor()) {
            finalActions.add(actions);
        }
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList list = super.allowableActions(actor, location, direction);
        list.add(finalActions);
        if (!location.containsAnActor()) {
            list.add(new JumpActorAction(this, "Warp Pipe", direction, this.fallDamage, this.jumpRate, location));
        }
        return list;
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }
}
