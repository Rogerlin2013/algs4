package Analysis;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class StaticSETofInts
{
    private int[] a;
    public StaticSETofInts(int[] keys)
    {
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++)
            a[i] = keys[i]; // defensive copy
        Arrays.sort(a);
    }

    public boolean contains(int key)
    {
        return rank(key) != -1;
    }

    public int howMany(int key) {
        int smallest = smallestRank(key);
        if (smallest == -1) {
            return 0;
        }
        int largest = largestRank(key);

        return largest - smallest + 1;
    }

    public static void main(String[] args) {
        int a[] = {2, 3, 3, 3, 3, 6, 6, 8, 9, 10, 10, 10, 11};
        int b[] = {1, 3, 3, 3, 3, 7, 7, 8, 9, 10, 10, 10, 11};
//        StaticSETofInts seTofInts = new StaticSETofInts(a);
//        StdOut.println(seTofInts.howMany(3));
//        StdOut.println(seTofInts.howMany(1));
//        StdOut.println(seTofInts.howMany(2));
//        StdOut.println(seTofInts.howMany(6));
//        StdOut.println(seTofInts.howMany(11));
        countInBothArray(a, b);
    }

    private static void countInBothArray(int [] a, int [] b) {
        int aIndex = 0;
        int bIndex = 0;

        int counted = 0;
        boolean printed = false;

        while (aIndex < a.length && bIndex < b.length) {
            int aValue = a[aIndex];
            int bValue = b[bIndex];

            if (aValue == bValue) {
                if (!printed || (counted != aValue)) {
                    StdOut.print(aValue + " ");
                    printed = true;
                    counted = aValue;
                }
                aIndex++;
                bIndex++;
            }else if (aValue < bValue) {
                aIndex++;
            }else {
                bIndex++;
            }
        }
    }

    private int rank(int key)
    { // Binary search.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        { // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    private int smallestRank(int key) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == key) {
                if (mid > 0 && a[mid - 1] == key) {
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

    private int largestRank(int key) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] > key) {
                hi = mid - 1;
            }else if (a[mid] < key) {
                lo = mid + 1;
            }else {
                if (mid == a.length - 1 || a[mid + 1] > key) {
                    return mid;
                }else {
                    lo = mid + 1;
                }
            }
        }
        return -1;
    }
}
