package unionfind.quickfind.improvements;

/**
 * Created by Roman Korsun on 07.10.2016.
 */
public class Demo {
    public static void main(String[] args) {
        WeightedCompressedUF uf = new WeightedCompressedUF(10);
        uf.connect(0,2);
        uf.connect(2,3);
        uf.connect(1,3);
        uf.connect(5,7);
        uf.connect(6,7);
        uf.connect(6,8);
        uf.connect(8,9);



        System.out.println(uf);

        System.out.print(uf.connected(0,3));
    }
}
