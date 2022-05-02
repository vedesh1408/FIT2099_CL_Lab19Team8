package game.implementedActions;

import edu.monash.fit2099.engine.actors.*;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Utils;
import game.magicalitems.SuperMushroom;


public class SpeakAction extends Action {

    private final Actor target;

    public SpeakAction(Actor target) {
        this.target = target;
    }

    @Override
    public String execute(Actor actor, GameMap map) {

        int choice = Utils.ranNum(4);
        for (int i = 0; i < actor.getInventory().size(); i++) {
            if (actor.getInventory().get(i).toString().equals("Wrench") && actor.getInventory().get(i).toString().equals("Power Star")) {
                return switch (choice) {
                    case 0 -> "The Princess is depending on you! You are our only hope.";
                    default -> "Being imprisoned in these walls can drive a fungus crazy :(";
                };

            } else if (actor.getInventory().get(i).toString().equals("Power Star")) {

                return switch (choice) {
                    case 0 -> "You might need a wrench to smash Koopa's hard shells.";
                    case 1 -> "The Princess is depending on you! You are our only hope.";
                    default -> "Being imprisoned in these walls can drive a fungus crazy :(";
                };
            } else if (actor.getInventory().get(i).toString().equals("Wrench")) {

                return switch (choice) {
                    case 0 -> "You better get back to finding the Power Stars.";
                    case 1 -> "The Princess is depending on you! You are our only hope.";
                    default -> "Being imprisoned in these walls can drive a fungus crazy :(";

                };
            } else {
                return switch (choice) {
                    case 0 -> "You might need a wrench to smash Koopa's hard shells.";
                    case 1 -> "You better get back to finding the Power Stars.";
                    case 2 -> "The Princess is depending on you! You are our only hope.";
                    default -> "Being imprisoned in these walls can drive a fungus crazy :(";
                };
            }
        }
        return "Being imprisoned in these walls can drive a fungus crazy :(";
    }

        @Override
        public String menuDescription (Actor actor){
            return actor + " talks with " + target;
        }
    }
