package sorting.quicksort;

import java.util.Arrays;

/**
 * Created by Roman Korsun on 17.10.2016.
 */
public class QuickSort {

    public static void main(String[] args) {
        Integer[] arr = {9, 7, 3, 1, 10, 2, 6};
        System.out.println(Arrays.toString(arr));
        new QuickSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi+1;
        while (true) {
            while (less(a[++i], a[lo]))
                if(i==hi) break;
            while (less(a[lo], a[--j]))
                if(j==lo) break;

            if(j<=i) break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if(hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    public void sort(Comparable[] a) {
        sort(a, 0, a.length-1);
    }
}

