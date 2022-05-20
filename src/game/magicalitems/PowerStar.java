package game.magicalitems;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.enums.Status;
import game.interfaces.BuyableItem;

/**
 * Class to represent power star
 */
public class PowerStar extends Item implements BuyableItem {
    public int powerStarCount;

    /**
     * Constructor
     */
    public PowerStar() {
        super("Power Star", '*', true);
        powerStarCount = 0;
        this.addCapability(Status.CONSUMABLE);
        this.addCapability(Status.MAGICAL_ITEMS);
    }

    /**
     * Method to check how may turns power star was in the game and remove it based on that
     */
    @Override
    public void tick(Location currentLocation) {
        super.tick(currentLocation);
        powerStarCount++;
        if (powerStarCount > 9) {
            currentLocation.removeItem(this);
        }
    }

    /**
     * Methd to check how may turns power star was in the game and remove it based on that
     *
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor           The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        super.tick(currentLocation, actor);
        powerStarCount++;
        if (powerStarCount > 9) {
            currentLocation.removeItem(this);
        }
    }

    /**
     * Get price of power star
     *
     * @return price of power star
     */
    public int getPrice() {
        return 600;
    }
}

