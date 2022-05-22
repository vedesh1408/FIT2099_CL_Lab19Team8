package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.Player;
import game.actors.allies.*;
import game.actors.enemies.Bowser;
import game.actors.enemies.Goomba;
import game.actors.enemies.Koopa;
import game.enums.GenerationObject;
import game.enums.Status;
import game.grounds.*;
import game.implementeditems.Wrench;
import game.magicalitems.*;
import game.maps.*;

/**
 * The main class for the Mario World game.
 */
public class Application {

    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Lava());

        // Creating a new lavaZone *MAP* not GameMap
        LavaZone lavaMap = new LavaZone();

        //Adding the lava zone to the world's game maps.
        GameMap lavaGM = new GameMap(groundFactory, lavaMap.getMap());
        world.addGameMap(lavaGM);

        // Adding Princess Peach and Bowser to the map
        lavaGM.addActor(new Bowser(), lavaGM.at(36,1));
        lavaGM.addActor(new PrincessPeach(), lavaGM.at(37,1));

        // Creating our home map
        HomeMap homeMap = new HomeMap();

        // Adding the home map to the world's game maps.
        GameMap homeGM = new GameMap(groundFactory, homeMap.getMap());
        world.addGameMap(homeGM);

        // Creating a new warp pipe object
        homeMap.RanGenWP(homeGM, lavaGM, lavaMap, 5);

        // Creating a new Treasure Room map
        TreasureRoom treasureMap = new TreasureRoom();

        // Adding the treasure room to the world's game maps.
        GameMap treasureGM = new GameMap(groundFactory, treasureMap.getMap());
        world.addGameMap(treasureGM);

        // Adding in the treasure chest, coins and door to the treasure room

        // Open door
        treasureGM.at(10,0).setGround(new OpenDoor(homeGM.at(4,10)));
        // Treasure chest
        treasureGM.at(10,3).setGround(new Chest(treasureGM.at(10,3)));
        // Adding 2 mystery blocks to the treasure room
        treasureGM.at(8,2).setGround(new MysteryBlock(treasureGM.at(8,2)));
        treasureGM.at(12,2).setGround(new MysteryBlock(treasureGM.at(12,2)));

        // In the treasure room, placing 10 coins around the map for the player to pick up
        treasureMap.RanGen(treasureGM, '_', GenerationObject.COIN20, 10);

        Actor mario = new Player("Mario", 'm', 100);
        world.addPlayer(mario, homeGM.at(42, 10));

        homeGM.at(42,7).setGround(new HealthFountain());
        homeGM.at(40,5).setGround(new PowerFountain());

        // Spawning initial trees, mystery blocks and enemies randomly
        homeMap.RanGen(homeGM, '.', GenerationObject.SPROUT, 20);
        homeMap.RanGen(homeGM, '.', GenerationObject.MBLOCK, 3);
        homeMap.RanGen(homeGM, '.', GenerationObject.KOOPA, 2);
        homeMap.RanGen(homeGM, '.', GenerationObject.GOOMBA, 5);

        homeGM.at(31, 10).addItem(new Wrench());
        homeGM.at(42, 11).addActor(new Toad());
        // Added power star and super mushroom to the game map at locations close to the actor
        homeGM.at(41, 10).addItem(new PowerStar());
        homeGM.at(43, 10).addItem(new SuperMushroom());
        homeGM.at(4,10).setGround(new LockedDoor(homeGM.at(4,10), treasureGM.at(10,1)));

        world.run();

    }
}
