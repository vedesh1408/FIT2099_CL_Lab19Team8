package game;

import edu.monash.fit2099.engine.items.Item;

public class Coin extends Item {

    public Coin() {
        super("Coin", '$', false);
        addAction(new CollectCoinAction(this));
    }


}
