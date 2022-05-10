package game.actors.enemies;

import game.enums.Status;

import java.util.Random;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.implementedActions.AttackAction;
import game.implementedActions.KilledAction;
import game.interfaces.Resettable;

/**
 * Class for our Piranha Plant enemy.
 */
public class PiranhaPlant extends Actor implements Resettable {
    private Random rand = new Random();

    public PiranhaPlant(){
        super("Piranha Plant", 'Y', 150);
        this.registerInstance();
    }
    /**
     * It returns the default weapon type of Piranha Plant along with its verb.
     *
     * @return it returns an instance of instrinsic weapon
     */
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(50, "chomps");
    }

    @Override
    public boolean isPermanent() {
        return false;
    }

    @Override
    public void resetInstance(GameMap map) {
        // Increasing max hp by 50 and healing to maximum.
        this.increaseMaxHp(50);
        this.heal(this.getMaxHp());
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        //determine if killed
        if (!this.isConscious()) {
            return new KilledAction(this);
            }
        // Otherwise the plant does nothing.
        return new DoNothingAction();
    }

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
