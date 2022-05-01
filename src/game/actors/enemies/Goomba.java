package game.actors.enemies;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.implementedActions.AttackAction;
import game.implementedActions.KilledAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
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
	 * Enemy has a follow behaviour to follow the player.
	 */
	protected FollowBehaviour followBehaviour;

	/**
	 * Constructor.
	 */
	public Goomba() {
		super("Goomba", 'g', 10);
		this.behaviours.put(10, new WanderBehaviour());
		this.hasCapability(Status.HOSTILE_TO_PLAYER);
		this.behaviours.put(1,new AttackBehaviour());
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
		if (rand.nextInt(100)<=50 ) {
			if (this.hasCapability(Status.HOSTILE_TO_PLAYER)) {
				actions.add(new AttackAction(otherActor, direction));
			}
		}
		//follow player
		if (followBehaviour == null){
			followBehaviour = new FollowBehaviour(otherActor);
			this.behaviours.put(1,followBehaviour);
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
			return new KilledAction(this);
		}
		//determine if killed
		if (!this.isConscious()){
			return new KilledAction(this);
		}
		for(Behaviour Behaviour : behaviours.values()) {
			Action action = Behaviour.getAction(this, map);
			if (action != null)
				return action;
		}
		return new DoNothingAction();
	}

}
