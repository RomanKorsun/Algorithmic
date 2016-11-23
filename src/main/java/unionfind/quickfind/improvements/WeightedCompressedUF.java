package unionfind.quickfind.improvements;

import java.util.Arrays;

/**
 * Created by Roman Korsun on 07.10.2016.
 */
public class WeightedCompressedUF {
    private int[] items;
    private int[] sizes; //sizes of the trees

    public WeightedCompressedUF(int number) {
        items = new int[number];
        sizes = new int[number];
        for (int i = 0; i < number; i++) {
            items[i] = i;
            sizes[i] = 1;
        }
    }

    private int root(int i) {
        while (items[i]!=i) {
            items[i] = items[items[i]];
            i = items[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p)==root(q);
    }

    public void connect(int p, int q) {
        int pid = root(p);
        int qid = root(q);
        if(pid == qid) return;
        if(sizes[pid] < sizes[qid]) {
            items[pid] = qid;
            sizes[qid] += sizes[pid];
        } else {
            items[qid] = pid;
            sizes[pid] += sizes[qid];
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
