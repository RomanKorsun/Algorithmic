package sorting;

/**
 * Created by Roman Korsun on 20.06.2016.
 * Implementation of Selection sort algorithm
 */
public class SelectionSorter extends Sorter {
    /**
     * Sorts array using Selection sort
     * @param array array to sort
     * @return sorted array
     * @exception NullPointerException
     */
    @Override
    public int[] sort(int[] array) {

        int temp = 0;
        if(array == null) throw  new NullPointerException();
        int minIndex;

        for(int i = 0; i < array.length-1; i++) {
            minIndex = i;
            for(int j = i+1; j < array.length; j++) {
                if(array[minIndex] > array[j])
                    minIndex = j;
            }
            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }
}
