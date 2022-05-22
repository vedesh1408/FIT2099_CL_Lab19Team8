package game.implementedactions;

import java.util.Random;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.enums.Status;

/**
 * Special Action for attacking other Actors.
 */
public class AttackAction extends Action {

    /**
     * The Actor that is to be attacked
     */
    protected Actor target;

    /**
     * The direction of incoming attack.
     */
    protected String direction;

    /**
     * Random number generator
     */
    protected Random rand = new Random();

    /**
     * Constructor.
     *
     * @param target the Actor to attack
     */
    public AttackAction(Actor target, String direction) {
        this.target = target;
        this.direction = direction;
    }

    /**
     * Perform an attack action towards the target.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description to show if the attack is successfully performed by an actor
     * towards his target.
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        Weapon weapon = actor.getWeapon();

        if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
            return actor + " misses " + target + ".";
        }

        int damage = weapon.damage();
        String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";

        if (target.hasCapability((Status.INVINCIBILITY))){
            target.hurt(0);
        }
        else if (target.hasCapability(Status.TALL)){
            target.removeCapability(Status.TALL);
            target.hurt(damage);
        }
        else {
            target.hurt(damage);
        }

        return result;
    }

    /**
     * Returns a descriptive string about this attack action.
     *
     * @param actor The actor performing the action.
     * @return the text to put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks " + target + " at " + direction;
    }
}
