package searching.sequantialsearch;

import java.util.List;

/**
 * Created by Roman Korsun on 06.07.2016.
 */
public class SortedSequantialSearcher {


    /**
     * Compare two values
     * @param x - first value to compare
     * @param y - second value to compare
     * @return 1 - if x greater then y, -1 - if x less than y, 0 - if x and y are equal
     */
    private int compare(int x, int y) {
        System.out.println(x+" "+y);
        if(x < y)
            return -1;
        if(y == x)
            return 0;
        return 1;
    }

    /**
     * Runs sorted sequantial search
     * @param array - array of values
     * @param target - value that has to be found
     * @return index of target value, or -1 if it doesn't exists in array
     */
    public int runSortedSequantialSearch(int[] array, int target) {

        for (int i = 0; i < array.length; i++) {
          int compResult = compare(target, array[i]);
            if(compResult == 0) return i;
            if(compResult == -1) return -1;
        }
        return -1;
    }
}
