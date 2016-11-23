package math.matrix;

import java.util.Arrays;

/**
 * Created by Roman Korsun on 19.07.2016.
 */
public class MatrixDemo {
    final static int[][] a = {{1,2,3},
                        {4,5,6}};

    final static int[][] b = {{1,2,3},
                        {4,5,6},
                        {7,8,9}};

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new VinogradMultiplicator().multiply(a,b)));
    }
}
