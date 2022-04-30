package game;

import edu.monash.fit2099.engine.actors.*;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.Random;


public class SpeakAction extends Action {

    private final Actor target;

    public SpeakAction(Actor target) {
        this.target = target;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String line1 = "You might need a wrench to smash Koopa's hard shells.";
        String line2 = "You better get back to finding the Power Stars.";
        String line3 = "The Princess is depending on you! You are our only hope.";
        String line4 = "Being imprisoned in these walls can drive a fungus crazy :(";
        Random rand = new Random();
        int choice = rand.nextInt(4) + 1;
        if (choice == 1){
            return line1;
        }
        else if (choice == 2){
            return line2;
        }
        else if (choice == 3) {
            return line3;
        }
        else {
            return line4;
        }

    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " speaks to " + target;
    }
}
