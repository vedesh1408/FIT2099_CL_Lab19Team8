package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.enums.Status;
import game.implementedactions.KilledAction;
import game.implementeditems.NormalKey;
import game.interfaces.Behaviour;
import game.interfaces.Resettable;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * A big turtle guy
 * Enemy boss Bowser class
 */
public class Bowser extends Actor implements Resettable {
    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviou
    protected FollowBehaviour followBehaviour;
    private Random rand = new Random();
    /**
     * Constructor for Bowser
     */
    public Bowser() {
        super("Bowser", 'B', 500);
        this.addCapability(Status.HOSTILE_TO_PLAYER);
        this.behaviours.put(1, new AttackBehaviour());
        this.behaviours.put(3, new WanderBehaviour());
        this.registerInstance();

    }

    /**
     * Figure out what to do next.
     *
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // 10% change from being removed from map
        if (rand.nextInt(100) <= 10 && !this.hasCapability(Status.HOSTILE_TO_PLAYER)) {
            return new KilledAction(this);
        }
        //determine if killed
        if (!this.isConscious()) {
            map.removeActor(this);
        }
        else {
            for (Behaviour Behaviour : behaviours.values()) {
                Action action = Behaviour.getAction(this, map);
                if (action != null)
                    return action;
            }
        }
        return new DoNothingAction();
    }

    @Override
    public void resetInstance(GameMap map) {
        map.removeActor(this);
    }

    @Override
    public boolean isPermanent() {
        return false;
    }

    public String dead (Actor actor, GameMap map){
        map.locationOf(actor).addItem(new NormalKey());
        return "A key has been dropped";
    }
}
