package game.maps;

import java.util.List;

public abstract class Map {

    private List<String> map;

    public Map(){
    }

    public abstract String menuName();

    public List<String> getMap() { return map; }

    public void setMap(List<String> map) { this.map = map; }

}
