package game;

import edu.monash.fit2099.engine.actors.*;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.positions.GameMap;


public class SpeakAction extends Action {

    private final Actor target;

    public SpeakAction(Actor target) {
        this.target = target;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        int choice = Utils.ranNum(4);
        return switch (choice) {
            case 0 -> "You might need a wrench to smash Koopa's hard shells.";
            case 1 -> "You better get back to finding the Power Stars.";
            case 2 -> "The Princess is depending on you! You are our only hope.";
            default -> "Being imprisoned in these walls can drive a fungus crazy :(";
        };
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " speaks to " + target;
    }
}
