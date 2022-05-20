package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.implementedactions.FillBottleAction;

public abstract class Fountains extends Ground {
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Fountains(char displayChar) {
        super(displayChar);
    }
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if(location.containsAnActor()) {
            actions.add(new FillBottleAction());
        }
        return actions;
    }
}
