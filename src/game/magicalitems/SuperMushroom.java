package game.magicalitems;

import edu.monash.fit2099.engine.items.Item;
import game.BuyableItem;
import game.enums.Status;

public class SuperMushroom extends Item implements BuyableItem {

    public SuperMushroom(){
        super("Super Mushroom",'^',true);
    }

    public int getPrice(){
        return 400;
    }
}
