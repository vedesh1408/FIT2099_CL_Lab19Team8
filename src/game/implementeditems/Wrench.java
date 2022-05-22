package game.implementeditems;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.Location;
import game.enums.Status;
import game.interfaces.BuyableItem;
import game.magicalitems.PickUpMagicalItemAction;

/**
 * Class for wrench to kill koopa
 */
public class Wrench extends Item implements BuyableItem {
    /**
     * Constructor
     */
    public Wrench() {
        super("Wrench", 'w', true);
        this.addCapability(Status.KILL_KOOPA);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (actor.getInventory().contains(this)){
            actor.addCapability(Status.HAS_WRENCH);
        }
    }

    /**
     * Return price of wrench
     *
     * @return price of wrench
     */
    public int getPrice() {
        return 200;
    }


}
