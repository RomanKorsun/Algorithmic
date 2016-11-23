package sorting.quicksort;

import java.util.Random;

/**
 * Created by Roman Korsun on 17.10.2016.
 */
public class RndListFactory {
    private int [] array; // stay tuned

    public RndListFactory(int n) {
        array = new int[n];
        generate();

    }

    /**
     * fills the array
     */
    private void generate() {
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(100);
        }
    }

    public int[] getArray() {
        return array;
    }
}
