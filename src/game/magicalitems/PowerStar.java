package game.magicalitems;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;

public class PowerStar extends Item {
    public int powerStarCount;
    public PowerStar(){
        super("Power Star", '*', true);
        powerStarCount = 0;
    }

    @Override
    public void tick(Location currentLocation) {
        super.tick(currentLocation);
        powerStarCount++;
        if (powerStarCount>9){
            currentLocation.removeItem(this);
        }
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        super.tick(currentLocation, actor);
        powerStarCount++;
        if (powerStarCount>9){
            currentLocation.removeItem(this);
        }
    }
}

