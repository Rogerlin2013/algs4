package UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UnionFindClient {

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFind quickFind = new QuickFind(N);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if (quickFind.connected(p, q)) {
                continue;
            }
            quickFind.union(p, q);
            StdOut.println(p + " " + q);
        }

        StdOut.println(quickFind.count() + " components.");
        quickFind.print();
    }
}

