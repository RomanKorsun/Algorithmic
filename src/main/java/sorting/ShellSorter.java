package sorting;

import java.util.Arrays;

/**
 * Created by Roman Korsun on 12.07.2016.
 * Implementation of Shell sort algorithm
 */
public class ShellSorter extends  Sorter{
    /**
     * Shell sort - sort with diminishing increment (descending)
     * @param array to be sorted
     * @return sorted array
     */
    @Override
    public int[] sort(int[] array) {

        int passes = array.length/2;
        while (passes>0) {
            for (int i = 0; i < array.length-passes; i++) {
                int j = i+passes;
                int newElement = array[j];
                while (j>=passes && newElement>array[j-passes]) {
                    array[j] = array[j-passes];
                    j-=passes;
                }
                array[j] = newElement;

            }
//            passes-=passes;
            if(passes==2) {
                passes=1;
            } else {
                passes /=2.2;
            }
        }
        return array;
    }




    public  int[] shellSort(int[] array) {

        int n = log2(array.length);
        int h = (int)Math.pow(2, n)-1;
//        while (h<array.length/3) h = 3*h + 1;
        System.out.println(h);
        while (h>0) {
            for (int i = h; i < array.length; i++) {
                int j=i;
                int newValue = array[j];
                while (j >= h && newValue<array[j-h]) {
                    array[j] = array[j-h];
                    System.out.println(Arrays.toString(array));
                    j-=h;
                }
                array[j] = newValue;

            }
            h--;
        }
        return array;
    }

    private int log2(int n) {
        int res = (int) Math.round(Math.log10(n)/Math.log10(2));
        return res;
    }

}


