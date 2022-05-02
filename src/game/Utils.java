package game;

import java.util.Random;

/**
 * Static class to generate random numbers
 */
public class Utils {
    // Function to randomise a number from - to the specified value
    public static int ranNum(Integer max) {
        Random r = new Random();
        return r.nextInt(max);
    }
}
