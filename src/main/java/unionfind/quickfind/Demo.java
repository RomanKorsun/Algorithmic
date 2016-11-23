package unionfind.quickfind;

/**
 * Created by Roman Korsun on 03.04.2016.
 */
public class Demo {
    public static void main(String[] args) {
        QuickUF quickUF = new QuickUF(10);
        quickUF.union(0,2);
        quickUF.union(2,3);
        quickUF.union(1,3);
        quickUF.union(5,7);
        quickUF.union(6,7);
        quickUF.union(6,8);
        quickUF.union(8,9);



        System.out.println(quickUF);

        System.out.println(quickUF.isConnected(0,3));
    }
}
