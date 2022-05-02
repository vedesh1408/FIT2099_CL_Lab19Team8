package game.implemetedItems;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.enums.Status;
import game.interfaces.BuyableItem;

public class Wrench extends Item implements BuyableItem {

    public Wrench() {
        super("Wrench", 'w', true);
        this.addCapability(Status.KILL_KOOPA);

    }

    public int getPrice() {
        return 200;
    }


}
