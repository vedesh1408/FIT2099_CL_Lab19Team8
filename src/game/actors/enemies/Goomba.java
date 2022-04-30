package game.actors.enemies;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.AttackAction;
import game.KilledAction;
import game.interfaces.Behaviour;
import game.enums.Status;
import game.behaviours.WanderBehaviour;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * A little fungus guy.
 */
public class Goomba extends Actor {
	private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour
	private Random rand = new Random();
	/**
	 * Constructor.
	 */
	public Goomba() {
		// changed hit point to 20
		super("Goomba", 'g', 20);
		this.behaviours.put(10, new WanderBehaviour());
		this.hasCapability(Status.HOSTILE_TO_PLAYER);
	}
	@Override
	public IntrinsicWeapon getIntrinsicWeapon(){
		return new IntrinsicWeapon(10, "kicks");
	}

	/**
	 * At the moment, we only make it can be attacked by Player.
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
		}
		// attack player
		if (this.hasCapability(Status.HOSTILE_TO_PLAYER)){
			actions.add(new AttackAction(otherActor,direction));
		}
		return actions;
	}

	/**
	 * Figure out what to do next.
	 * @see Actor#playTurn(ActionList, Action, GameMap, Display)
	 */
	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// 10% change from being removed from map
		if (rand.nextInt(100)<=10){
			return new KilledAction();
		}
		//determine if killed
		if (!this.isConscious()){
			return new KilledAction();
		}
		for(Behaviour Behaviour : behaviours.values()) {
			Action action = Behaviour.getAction(this, map);
			if (action != null)
				return action;
		}
		return new DoNothingAction();
	}

}
