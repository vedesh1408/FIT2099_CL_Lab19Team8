package game.grounds;

import java.util.ArrayList;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.implementedActions.TakeChestItemAction;
import game.magicalitems.PowerStar;
import game.magicalitems.SuperMushroom;

public class OpenChest extends Ground {

    ArrayList<Item> inventory = new ArrayList<Item>();

    public OpenChest() {
        super('-');
        this.inventory.add(new PowerStar());
        this.inventory.add(new SuperMushroom());
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList list = new ActionList();
        for (Item item: this.inventory) {
            list.add(new TakeChestItemAction(item, this.inventory));
        }
        return list;
    }
}
