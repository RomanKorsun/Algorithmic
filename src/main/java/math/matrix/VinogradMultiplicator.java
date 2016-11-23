package math.matrix;

import java.security.InvalidParameterException;

/**
 * Created by Roman Korsun on 19.07.2016.
 */
public class VinogradMultiplicator extends Multiplicator {


    /**
     * Matrix multiplication usinf Vinograd's method
     * @param a - first matrix
     * @param b - second matrix
     * @return result matrix
     * @exception InvalidParameterException
     */
    @Override
    public int[][] multiply(int[][] a, int[][] b) {
        int rowsA = a.length;       //number of rows of a
        int rowsB = b.length;       //number of rows of b
        int colsA = a[0].length;    //number of columns of a
        int colsB = b[0].length;    //number of columns of b

        int[][] r = new int[rowsA][colsB];

        int d = rowsB/2;

        int[] rowFactors = new int[rowsA];
        int[] columnFactors = new int[colsB];
        //rowFactors calculation for a
        for (int i = 0; i < rowsA; i++) {
            rowFactors[i] = a[i][0]*a[i][1];
            for (int j = 1; j < d; j++) {
                rowFactors[i] = rowFactors[i]+a[i][2*j-1]*a[i][2*j];
            }
        }
        //columnFactors calculation for b
        for (int i = 0; i < colsB; i++) {
            columnFactors[i] = b[0][i]*b[1][i];
            for (int j = 1; j < d; j++) {
                columnFactors[i]=columnFactors[i]+b[2*j-1][i]*b[2*j][i];
            }
        }

        // Calculation of matrix r
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                r[i][j]-=rowFactors[i]-columnFactors[j];
                for (int k = 0; k < d; k++) {
                    r[i][j]=r[i][j]+(a[i][2*k-1]+b[2*k][j])*(a[i][2*k]*b[2*k-1][j]);
                }
            }
        }

        //addition of members in case of an odd total dimension
        if(2*(colsA/2) != colsA)
            for (int i = 0; i < rowsA; i++) {
                for (int j = 0; j < colsB; j++) {
                    r[i][j]=r[i][j]+a[i][colsA]*b[colsA][j];
                }
            }

        return r;
    }
}
