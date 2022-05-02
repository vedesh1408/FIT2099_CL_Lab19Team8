package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.displays.Menu;
import game.enums.Status;
import game.implementedActions.ConsumeItemAction;
import game.implementedActions.ResetAction;
import game.implemetedItems.ResetItem;
import game.interfaces.Resettable;

import java.util.List;

/**
 * Class representing the Player.
 */
public class Player extends Actor implements Resettable {

    private final Menu menu = new Menu();
    private Integer wallet;

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
        super.addItemToInventory(new ResetItem());
    }

    /**
     * Figure out what to do next.
     *
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        //check if player is dead
        if (!this.isConscious()) {
            display.println(this.name + "is dead");
            System.exit(0);
        }
        display.println(super.name + " " + super.printHp() + " at (" + map.locationOf(this).x() + ", " + map.locationOf(this).y() + ")");
        display.println("Wallet: $" + getWallet());
        // Handle multi-turn Actions
        if (lastAction.getNextAction() != null)
            return lastAction.getNextAction();
        List<Item> inventoryItems = getInventory();
        for (Item iterator: inventoryItems){
            actions.add(new ConsumeItemAction(iterator));
        }
        // return/print the console menu
        return menu.showMenu(this, actions, display);
    }

    @Override
    /**
     * It returns the character display based on whether it has the tall capabilities activated
     */
    public char getDisplayChar() {
        return this.hasCapability(Status.TALL) ? Character.toUpperCase(super.getDisplayChar()) : super.getDisplayChar();
    }

    /**
     * It increments the wallet amount by the amount
     *
     * @param amount The amount to be added to wallet
     */
    public void changeWallet(Integer amount) {
        wallet += amount;
    }

    /**
     * It returns the wallet
     *
     * @return Amount the wallet contains
     */
    public Integer getWallet() {
        return wallet;
    }

    @Override
    /**
     * When called, removes all capabilities on player and increase its hP to max
     */
    public void resetInstance(Location location) {
        // Resetting player's max hp
        this.resetMaxHp(this.getMaxHp());
        if (this.hasCapability(Status.TALL)) {
            this.removeCapability(Status.TALL);
        }
        if (this.hasCapability(Status.INVINCIBILITY)) {
            this.removeCapability(Status.INVINCIBILITY);
        }
        this.setDisplayChar('m');
    }

    /**
     * It returns true or false based if the item needs to be made permanent or not
     */
    @Override
    public boolean isPermanent() {
        return true;
    }
}
