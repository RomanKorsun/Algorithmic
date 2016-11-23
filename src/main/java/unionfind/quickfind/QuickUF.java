package unionfind.quickfind;

import java.util.Arrays;

/**
 * Created by Roman Korsun on 03.04.2016.
 */
public class QuickUF {

    private int[] ufArr;

    public QuickUF() {
        this(0);
    }

    public QuickUF(int length) {
        ufArr = new int[length];
        for(int i = 0; i < ufArr.length; i++) {
            ufArr[i] = i;
        }
    }

    public boolean isConnected(int p, int q) {
        return ufArr[p] == ufArr[q];
    }

    public  void union(int p, int q) {
        int pid = ufArr[p];
        int qid = ufArr[q];
        for(int i = 0; i < ufArr.length; i++) {
            if(ufArr[i] == pid) ufArr[i] = qid;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(ufArr);
    }
}
