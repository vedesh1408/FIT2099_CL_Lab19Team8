package game.actors.enemies;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.AttackAction;
import game.KilledAction;
import game.interfaces.Behaviour;
import game.Status;
import game.behaviours.WanderBehaviour;

import java.util.HashMap;
import java.util.Map;

/**
 * A turtle guy
 */
public class Koopa extends Actor{
    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour
    //constructor for koopa
    public Koopa() {
        super("Koopa", 'k', 100);
        this.behaviours.put(15, new WanderBehaviour()); // need to confirm this
    }
    /**
     * At the moment, we only make it be attacked by Player.
     * You can do something else with this method.
     * @param otherActor the Actor that might perform an action.
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return list of actions
     * @see Status#HOSTILE_TO_ENEMY
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        // it can be attacked only by the HOSTILE opponent, and this action will not attack the HOSTILE enemy back.
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this,direction));
            // method that allows the koopa to attack the player back
        }
        return actions;
    }
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        if (!this.isConscious()){

        }
        for(Behaviour Behaviour : behaviours.values()) {
            Action action = Behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }

}
