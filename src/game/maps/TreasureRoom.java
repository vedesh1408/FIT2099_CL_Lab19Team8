package game.maps;

import java.util.Arrays;
import java.util.List;

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
