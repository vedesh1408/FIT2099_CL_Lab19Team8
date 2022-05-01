package game;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.enums.Status;

public class Wrench extends Item implements Weapon {

    public Wrench() {
        super("Wrench", 'w', true);
        this.addCapability(Status.KILL_KOOPA);
        this.asWeapon();

    }

    @Override
    public int damage() {
        return 50;
    }

    @Override
    public String verb() {
        return "destroys";
    }

    @Override
    public int chanceToHit() {
        return 0;
    }
}
