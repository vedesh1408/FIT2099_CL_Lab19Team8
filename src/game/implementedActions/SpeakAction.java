package game.implementedActions;

import edu.monash.fit2099.engine.actors.*;
import edu.monash.fit2099.engine.items.Item;

import java.util.ArrayList;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Utils;
import game.enums.Status;


public class SpeakAction extends Action {

    private final Actor target;

    public SpeakAction(Actor target) {
        this.target = target;
    }

    /**
     * When player talks to toad, it can speak the following lines
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what the toad generates based on Player's inventory
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        ArrayList<String> lines = new ArrayList<String>();
        lines.add("The Princess is depending on you! You are our only hope.");
        lines.add("Being imprisoned in these walls can drive a fungus crazy :(");
        lines.add("You might need a wrench to smash Koopa's hard shells.");
        lines.add("You better get back to finding the Power Stars.");
        lines.add("You may stumble upon a key that unlocks that mysterious door.");

        for (Item item: actor.getInventory()) {
            if (item.toString() == "Power Star" || actor.hasCapability(Status.INVINCIBILITY)) {
                lines.remove(3);
            }
            else if (item.toString() == "Wrench") {
                lines.remove(2);
            }
            else if (item.toString() == "Secret Key" || actor.hasCapability(Status.HAS_KEY)) {
                lines.remove(4);
            }
        }
        int rand = Utils.ranNum(lines.size());
        return lines.get(rand);
    }


    /**
     * This action that is going to be spoken
     *
     * @param actor the name of actor
     * @return an empty string
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " talks with " + target;
    }
}




// int choice = Utils.ranNum(4);
// for (int i = 0; i < actor.getInventory().size(); i++) {
//     if (actor.getInventory().get(i).toString().equals("Wrench") && actor.getInventory().get(i).toString().equals("Power Star")) {
//         return switch (choice) {
//             case 0 -> "The Princess is depending on you! You are our only hope.";
//             default -> "Being imprisoned in these walls can drive a fungus crazy :(";
//         };

//     } else if (actor.getInventory().get(i).toString().equals("Power Star")) {

//         return switch (choice) {
//             case 0 -> "You might need a wrench to smash Koopa's hard shells.";
//             case 1 -> "The Princess is depending on you! You are our only hope.";
//             default -> "Being imprisoned in these walls can drive a fungus crazy :(";
//         };
//     } else if (actor.getInventory().get(i).toString().equals("Wrench")) {

//         return switch (choice) {
//             case 0 -> "You better get back to finding the Power Stars.";
//             case 1 -> "The Princess is depending on you! You are our only hope.";
//             default -> "Being imprisoned in these walls can drive a fungus crazy :(";

//         };
//     } else {
//         return switch (choice) {
//             case 0 -> "You might need a wrench to smash Koopa's hard shells.";
//             case 1 -> "You better get back to finding the Power Stars.";
//             case 2 -> "The Princess is depending on you! You are our only hope.";
//             default -> "Being imprisoned in these walls can drive a fungus crazy :(";
//         };
//     }
// }
// return "Being imprisoned in these walls can drive a fungus crazy :(";
// }