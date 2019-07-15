package UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UnionFindClient {

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFind unionFind = new QuickFind(N);
//        QuickUnion unionFind = new QuickUnion(N);
//        WeightedQuickUnion unionFind = new WeightedQuickUnion(N);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if (unionFind.connected(p, q)) {
                continue;
            }
            unionFind.union(p, q);
            StdOut.println(p + " " + q);
        }

        StdOut.println(unionFind.count() + " components.");
        unionFind.print();
    }
}

