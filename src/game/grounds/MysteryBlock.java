package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.implementedactions.OpenChestAction;

public class MysteryBlock extends Ground {

    Location chestLocation;

    /**
     * Constructor
     * @param chestLocation The location of this chest
     */
    public MysteryBlock(Location chestLocation) {
        super('=');
        this.chestLocation = chestLocation;
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        // No one can enter this ground
        return false;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList list = new ActionList();
        // Adding the open chest action to this chest
        list.add(new OpenChestAction(this.chestLocation));
        return list;
    }
}
