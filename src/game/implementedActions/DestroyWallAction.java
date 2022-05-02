package game.implementedActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Dirt;
import game.implemetedItems.Coin;

public class DestroyWallAction extends Action {
    private Ground targetDestroy;
    private Location locationDestroy;
    private String targetNameDestroy;
    private String direction;
    public DestroyWallAction(Ground target, Location location, String targetName, String direction){
        this.targetDestroy = target;
        this. locationDestroy = location;
        this. targetNameDestroy = targetName;
        this. direction = direction;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        map.moveActor(actor,locationDestroy);
        Ground newDirt = new Dirt();
        locationDestroy.setGround(newDirt);
        locationDestroy.addItem(new Coin(5));
        return actor + " destroys " + targetNameDestroy;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " move to the " + direction;
    }
}
