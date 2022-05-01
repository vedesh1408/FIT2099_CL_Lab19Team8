package game.magicalitems;

import edu.monash.fit2099.engine.items.Item;
import game.implementedActions.ConsumeItemAction;
import edu.monash.fit2099.engine.actions.*;

import java.util.List;

public abstract class MagicalItem extends Item {
    boolean consumable;
	ActionList allowableActions = new ActionList();

    public MagicalItem(String name, char displayChar, boolean portable, boolean consumable){
        super(name, displayChar, portable);
        this.consumable = consumable;
		this.allowableActions.add(new ConsumeItemAction(this));
    }

	/**
	 * Getter.
	 *
	 * Returns an unmodifiable copy of the actions list so that calling methods won't
	 * be able to change what this Item can do without the Item checking.
	 * @return an unmodifiable list of Actions
	 */
	@Override
	public List<Action> getAllowableActions() {
		return allowableActions.getUnmodifiableActionList();
	}

}
