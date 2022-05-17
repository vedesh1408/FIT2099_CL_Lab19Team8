package game.grounds;

import game.enums.Status;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

public class Lava extends Ground {
    /**
     * Constructor
     * Initialises Lava ground with display character L.
     */
    public Lava() {
        super('L');
    }

    @Override
    public void tick(Location location) {
        // Checks if an actor is on the lava
        if (location.containsAnActor()) {
            // If they are, we hurt them for 15 hp
            location.getActor().hurt(15);
            Display hurtOutP = new Display();
            hurtOutP.println("Lava burns " + location.getActor() + " for 15 hp");
        }
    }

    /**
     * Only the player can walk into lava
     * @param actor the actor
     * @return true if the actor is the player, false otherwise.
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
    }
}
