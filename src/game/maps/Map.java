package game.maps;

import edu.monash.fit2099.engine.positions.GameMap;
import game.Utils;
import game.actors.enemies.Goomba;
import game.actors.enemies.Koopa;
import game.enums.GenerationObject;
import game.grounds.WarpPipe;
import game.implementeditems.Coin;
import game.tree.Sprout;

import java.util.List;

public abstract class Map {

    private List<String> map;

    public Map(){
    }

    public abstract String menuName();

    public List<String> getMap() { return map; }

    public void setMap(List<String> map) { this.map = map; }

    public int getMaxX() { return map.get(0).length(); }

    public int getMaxY() { return map.size(); }

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
                    }
                    validGround = true;
                }
            }
        }
    }

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
