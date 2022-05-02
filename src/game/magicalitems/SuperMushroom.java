package game.magicalitems;

import edu.monash.fit2099.engine.items.Item;
import game.enums.Status;
import game.interfaces.BuyableItem;

public class SuperMushroom extends Item implements BuyableItem {

    public SuperMushroom(){
        super("Super Mushroom",'^',true);
    }

    public int getPrice(){
        return 400;
    }
}
