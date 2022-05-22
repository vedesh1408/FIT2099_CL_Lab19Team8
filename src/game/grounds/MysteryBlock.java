package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enums.Status;
import game.implementedactions.DestroyMBlockAction;
import game.implementedactions.OpenChestAction;

/**
 * Class of the Mystery Block special ground, which the player can interact with
 */
public class MysteryBlock extends Ground {

    Location blockLocation;

    /**
     * Constructor for the mystery block ground
     * @param blockLocation The location of this chest
     */
    public MysteryBlock(Location blockLocation) {
        super('?');
        this.blockLocation = blockLocation;
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        // No one can enter this ground
        return false;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList list = new ActionList();
        // Adding the destroy mystery block action to this block
            list.add(new DestroyMBlockAction(this.blockLocation));
        return list;
    }
}
