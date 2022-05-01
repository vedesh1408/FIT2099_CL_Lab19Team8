package game.implemetedItems;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.enums.Status;

public class Wrench extends Item {

    public Wrench() {
        super("Wrench", 'w', true);
        this.addCapability(Status.KILL_KOOPA);
        this.asWeapon();

    }


}
