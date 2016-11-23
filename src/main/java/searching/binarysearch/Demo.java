package searching.binarysearch;

import searching.klargest.KLargestFinder;

/**
 * Created by Roman Korsun on 23.06.2016.
 */
public class Demo {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 6, 7, 8, 9};
        System.out.println(new BinarySearcher().binarySearch(array, 1));

    }
}
