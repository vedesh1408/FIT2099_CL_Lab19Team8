package game.magicalitems;

import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.items.Item;
import game.ConsumeItemAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actions.*;

import java.util.List;

public abstract class MagicalItem extends Item {
    boolean consumable;
	ActionList allowableActions = new ActionList();

    public MagicalItem(String name, char displayChar, boolean portable, boolean consumable){
        super(name, displayChar, portable);
        this.consumable = consumable;
    }

    /**
	 * Create and return an action to pick this Item up.
	 * If this Item is not portable, returns null.
	 *
	 * @return a new ConsumeItemAction if this Item is consumable, null otherwise.
	 */
	public ConsumeItemAction getConsumeAction(Actor actor) {
		if(consumable)
			return new ConsumeItemAction(this);
		return null;
	}


	//TODO Make this work somehow
	/**
	 * Getter.
	 *
	 * Returns an unmodifiable copy of the actions list so that calling methods won't
	 * be able to change what this Item can do without the Item checking.
	 * @return an unmodifiable list of Actions
	 */
	@Override
	public List<Action> getAllowableActions() {
		this.addAction(new ConsumeItemAction(this));
		return allowableActions.getUnmodifiableActionList();
	}

}
