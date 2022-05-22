package game.actors.allies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actions.*;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Display;
import game.implementedactions.BuyAction;
import game.implementedactions.SpeakAction;
import game.implementeditems.Wrench;
import game.magicalitems.PowerStar;
import game.magicalitems.SuperMushroom;

/**
 * Class representing the Toad.
 */
public class Toad extends Actor {
    /**
     * Constructor.
     */
    public Toad() {
        super("Toad", '0', 420);
    }

    /**
     * Figure out what to do next.
     *
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    /**
     * @param otherActor the Actor that might perform an action.
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return list of actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList list = super.allowableActions(otherActor, direction, map);
        list.add(new SpeakAction(this));
        list.add(new BuyAction(new PowerStar(), new PowerStar().getPrice()));
        list.add(new BuyAction(new SuperMushroom(), new SuperMushroom().getPrice()));
        list.add(new BuyAction(new Wrench(), new Wrench().getPrice()));
        return list;
    }
}
