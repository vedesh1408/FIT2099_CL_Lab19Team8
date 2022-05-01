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
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.interfaces.Behaviour;
import game.enums.Status;
import game.behaviours.WanderBehaviour;
import game.magicalitems.SuperMushroom;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * A turtle guy
 */
public class Koopa extends Actor{
    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour
    private Random rand = new Random();
    protected FollowBehaviour followBehaviour;
    //constructor for koopa
    public Koopa() {
        super("Koopa", 'K', 10);
        this.behaviours.put(15, new WanderBehaviour());
        this.hasCapability(Status.HOSTILE_TO_PLAYER);
        this.behaviours.put(2,new AttackBehaviour());
    }
    public IntrinsicWeapon getIntrinsicWeapon(){
        return new IntrinsicWeapon(30, "punches");
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
        }

        //Actor kill dormant koopa
//        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY) && otherActor.getWeapon().){
//                this.addCapability(Status.DEAD);
//        }
        // attack player
        if (rand.nextInt(100) <= 50){
            if (this.hasCapability(Status.HOSTILE_TO_PLAYER)) {
                actions.add(new AttackAction(otherActor, direction));
            }
        }
        //follow player
        if (followBehaviour == null){
            followBehaviour = new FollowBehaviour(otherActor);
            this.behaviours.put(2,followBehaviour);
        }
        return actions;
    }
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // make koopa dormant
        if (!this.isConscious()){
            this.addCapability(Status.DORMANT);
            this.setDisplayChar('D');
        }

        if (this.hasCapability(Status.DEAD)){
            //create new super mushroom
            map.at(map.locationOf(this).x(),map.locationOf(this).y()).addItem(new SuperMushroom());
            //remove koopa from map
            return new KilledAction();
        }
        if (this.hasCapability(Status.DORMANT)){
            return new DoNothingAction();
        }
        for(Behaviour Behaviour : behaviours.values()) {
            Action action = Behaviour.getAction(this, map);
            if (action != null)
                return action;
        }

        return new DoNothingAction();
    }

}
