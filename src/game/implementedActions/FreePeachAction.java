package game.implementedactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class FreePeachAction extends Action {

    public FreePeachAction() {
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return "Mario freed Peach! Congratulations!";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Free Peach!";
    }
}
