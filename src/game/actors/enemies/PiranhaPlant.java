package game.actors.enemies;

import game.behaviours.AttackBehaviour;
import game.enums.Status;
import game.implementedactions.AttackAction;
import game.implementedactions.KilledAction;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.interfaces.Resettable;
import game.interfaces.Behaviour;

/**
 * Class for our Piranha Plant enemy.
 */
public class PiranhaPlant extends Actor implements Resettable {
    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour
    private Random rand = new Random();

    /**
     * Constructor for piranha plant
     */
    public PiranhaPlant(){
        super("Piranha Plant", 'Y', 150);
        this.registerInstance();
        this.behaviours.put(1, new AttackBehaviour());
        this.addCapability(Status.HOSTILE_TO_PLAYER);
    }
    /**
     * It returns the default weapon type of Piranha Plant along with its verb.
     *
     * @return it returns an instance of instrinsic weapon
     */
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(90, "chomps");
    }

    @Override
    public boolean isPermanent() {
        return false;
    }
    /**
     * When called, it removes the actor from the map
     */
    @Override
    public void resetInstance(GameMap map) {
        // Increasing max hp by 50 and healing to maximum.
        this.increaseMaxHp(50);
        this.heal(this.getMaxHp());
    }
    /**
     * Figure out what to do next.
     *
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        //determine if killed
        if (!this.isConscious()) {
            return new KilledAction(this);
            }
        // Get next action to perform.
        for (Behaviour Behaviour : behaviours.values()) {
            Action action = Behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        // Otherwise the plant does nothing.
        return new DoNothingAction();
    }
    /**
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
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this, direction));
        }
        // attack player 50% hit rate
        if (rand.nextInt(100) <= 50) {
            if (this.hasCapability(Status.HOSTILE_TO_PLAYER)) {
                actions.add(new AttackAction(otherActor, direction));
            }
        }
        return actions;
    }
}
