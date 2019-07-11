package UnionFind;

import edu.princeton.cs.algs4.StdOut;

public class QuickUnion {

    private int[] id;
    private int count;

    public QuickUnion(int N) {
        id = new int[N];
        for (int i = 0; i < N; ++i) {
            id[i] = i;
        }
        count = N;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pComponent = find(p);
        int qComponent = find(q);

        if (pComponent == qComponent) {
            return;
        }

        id[pComponent] = qComponent;
        count--;
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void print() {
        for (int i = 0; i < id.length; ++i) {
            StdOut.print(id[i] + " ");
        }
    }
}
