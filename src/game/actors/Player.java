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
import game.implemetedItems.SecretKey;
import game.interfaces.Resettable;
import game.WalletManager;

import java.util.List;

/**
 * Class representing the Player.
 */
public class Player extends Actor implements Resettable {

    private final Menu menu = new Menu();
    private ResetItem reset = new ResetItem();
    private boolean isKeyPlaced = false;

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
        this.registerInstance();
        if (!this.getInventory().contains(reset)){
            this.addItemToInventory(reset);
        }
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
            display.println(this.name + " is dead");
            System.exit(0);
        }

        // Adding a new reset action
        if (this.getInventory().contains(reset)){
            actions.add(new ResetAction(reset));
        }

        // testing the fog of war secret key concept

        System.out.println(getDistance(map.locationOf(this), 72, 2));
        SecretKey secretKey = new SecretKey();
        if (this.getDistance(map.locationOf(this), 72, 2) <= 5 && !isKeyPlaced) {
            map.at(72,2).addItem(secretKey);
            this.isKeyPlaced = true;
        }

        display.println(super.name + " " + super.printHp() + " at (" + map.locationOf(this).x() + ", " + map.locationOf(this).y() + ")");
        display.println("Wallet: $" + WalletManager.getInstance().getWallet());

        if (this.hasCapability(Status.INVINCIBILITY)) {
            display.println("Mario is INVINCIBLE!");
        }
        // Handle multi-turn Actions
        if (lastAction.getNextAction() != null)
            return lastAction.getNextAction();
        List<Item> inventoryItems = getInventory();
        for (Item iterator: inventoryItems){
            if (iterator != reset && iterator.hasCapability(Status.CONSUMABLE)){
                actions.add(new ConsumeItemAction(iterator));
            }
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

    @Override
    /**
     * When called, removes all capabilities on player and increase its hP to max
     */
    public void resetInstance(GameMap map) {
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

    private double getDistance(Location playerLocation, int keyX, int keyY) {
        // Returns the distance between the player and the secret key
        return Math.sqrt((Math.pow((playerLocation.x() - keyX),2) + Math.pow((playerLocation.y() - keyY),2)));
    }
}
