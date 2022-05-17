package game.maps;

import java.util.Arrays;
import java.util.List;

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
        this.map = map;
    }

    @Override
    public String menuName() {
        return "Lava Zone";
    }
}
