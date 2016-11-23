package sorting;

/**
 * Created by Roman Korsun on 14.07.2016.
 */
public class QuickSorter extends Sorter {
    @Override
    public int[] sort(int[] array) {
        return quickSort(array,0, array.length-1);
    }

    private int[] quickSort(int[] array, int first, int last) {
//        if(first<last) {
//            int pivot = pivotList3(array, first, last);
//            quickSort(array, first, pivot-1);
//            quickSort(array, pivot+1, last);
//        }
        int pivot = pivotList3(array, first, last);
        if(first<pivot-1)
            quickSort(array, first, pivot-1);
        if(pivot<last)
            quickSort(array, pivot, last);
        return array;
    }

    private int pivotList(int[] array, int first, int last) {
        int pivotValue = array[first];
        int pivotPoint = first;
        for (int i = first+1; i < last; i++) {
            if(pivotValue > array[i]) {
                pivotPoint+=1;
                swap(array, pivotPoint, i);
            }
        }
        swap(array, first, pivotPoint);
        return pivotPoint;
    }

    private int pivotList2(int[] array, int first, int last) {
        int pivotValue;
        int pivotPoint=0;
        int middle = (first+last)/2;
        if(array[first] > array[last] && array[first] < array[middle])
            pivotPoint = first;
        if(array[last] > array[first] && array[last] < array[middle])
            pivotPoint = last;
        if(array[middle] > array[first] && array[middle] < array[last])
            pivotPoint = middle;

        pivotValue = array[pivotPoint];
        int p = pivotPoint;
        for (int i = first; i < last; i++) {
            if(i != pivotPoint) {
                if(pivotValue > array[i]) {
                    pivotPoint+=1;
                    swap(array, pivotPoint, i);
                }
            }
        }
        swap(array, p, pivotPoint);
        return pivotPoint;
    }

    private int pivotList3(int[] array, int first, int last) {
        int lower = first;
        int upper = last;
        int pivotValue = array[first];
        do {

            while(array[upper]<=pivotValue)
                upper--;

            while (array[lower]>=pivotValue)
                lower++;
            if(lower<=upper) {
                swap(array, lower, upper);
//                lower++;
//                upper--;
            }

        }while (lower<upper);
        swap(array, upper, lower);
        swap(array,first,upper);
        return upper;
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
