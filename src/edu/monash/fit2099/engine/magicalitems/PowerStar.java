package edu.monash.fit2099.engine.magicalitems;

public class PowerStar extends MagicalItem {
    String name;
    String displayChar;
    boolean portable;


    public PowerStar(String name, String displayChar, boolean portable){
        this.name = name;
        this.displayChar = displayChar;
        this.portable = portable;
    }
}
