package game.implemetedItems;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;

import java.lang.Math;

public class SecretKey extends Item {

    int xPos;
    int yPos;

    public SecretKey(int xPos, int yPos) {
        super("Secret Key",'.',true);
        this.xPos = xPos;
        this.yPos = yPos;
    }


    public double getDistance(Location playerLocation) {
        // Returns the distance between the player and the secret key
        return Math.sqrt(Math.pow((playerLocation.x() - this.xPos),2) + Math.pow((playerLocation.y() - this.yPos),2));
    }

    @Override
    public void tick(Location currentLocation) {
        // Determining whether to show the key or not
        if (this.getDistance(currentLocation) <= 5) {
            // Set display character to the key, not dirt so that it shows.
            this.setDisplayChar('!');
        }
    }
}
