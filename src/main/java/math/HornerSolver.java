package math;

/**
 * Created by Roman Korsun on 18.07.2016.
 */
public class HornerSolver extends Solver {

    /**
     * Method for evaluating a polynomial using Horner's method
     * @param a - array of coefficients
     * @param x - the value to be evaluated at
     * @return value in x
     */
    @Override
    public int evaluate(int[] a, int x) {
        int result = 0;
        for (int i = a.length-1; i >= 0; i--) {
            result = result * x;
            result = result + a[i];
        }
        return result;
    }
}
