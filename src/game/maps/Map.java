package game.maps;

import edu.monash.fit2099.engine.positions.GameMap;
import game.Utils;
import game.actors.enemies.Goomba;
import game.actors.enemies.Koopa;
import game.enums.GenerationObject;
import game.grounds.MysteryBlock;
import game.grounds.WarpPipe;
import game.implementeditems.Coin;
import game.grounds.tree.Sprout;

import java.util.List;

public abstract class Map {

    private List<String> map;

    public Map(){
    }

    public abstract String menuName();

    public List<String> getMap() { return map; }

    public void setMap(List<String> map) { this.map = map; }

    public int getMaxX() { return map.get(0).length() - 1; }

    public int getMaxY() { return map.size() - 1; }

    /**
     * Method to add objects to random places on the map
     * Objects must be added to the GenerationObject enum, and their switch case added to this function in order to work
     * @param gameMap the GameMap objects are to be spawned on
     * @param overwriteGround the type of ground to be overwritten by objects, usually dirt '.' but floor '_' on treasure room
     * @param genObj The type of object to be spawned. Most actors or enemies. Must be in the GenerationObject enum and have a switch case
     * @param count the number of objects to be spawned randomly throughout the map
     */
    // To add a new object to be generated, add it to the enum GenerationObject and then create a new line in the switch statement below.
    public void RanGen(GameMap gameMap, char overwriteGround, GenerationObject genObj, int count)
    {
        // Spawning some actors randomly *count* times
        for (int i = 0; i <= count; i++) {
            // Choose a location
            boolean validGround = false;
            while (!validGround) {
                int xCoord = Utils.ranNum(getMaxX());
                int yCoord = Utils.ranNum(getMaxY());
                // Check if the location is dirt
                if (gameMap.at(xCoord, yCoord).getGround().getDisplayChar() == overwriteGround) {
                    // If so, check what needs to be generated and generate it
                    switch (genObj) {
                        case KOOPA -> gameMap.at(xCoord, yCoord).addActor(new Koopa());
                        case GOOMBA -> gameMap.at(xCoord, yCoord).addActor(new Goomba());
                        case SPROUT -> gameMap.at(xCoord, yCoord).setGround(new Sprout(xCoord, yCoord));
                        case COIN20 -> gameMap.at(xCoord, yCoord).addItem(new Coin(20, xCoord, yCoord));
                        case MBLOCK -> gameMap.at(xCoord,yCoord).setGround(new MysteryBlock(gameMap.at(xCoord,yCoord)));
                    }
                    validGround = true;
                }
            }
        }
    }

    /**
     * Special method to add Warp Pipes to random places on the map. Needs its own function due to needing to access multiple maps to create the exit of the warp pipe.
     * @param thisGM the GameMap objects are to be spawned on
     * @param targetGM the GameMap the end of the pipe should be spawned on.
     * @param targetMap the Map (not GameMap) to be passed to the Warp Pipe on construction
     * @param count the number of pipes to be spawned randomly throughout the map
     */
    public void RanGenWP(GameMap thisGM, GameMap targetGM, Map targetMap, int count)
    {
        // Spawning some actors randomly *count* times
        for (int i = 0; i <= count; i++) {
            // Choose a location
            boolean validGround = false;
            while (!validGround) {
                int xCoord = Utils.ranNum(getMaxX());
                int yCoord = Utils.ranNum(getMaxY());
                // Check if the location is dirt
                if (thisGM.at(xCoord, yCoord).getGround().getDisplayChar() == '.') {
                    thisGM.at(xCoord, yCoord).setGround(new WarpPipe(this, targetMap, targetGM.at(0,0), thisGM.at(xCoord, yCoord)));
                    validGround = true;
                }
            }
        }
    }
}
