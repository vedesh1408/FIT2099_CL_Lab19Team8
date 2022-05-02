package game.actors;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actions.*;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Display;
import game.implementedActions.BuyAction;
import game.implementedActions.SpeakAction;
import game.implemetedItems.Wrench;
import game.magicalitems.PowerStar;
import game.magicalitems.SuperMushroom;


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
        list.add(new BuyAction(new PowerStar(), new PowerStar().getPrice()));
        list.add(new BuyAction(new SuperMushroom(), new SuperMushroom().getPrice()));
        list.add(new BuyAction(new Wrench(), new Wrench().getPrice()));
        return list;
    }
}
