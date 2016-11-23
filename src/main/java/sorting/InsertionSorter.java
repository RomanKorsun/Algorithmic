package sorting;

/**
 * Created by Roman Korsun on 22.06.2016.
 * Implementation of insertion sort
 */
public class InsertionSorter extends Sorter {
    /**
     * Sorts array using Insertion sort algorithm
     * @param array array to sort
     * @return sorted array
     */
    @Override
    public int[] sort(int[] array) {

        int current;
        for(int i = 1; i < array.length; i++) {
            current = array[i];
            int j = i - 1;
            while (j >= 0 && current < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
        return array;
    }

    /**
     * Binary Insertion sort
     * @param array - array to sort
     * @return sorted array
     */
    public  int[] sortBinary(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int newElement = array[i];
            int location = i - 1;
            int index = findInsertionIndex(array,0, location, array[i]);
            while (location >= index) {

                    array[location+1] = array[location];


                location = location - 1;
            }
            array[location+1] = newElement;
        }
        return array;
    }


    private int findInsertionIndex(int[] array, int start, int end, int value) {

        if(start>=end) {
            return (value >= array[start])? start+1 :start;
        }
          int  mid = (start+end)/2;
            if(value==array[mid])
                return mid+1;
            if(value < array[mid]) {
                return findInsertionIndex(array, start, mid-1, value);
            } else {
                return findInsertionIndex(array, mid+1, end, value);
            }

    }


}
