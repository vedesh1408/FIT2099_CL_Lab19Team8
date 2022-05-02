package game;

import game.interfaces.Resettable;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * A global Singleton manager that does soft-reset on the instances.
 * HINT: refer to Bootcamp Week 5 about static factory method.
 * A3: Think about how will you improve this implementation in the future assessment.
 * What could be the drawbacks of this implementation?
 */
public class ResetManager {
    /**
     * A list of resettable instances (any classes that implements Resettable,
     * such as Player implements Resettable will be stored in here)
     */
    private List<Resettable> resettableList;

    /**
     * A singleton reset manager instance
     */
    private static ResetManager instance;

    /**
     * Get the singleton instance of reset manager
     * @return ResetManager singleton instance
     */
    public static ResetManager getInstance(){
        if(instance == null){
            instance = new ResetManager();
        }
        return instance;
    }

    /**
     * Constructor
     */
    public ResetManager(){
        resettableList = new ArrayList<>();
    }

    /**
     * Reset the game by traversing through all the list
     * By doing this way, it will avoid using `instanceof` all over the place.
     */
    public void run(Location location){
        for (Resettable reset : resettableList) {
            reset.resetInstance(location);
        }
        this.cleanUp();
    }

    /**
     * Add the Resettable instance to the list
     */
    public void appendResetInstance(Resettable reset){
        resettableList.add(reset);
    }


    /**
     * Remove a Resettable instance from the list
     * Removes all instances of items that aren't permanent in the game.
     */
    public void cleanUp(){
        ArrayList<Resettable> perm = new ArrayList<>();
        for (Resettable reset : resettableList){
            if (reset.isPermanent()) {
                perm.add(reset);
            }
        }
        resettableList = new ArrayList<>();
        resettableList.addAll(perm);
    }
}
