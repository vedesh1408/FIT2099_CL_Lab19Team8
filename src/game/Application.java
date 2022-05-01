package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.Player;
import game.actors.Toad;
import game.actors.enemies.Goomba;
import game.actors.enemies.Koopa;
import game.enums.Status;
import game.magicalitems.*;

/**
 * The main class for the Mario World game.
 *
 */
public class Application {

	public static void main(String[] args) {

			World world = new World(new Display());

			FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Sprout());

			List<String> map = Arrays.asList(
				"..........................................##....................................",
				"............................................#...................................",
				"............................................#...................................",
				".............................................##.................................",
				"...............................................#................................",
				"................................................#...............................",
				"..................................................#.............................",
				".................................................##.............................",
				"................................................##..............................",
				"........................................+#____####..............................",
				".......................................+#_____###++.............................",
				".......................................+#______###..............................",
				"........................................+#_____###..............................",
				".................................................##.............................",
				"...................................................#............................",
				"....................................................#...........................",
				".....................................................#..........................",
				"......................................................#.........................",
				".......................................................##.......................");

			GameMap gameMap = new GameMap(groundFactory, map);
			world.addGameMap(gameMap);

			Actor mario = new Player("Player", 'm', 100);
			world.addPlayer(mario, gameMap.at(30, 10));

			// Spawning some (10) trees randomly (left a couple manual trees in around the safezone)
			for (int i = 0; i <= 10; i++) {
				// Choose a location
				int sproutX = Utils.ranNum(80);
				int sproutY = Utils.ranNum(19);
				// Check if the location is dirt
				if (gameMap.at(sproutX, sproutY).getGround().hasCapability(Status.FERTILE)) {
					// If so, change to a new Sprout
					gameMap.at(sproutX, sproutY).setGround(new Sprout());
				}
			}

			gameMap.at(31,10).addItem(new Wrench());
			gameMap.at(42,11).addActor(new Toad());
			// Added power star and super mushroom to the game map at locations close to the actor
			gameMap.at(41, 10).addItem(new PowerStar());

			gameMap.at(43, 10).addItem(new SuperMushroom());

			world.run();

	}
}
