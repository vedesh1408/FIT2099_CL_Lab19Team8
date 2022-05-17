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
        this.map = map;
    }

    @Override
    public String menuName() {
        return "Treasure Room";
    }
}
