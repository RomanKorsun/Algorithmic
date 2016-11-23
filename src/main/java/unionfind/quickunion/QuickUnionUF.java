package unionfind.quickunion;


import java.util.Arrays;

/**
 * Created by Роман on 14.04.2016.
 */
public class QuickUnionUF {
    private int arr[];

    public QuickUnionUF(int lenght) {
        arr = new int[lenght];
        for(int i = 0; i < lenght; i++) {
            arr[i] = i;
        }
    }

    private int root(int index) {
        while (index != arr[index]) index = arr[index];
        return index;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        arr[i] = j;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
