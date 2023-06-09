package game.maps;

import java.util.Arrays;
import java.util.List;

/**
 * Map representing lava zone with the boss Bowser and Princess Peach
 */
public class LavaZone extends Map {

    public LavaZone(){
        List<String> map = Arrays.asList(
            "____#...L.......LLLLL....L.....L........",
                 "_____#.....L......LLLL.L........L.......",
                 "______............LLLL.....L....L.......",
                 "___##...L........LLLL...........____....",
                 "###........L...._______............LLL..",
                 "..................LLLL..L....L........LL",
                 "....L........L...LLLLL.............#####",
                 ".........L.......LLLL......L....#_______",
                 ".L................LLLL.........#________",
                 ".......L........L..LLLL........_________");
        setMap(map);
    }

    @Override
    public String menuName() {
        return "Lava Zone";
    }
}
