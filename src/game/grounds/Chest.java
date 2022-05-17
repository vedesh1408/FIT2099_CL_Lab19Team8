package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.implementedActions.OpenChestAction;

public class Chest extends Ground {

    Location chestLocation;

    public Chest(Location chestLocation) {
        super('=');
        this.chestLocation = chestLocation;
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList list = new ActionList();
        list.add(new OpenChestAction(this.chestLocation));
        return list;
    }
}
