package game.implementedActions;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.enums.Status;
import game.magicalitems.SuperMushroom;

public class KilledAction extends Action {
    protected Actor player;
    public KilledAction(Actor player){
        this.player = player;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        map.at(map.locationOf(player).x(),map.locationOf(player).y()).addItem(new SuperMushroom());
        map.removeActor(player);
        return actor + " is killed.";
    }

    @Override
    public String menuDescription(Actor actor) {
        if (player.hasCapability(Status.DORMANT)){
            return actor + " destroys Koopa's Shell";
        }
        return "";
    }
}
