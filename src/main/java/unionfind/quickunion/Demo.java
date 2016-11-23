package unionfind.quickunion;

/**
 * Created by Роман on 14.04.2016.
 */
public class Demo {

    public static void main(String[] args) {
        QuickUnionUF quickUnionUF = new QuickUnionUF(10);
        quickUnionUF.union(2,1);
        quickUnionUF.union(7,2);
        quickUnionUF.union(6,2);
        quickUnionUF.union(3,5);
        quickUnionUF.union(4,8);
        System.out.println(quickUnionUF);
        System.out.println(quickUnionUF.connected(1,7));
        System.out.println(quickUnionUF.connected(4,3));
    }
}
