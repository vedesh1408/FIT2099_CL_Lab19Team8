package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.implementedActions.AttackAction;
import game.interfaces.Behaviour;
import game.enums.Status;

/**
 * The class is used to attack player automatically
 */
public class AttackBehaviour implements Behaviour {

    // TODO: develop and use it to attack the player automatically.

    /**
     * This method is used to get the action that is supposed to attack the player
     *
     * @param actor the Actor acting
     * @param map   the GameMap containing the Actor
     * @return an instants of action that determines attack direction and target
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        if (!map.contains(actor)) {
            return null;
        }
        for (Exit exit1 : here.getExits()) {
            Location destination = exit1.getDestination();
            Actor target = destination.getActor();
            if (destination.containsAnActor() && target.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                return new AttackAction(target, exit1.getName());
            }
        }

        return null;
    }
}
