package sorting;

import java.util.Arrays;

/**
 * Created by Роман on 20.06.2016.
 */
public class Demo {



    public static void main(String[] args) {

       int[] array = {9,4,3,5,1,7,6,2};
       QuickSorter  sorter = new QuickSorter();
        int[] arr = sorter.sort(array);

        System.out.println(Arrays.toString(arr));
    }
}
