package game.implementedactions;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Utils;
import game.enums.Status;
import game.grounds.Dirt;
import game.implementeditems.Coin;
import game.magicalitems.PowerStar;
import game.magicalitems.SuperMushroom;

/**
 * An action that remove an actor from map and show that the actor
 * is killed.
 */
public class DestroyMBlockAction extends Action {

    Location blockLocation;


    /**
     * Constructor
     * @param blockLocation Location of the chest we are opening.
     */
    public DestroyMBlockAction(Location blockLocation) {
        this.blockLocation = blockLocation;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        // If the player does not have the wrench, exit the function with a different return message. Else continue through the function
        if (!actor.hasCapability(Status.HAS_WRENCH)) {
            return actor + " punched the block, but it did nothing! Maybe he can break it with a wrench...";
        }
        // Set the ground to dirt
        this.blockLocation.setGround(new Dirt());

        // Spawn item rewards from mystery block (chance)
        int itemRNG = Utils.ranNum(5);
        switch (itemRNG)
        {
            // Intentional withhold of breaks to trigger multiple outcomes.
            case 0:
                // 1/5 to get 1 of each item
                this.blockLocation.addItem(new PowerStar());
            case 1:
                // 1/5 to get 1 super mushroom
                this.blockLocation.addItem(new SuperMushroom());
                break;
            case 2:
                // 1/5 to get 2 super mushrooms
                this.blockLocation.addItem(new SuperMushroom());
                this.blockLocation.addItem(new SuperMushroom());
                break;
            case 3:
                // 1/5 to get 1 power star
                this.blockLocation.addItem(new PowerStar());
                break;
            default:
                // 1/5 to get no items (case 4)
        }

        // Spawn coin rewards from mystery block (chance for coin value)
        int coinRNG = Utils.ranNum(3);
        switch (coinRNG)
        {
            case 0 -> this.blockLocation.addItem(new Coin(20, blockLocation.x(), blockLocation.y()));
            case 1 -> this.blockLocation.addItem(new Coin(50, blockLocation.x(), blockLocation.y()));
            case 2 -> this.blockLocation.addItem(new Coin(100, blockLocation.x(), blockLocation.y()));
        }

        return this.menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " breaks open the mystery block!";
    }
}
