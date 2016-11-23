package math;

/**
 * Created by Roman Korsun on 18.07.2016.
 */
public class Solver {
    /**
     * Calculates values of polynomials
     *
     * @param a - array of coefficients
     * @param x - the value to be evaluated at
     * @return - value in x
     */
    public int evaluate(int[] a, int x) {
            int result = a[0]+a[1]*x;
            int xPover = x;
            for (int i = 2; i < a.length; i++) {
                xPover = xPover*x;
                result = result+ a[i]*xPover;
            }
            return result;
    }
}
