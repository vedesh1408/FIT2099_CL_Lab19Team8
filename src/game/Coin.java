package game;

import edu.monash.fit2099.engine.items.Item;

public class Coin extends Item {

    private Integer value;

    public Coin(Integer value) {
        super("Coin", '$', false);
        this.value = value;
        addAction(new CollectCoinAction(this));
    }

    public Integer getValue() { return value; }
}
