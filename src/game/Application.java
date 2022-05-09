package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.Player;
import game.actors.Toad;
import game.actors.enemies.Koopa;
import game.enums.Status;
import game.implementedActions.TeleportAction;
import game.implemetedItems.Wrench;
import game.magicalitems.*;
import game.maps.HomeMap;
import game.maps.LavaZone;
import game.tree.Sprout;

/**
 * The main class for the Mario World game.
 */
public class Application {

    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Lava());

        // Creating a new lavaZone *MAP* not GameMap
        LavaZone lavaZone = new LavaZone();

        // Creating our home map
        HomeMap home = new HomeMap();

        // Adding the home map to the world's game maps.
        GameMap gameMap = new GameMap(groundFactory, home.map);
        world.addGameMap(gameMap);

        //Adding the lava zone to the world's game maps.
        GameMap lava = new GameMap(groundFactory, lavaZone.map);
        world.addGameMap(lava);

        // Creating a new warp pipe object and adding the teleport action to it.
        WarpPipe warpPipe = new WarpPipe(lava.at(0,0));
        warpPipe.addAction(new TeleportAction(lavaZone, lava.at(0,0)));
        // warpPipe.addAction(new MoveActorAction(lava.at(0,0), "Teleport to the Lava Zone"));
        gameMap.at(30, 7).setGround(warpPipe);

        Actor mario = new Player("Player", 'm', 100);
        world.addPlayer(mario, gameMap.at(42, 10));


        // Spawning some (10) trees randomly (left a couple manual trees in around the safezone)
        for (int i = 0; i <= 20; i++) {
            // Choose a location
            int sproutX = Utils.ranNum(80);
            int sproutY = Utils.ranNum(19);
            // Check if the location is dirt
            if (gameMap.at(sproutX, sproutY).getGround().hasCapability(Status.FERTILE)) {
                // If so, change to a new Sprout
                gameMap.at(sproutX, sproutY).setGround(new Sprout(sproutX, sproutY));
            }
        }
        gameMap.at(30, 9).addActor(new Koopa());
        gameMap.at(31, 10).addItem(new Wrench());
        gameMap.at(42, 11).addActor(new Toad());
        // Added power star and super mushroom to the game map at locations close to the actor
        gameMap.at(41, 10).addItem(new PowerStar());
        gameMap.at(43, 10).addItem(new SuperMushroom());
        world.run();

    }
}
