import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinarySearch {
    private static int rank(int key, int[] a) {
        // Array a must be sorted.
        int lo = 0;
        int hi = a.length - 1;

        while(lo <= hi) {
            int mid = lo + ((hi - lo) / 2);
            if (key < a[mid]) {
                hi = mid - 1;
            }else if (key > a[mid]) {
                lo = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] whiteList = In.readInts(args[0]);

        Arrays.sort(whiteList);

        while(!StdIn.isEmpty()) {
            int value = StdIn.readInt();
            if (rank(value, whiteList) == -1) {
                StdOut.println(value);
            }
        }
    }
}
