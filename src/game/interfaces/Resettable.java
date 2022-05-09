package game.interfaces;

import edu.monash.fit2099.engine.positions.GameMap;
import game.ResetManager;

/**
 * Interface to check if something can be reset
 */
public interface Resettable {
    /**
     * Allows any classes that use this interface to reset abilities, attributes, and/or items.
     * HINT: play around with capability, the actual implementation happens in the tick or playTurn method.
     */
    void resetInstance(GameMap map);

    /**
     * Used to determine whether the instance is permanent in the game or not.
     * (Needs to be removed from resettable list)
     */
    boolean isPermanent();

    /**
     * a default interface method that register current instance to the Singleton manager.
     * It allows corresponding class uses to be affected by global reset
     */
    default void registerInstance() {
        ResetManager.getInstance().appendResetInstance(this);
    }
}
