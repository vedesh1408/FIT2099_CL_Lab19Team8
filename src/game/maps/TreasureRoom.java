package game.maps;

import java.util.Arrays;
import java.util.List;

/**
 * Special map representing the treasure room. A secret room that the player can find, unlock, and get rewards in
 */
public class TreasureRoom extends Map {

    public TreasureRoom() {
        List<String> map = Arrays.asList(
            "_____________________",
                 "_____________________",
                 "_____________________",
                 "_____________________",
                 "_____________________");
        setMap(map);
    }

    @Override
    public String menuName() {
        return "Treasure Room";
    }
}
