package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.enums.Status;
import game.implementedactions.ConsumeItemAction;
import game.implementedactions.ResetAction;
import game.implementeditems.ResetItem;
import game.implementeditems.SecretKey;
import game.interfaces.Resettable;
import game.WalletManager;
import game.magicalitems.Bottle;

import java.util.List;

/**
 * Class representing the Player.
 */
public class Player extends Actor implements Resettable {

    private final Menu menu = new Menu();
    private ResetItem reset = new ResetItem();
    private boolean isKeyPlaced = false;
    private SecretKey secretKey = new SecretKey();
    private int intrinsicValue;

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
        this.intrinsicValue = 5;
        this.addItemToInventory(new Bottle());
    }

    /**
     * Figure out what to do next.
     *
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        //check if player is dead
        System.out.println(this.capabilitiesList());
        if (!this.isConscious()) {
            display.println(this.name + " is dead");
            System.exit(0);
        }

        // Adding a new reset action
        if (this.getInventory().contains(reset)){
            actions.add(new ResetAction(reset));
        }

        // Secret key code
        // When the player gets within 5 blocks of the key it shows on the map.
        if (this.getDistance(map.locationOf(this), 72, 2) <= 5 && !this.isKeyPlaced) {
            map.at(72,2).addItem(this.secretKey);
            this.isKeyPlaced = true;
        }

        // Removing the key when the player moves away from it.
        if (this.getDistance(map.locationOf(this), 72, 2) > 5 && this.isKeyPlaced) {
            map.at(72,2).removeItem(this.secretKey);
            this.isKeyPlaced = false;
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
            if (iterator.hasCapability(Status.CONSUMABLE)){
                actions.add(new ConsumeItemAction(iterator));
            }
        }

        display.println("Player's bottle: " + Bottle.getBottle());
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

    /**
     * Distance method to calculate the distance between the player and the secret key on the map.
     * Uses the Math module's sqrt() and pow() methods.
     * @param playerLocation Location of the player
     * @param keyX The x coordinate of the key
     * @param keyY The y coordinate of the key
     * @return A double representing the distance between playerLocation and the keyX and keyY.
     */
    private double getDistance(Location playerLocation, int keyX, int keyY) {
        // Returns the distance between the player and the secret key
        return Math.sqrt((Math.pow((playerLocation.x() - keyX),2) + Math.pow((playerLocation.y() - keyY),2)));
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(intrinsicValue, "punches");
    }

    public void increaseIntrinsicValue(int newValue){
        intrinsicValue += newValue;
    }
}
