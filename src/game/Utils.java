package game;

import java.util.Random;

/**
 * Static class to generate a random number
 * Randomises a number from 0 (inclusive) to the specified value (exclusive)
 */
public class Utils {
    // Function to randomise a number from 0 (inclusive) to the specified value (exclusive)
    public static int ranNum(Integer max) {
        Random r = new Random();
        return r.nextInt(max);
    }
}
