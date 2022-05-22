package game.actors.allies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.enums.Status;
import game.implementedactions.FreePeachAction;

/**
 * Class for the ally Princess Peach, who Mario must save!
 */
public class PrincessPeach extends Actor {

    /**
     * Constructor for Princess Peach
     */
    public PrincessPeach() {
        super("Princess Peach", 'P', 100);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList list = new ActionList();
        if (otherActor.hasCapability(Status.BOWSER_DEFEATED)){
            list.add(new FreePeachAction());
        }
        return list;
    }


}
