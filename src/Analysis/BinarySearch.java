package Analysis;

import edu.princeton.cs.algs4.StdOut;

public class BinarySearch {
    // return the smallest index

    public static int rank(int [] a, int key) {
        int lo = 0;
        int hi = a.length;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == key) {
                if (a[mid - 1] == key) {
                    hi = mid - 1;
                }else {
                    return mid;
                }
            }else if (a[mid] < key) {
                lo = mid + 1;
            }else {
                hi = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 2, 2, 3, 4, 7, 7, 7, 9, 10};

        StdOut.println(rank(a, 2));
    }

}
