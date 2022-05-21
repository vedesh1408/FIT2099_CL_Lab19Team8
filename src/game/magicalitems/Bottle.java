package game.magicalitems;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.implementedactions.ConsumeItemAction;

import java.util.Stack;

public class Bottle extends Item {
    private int numTurn = 0;
    public Bottle() {
        super("Bottle", 'b', false);
    }

    private static Stack <Item> bottle = new Stack<>();

    public static Stack <Item> getBottle() {
        return bottle;
    }

    @Override
    public void tick(Location currentLocation, Actor actor){
        Item fountainWater;
        if (!bottle.empty()){
            if (numTurn != 1) {
                fountainWater = Bottle.getBottle().peek();
                ConsumeItemAction consumeFountainWater = new ConsumeItemAction(fountainWater);
                this.addAction(consumeFountainWater);
                numTurn = 1;

            }
        }
        else {
            if (bottle.empty()){
                if (!this.getAllowableActions().isEmpty()){
                    this.removeAction(this.getAllowableActions().get(0));
                }
                numTurn = 0;
            }
        }
    }

}
