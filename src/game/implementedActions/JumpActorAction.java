package game.implementedActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

import java.util.Random;

/**
 * Class that allows the actor to jump
 */
public class JumpActorAction extends Action {

    // TODO Modify the class so that it is different from MoveActorAction
    protected Ground target;
    protected String name;
    protected int fall;
    protected int jumpRate;

    /**
     * Target location
     */
    protected Location moveToLocation;
    /**
     * One of the 8-d navigation
     */
    protected String direction;
    /**
     * Or the command key
     */
    protected String hotKey;
    protected Random rand = new Random();
    public JumpActorAction(Ground target, String name, String direction, int fall, int jumpRate, Location location) {
        this.target = target;
        this. name = name;
        this. direction = direction;
        this. fall = fall;
        this.jumpRate = jumpRate;
        this.moveToLocation = location;
    }

    /**
     * Perform an jump action towards the target.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description to show if the jump is successfully performed by an actor
     * towards his target.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
       if (!(rand.nextInt(100)<=jumpRate)){
           actor.hurt(fall);
           return actor + " misses " + name;
       }
       map.moveActor(actor,moveToLocation);
       return actor + " jumped and is on top of "+ name;
    }

    /**
     * Returns a description of this movement suitable to display in the menu.
     *
     * @param actor The actor performing the action.
     * @return a String, e.g. "Player moves east"
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " jumps to " + direction + " " + name;
    }

}
