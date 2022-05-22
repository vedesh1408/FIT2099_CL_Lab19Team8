package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.interfaces.Behaviour;
import game.interfaces.Resettable;
import game.enums.Status;
import game.implementedactions.AttackAction;
import game.implementedactions.KilledAction;
import game.behaviours.WanderBehaviour;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * A turtle guy
 */
public class Koopa extends Actor implements Resettable {
    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour
    private Random rand = new Random();
    /**
     * Enemy has a follow behaviour to follow the player.
     */
    protected FollowBehaviour followBehaviour;
    //constructor for koopa

    /**
     * Constructor.
     */
    public Koopa() {
        super("Koopa", 'K', 5);
        this.behaviours.put(3, new WanderBehaviour());
        this.addCapability(Status.HOSTILE_TO_PLAYER);
        this.behaviours.put(1, new AttackBehaviour());
        this.registerInstance();
    }

    /**
     * It returns the default weapon type of Koopa along with its verb
     *
     * @return it returns an instance of instrinsic weapon
     */
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(30, "punches");
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
        if ((otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) && !(this.hasCapability(Status.DORMANT))) {
            actions.add(new AttackAction(this, direction));
        }

        //Actor kill dormant koopa
        if (this.hasCapability(Status.DORMANT) && otherActor.hasCapability(Status.HAS_WRENCH)) {
            actions.add(new KilledAction(this));
        }
        // attack player
        if (rand.nextInt(100) <= 50) {
            if (this.hasCapability(Status.HOSTILE_TO_PLAYER)) {
                if (otherActor.hasCapability(Status.TALL)) {
                    otherActor.removeCapability(Status.TALL);
                } else {
                    //actions.add(new AttackAction(otherActor, direction));
                }
            }
        }
        //follow player
        if (followBehaviour == null) {
            followBehaviour = new FollowBehaviour(otherActor);
            this.behaviours.put(2, followBehaviour);
        }
        return actions;
    }

    /**
     * Figure out what to do next.
     *
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // make koopa dormant
        if (!this.isConscious()) {
            this.addCapability(Status.DORMANT);
            this.setDisplayChar('D');
        }

        if (this.hasCapability(Status.DORMANT)) {
            return new DoNothingAction();
        }
        for (Behaviour Behaviour : behaviours.values()) {
            Action action = Behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * When called, it removes the actor from the map
     */
    @Override
    public void resetInstance(GameMap map) {
        map.removeActor(this);
    }

    /**
     * It returns true or false based if the item needs to be made permanent or not
     */
    @Override
    public boolean isPermanent() {
        return false;
    }
}
