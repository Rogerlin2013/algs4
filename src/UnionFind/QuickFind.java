package UnionFind;

import edu.princeton.cs.algs4.StdOut;

public class QuickFind {
    private int[] id;
    private int count;

    public QuickFind(int N) {
        id = new int[N];
        for (int i = 0; i < N; ++i) {
            id[i] = i;
        }
        count = N;
    }

    public void union(int p, int q) {
        int pComponent = find(p);
        int qComponent = find(q);

        if (pComponent == qComponent) {
            return;
        }

        for (int i = 0; i < id.length; ++i) {
            if (id[i] == pComponent) {
                id[i] = qComponent;
            }
        }
        count--;
    }

    public int find(int p) {
        return id[p];
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public int count() {
        return count;
    }

    public void print() {
        for (int i = 0; i < id.length; ++i) {
            StdOut.print(id[i] + " ");
        }
    }
}
