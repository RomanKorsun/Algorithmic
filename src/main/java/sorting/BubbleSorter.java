package sorting;

import java.util.Arrays;

/**
 * Created by Roman Korsun on 20.06.2016.
 */
public class BubbleSorter extends Sorter {

    private void swap(int[] array, int firstPos, int secondPos) {
        int temp = array[firstPos];
        array[firstPos] = array[secondPos];
        array[secondPos] = temp;
    }

    @Override
    public int[] sort(int[] array) {

        if(array == null) throw new NullPointerException();


        int temp = 0;
        for(int i = array.length-1; i > 0 ; i--) {
            for(int j = 0; j < i; j++) {
                if(array[j] > array[j+1]){
                    System.out.println(i);
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public int[] sort1(int[] array) {

        int numberOfPairs = array.length;
        boolean swapped = true;
        while (swapped) {
            numberOfPairs = numberOfPairs - 1;
            swapped = false;
            for (int i = 0; i < numberOfPairs; i++) {
                if(array[i] > array[i+1]) {
                    swap(array, i, i+1);
                    swapped=true;
                }
            }
            System.out.println(Arrays.toString(array)+" "+array.length);
        }
        return array;
    }

    /**
     *
     * @param array
     * @return
     * В этом варианте пузырьковой сортировки запоминается информация о том, где произошел последний обмен элементов, и при
    следующем проходе алгоритм не заходит за это место
     */
    public int[] sort2(int[] array) {

        boolean swapped = true;
        int n = array.length-1;
        int lastSwap = n;
        while (swapped) {
            swapped = false;
            System.out.println("--"+lastSwap+" ");
            for (int i = 0; i < lastSwap; i++) {
                if(array[i] > array[i+1]) {
                    swap(array, i, i+1);
                    swapped = true;
                    n = i;
//                    System.out.println(Arrays.toString(array));
                }
            }
            lastSwap = n;
            System.out.println(swapped);
        }
        return array;
    }

    /**
     * В этом варианте пузырьковой сортировки нечетные и четные проходы выполняются в противоположных направлениях: нечетные проходы в том же направлении, что и в исходном варианте,
     а четные — от конца массива к его началу. При нечетных проходах большие элементы сдвигаются к концу массива, а при четных
     проходах — меньшие элементы двигаются к его началу.
     * @param array
     * @return
     */
    public int[] sort3(int[] array) {
        boolean swapped = true;
        boolean isOdd = true;
        int rightLimit = array.length;
        int leftLimit = 0;
        while (swapped) {


            swapped = false;
            if(isOdd) {
                //go right
                isOdd = false;
                rightLimit -= 1;
                for (int i = 0; i < rightLimit; i++) {
                    if(array[i]>array[i+1]) {
                        swap(array,i,i+1);
                        swapped=true;
                    }
                }
            } else {
                //go left
                isOdd = true;
                leftLimit += 1;
                for (int i = array.length-1; i > leftLimit ; i--) {
                    if(array[i] < array[i-1]) {
                        swap(array, i, i-1);
                        swapped=true;
                    }
                }
            }
        }
        return array;
    }



}
