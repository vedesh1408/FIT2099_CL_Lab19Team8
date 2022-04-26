package edu.monash.fit2099.engine.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class ConsumeItemAction extends Action {

    private final Item item;

    /**
	 * Constructor.
	 *
	 * @param item the item to pick up
	 */
	public ConsumeItemAction(Item item) {
		this.item = item;
	}
}
