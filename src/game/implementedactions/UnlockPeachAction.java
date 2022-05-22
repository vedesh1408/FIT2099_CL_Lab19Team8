package game.implementedactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;

public class UnlockPeachAction extends Action {

    @Override
    public String execute(Actor actor, GameMap map) {
        Display display = new Display();
        display.println(actor + " has set Peach free. Congratulationss");
        System.exit(0);
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " has set peach free";
    }
}
