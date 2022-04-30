package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actions.*;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Display;


public class Toad extends Actor {

    public Toad(){
        super("Toad",'0',420);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList list = super.allowableActions(otherActor, direction, map);
        list.add(new SpeakAction(this));
        return list;
    }
}
