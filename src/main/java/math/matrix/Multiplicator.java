package math.matrix;

import java.security.InvalidParameterException;

/**
 * Created by Roman Korsun on 19.07.2016.
 *
 */
public class Multiplicator {

    /**
     * Matrix multiplication
     * @param a - first matrix
     * @param b - second matrix
     * @return result matrix
     * @exception InvalidParameterException
     */
    public int[][] multiply(int[][] a, int[][] b) throws InvalidParameterException {

        int rowsA = a.length;       //number of rows of a
        int colsA = a[0].length;    //number of columns of a
        int colsB = b[0].length;    //number of columns of b
        if(colsA != b.length) throw new InvalidParameterException();

        int[][] r = new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                r[i][j] = 0;
                for (int k = 0; k < colsA; k++) {
                    r[i][j] = r[i][j]+ a[i][k]*b[k][j];
                }
            }
        }
        return r;
    }
}
