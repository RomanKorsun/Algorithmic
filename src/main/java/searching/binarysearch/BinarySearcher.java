package searching.binarysearch;

/**
 * Created by Roman Korsun on 23.06.2016.
 */
public class BinarySearcher {

    /**
     * Compare two values
     * @param x - first value to compare
     * @param y - second value to compare
     * @return 1 - if x greater then y, -1 - if x less than y, 0 - if x and y are equal
     */
    private int compare(int x, int y) {
        if(x < y)
            return -1;
        if(x == y)
            return 0;
        return 1;
    }

    /**
     * Runs binary search on array
     * @param array - array of values
     * @param target - value that has to be found
     * @return index of target value, or -1 if it doesn't exists in array
     */
    public int binarySearch(int[] array, int target) {

        int start =0;
        int end = array.length-1;

        while (start <= end) {
            int middle = (start + end)/2;
            switch (compare(array[middle], target)) {
                case -1: start = middle + 1; break;
                case 1: end = middle - 1; break;
                case 0: return middle;
            }
        }
        return -1;
    }
}
