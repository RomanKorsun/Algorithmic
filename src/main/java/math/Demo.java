package math;

/**
 * Created by Roman Korsun on 18.07.2016.
 */
public class Demo {

    static int[] a = {1, 2, 3};
    public static void main(String[] args) {
        Solver solver = new HornerSolver();
        System.out.println(solver.evaluate(a, 2));
    }
}
