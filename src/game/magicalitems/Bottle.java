package game.magicalitems;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.implementedactions.ConsumeItemAction;

import java.util.Stack;

public class Bottle extends Item {

    public Bottle() {
        super("Bottle", 'b', false);
    }

    private static Stack <Item> bottle = new Stack<>();

    public static Stack <Item> getBottle() {
        return bottle;
    }

    @Override
    public void tick(Location currentLocation, Actor actor){
        if (!bottle.empty()){
            Item fountainWater = Bottle.getBottle().peek();
            this.addAction(new ConsumeItemAction(fountainWater));
        }
    }

}
