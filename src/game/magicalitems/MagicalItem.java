package game.magicalitems;

import edu.monash.fit2099.engine.items.Item;

public abstract class MagicalItem extends Item {
    boolean consumable;

    public MagicalItem(String name, char displayChar, boolean portable, boolean consumable){
        super(name, displayChar, portable);
        this.consumable = consumable;
    }
}
