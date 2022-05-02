package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.displays.Menu;
import game.enums.Status;
import game.implementedActions.ResetAction;
import game.interfaces.Resettable;

/**
 * Class representing the Player.
 */
public class Player extends Actor implements Resettable {

	private final Menu menu = new Menu();
	private Integer wallet;
	boolean hasReset;

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		wallet = 0;
		this.registerInstance();
		this.hasReset = false;
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		display.println(super.name + " " + super.printHp() + " at (" + map.locationOf(this).x() + ", " + map.locationOf(this).y() + ")");
		display.println("Wallet: $" + getWallet());
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	@Override
	public char getDisplayChar(){
		return this.hasCapability(Status.TALL) ? Character.toUpperCase(super.getDisplayChar()): super.getDisplayChar();
	}

	public void changeWallet(Integer amount) { wallet += amount; }

	public Integer getWallet() { return wallet; }

	@Override
	public void resetInstance(Location location) {
		// Resetting player's max hp
		this.resetMaxHp(this.getMaxHp());
		this.removeCapability(Status.TALL);
		this.removeCapability(Status.INVINCIBILITY);
		this.setDisplayChar('m');
	}

	@Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList list = super.allowableActions(this, direction, map);
        list.add(new ResetAction(this));
        return list;
    }

	@Override
	public boolean isPermanent() {
		return true;
	}
}
