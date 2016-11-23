package sorting;

/**
 * Created by Roman Korsun on 13.07.2016.
 * Imolementtion of Merge sort algorithm
 */
public class MergeSorter extends Sorter {
    /**
     * Sorts array using Merge sort algorithm
     * @param array array to sort
     * @return sorted array
     */
    @Override
    public int[] sort(int[] array) {
        return mergeSort(array, 0, array.length-1);
    }

    private int[] mergeSort(int[] array, int start, int end) {

        if(start<end) {
            int middle = (start+end)/2;
            mergeSort(array,start,middle);
            mergeSort(array,middle+1,end);
            mergeLists(array,start,middle,middle+1,end);
        }
        return array;
    }

    //merging arrays
    private void mergeLists(int[] array, int start1, int end1, int start2, int end2) {
        int finalStart = start1;
        int finalEnd = end2;
        int indexC = 0;
        int[] result = new int[finalEnd+1];

        while (start1<=end1 && start2<=end2) {
            if(array[start1] < array[start2]) {
                result[indexC]=array[start1];
                start1++;
            } else {
                result[indexC]=array[start2];
                start2++;
            }
            indexC++;
        }

        if(start1<=end1) {
            for (int i = start1; i <= end1; i++) {
                result[indexC] = array[i];
                indexC++;
            }
        } else {
            for (int i = start2; i <= end2; i++) {
                result[indexC] = array[i];
                indexC++;
            }
        }
        
        indexC = 0;
        for (int i = finalStart; i <= finalEnd; i++) {
            array[i]=result[indexC++];
//            indexC++;
        }
    }
}
