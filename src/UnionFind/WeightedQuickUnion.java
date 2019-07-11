package UnionFind;

import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnion {

    private int[] id;
    private int[] sz;
    private int count;

    public WeightedQuickUnion(int N) {
        id = new int[N];
        for (int i = 0; i < N; ++i) {
            id[i] = i;
        }
        sz = new int[N];
        for (int j = 0; j < N; ++j) {
            sz[j] = 1;
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

        if (sz[pComponent] < sz[qComponent]) {
            id[pComponent] = qComponent;
            sz[qComponent] += sz[pComponent];
        }else {
            id[qComponent] = pComponent;
            sz[pComponent] += sz[qComponent];
        }

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
        StdOut.println();
        for (int i = 0; i < sz.length; ++i) {
            StdOut.print(sz[i] + " ");
        }
    }
}
