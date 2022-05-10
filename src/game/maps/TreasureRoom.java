package game.maps;

import java.util.Arrays;
import java.util.List;

public class TreasureRoom extends Map {

    public TreasureRoom() {
        List<String> map = Arrays.asList(
            "__$_______]_____$____",
                 "______$______$_______",
                 "__________________$__",
                 "__$____$__=____$_____",
                 "_____$______$______$_");
    }

    @Override
    public String menuName() {
        return "Treasure Room";
    }
}
