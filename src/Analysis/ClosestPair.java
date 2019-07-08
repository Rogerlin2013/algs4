package Analysis;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class ClosestPair {

    public static void main(String[] args) {
        double a[] = { -4.5, -4.0,  0, 5, 10, 13.001, 12, 20};
        closestPair(a);
    }

    private static void closestPair(double [] a) {
        Arrays.sort(a);
        double delta = a[a.length - 1] - a[0];
        double valueA = 0;
        double valueB = 0;

        for (int i = 0; i < a.length - 1; ++i) {
            double temp = a[i + 1] - a[i];
            if (temp < delta) {
                delta = temp;
                valueA = a[i];
                valueB = a[i + 1];
            }
        }

        StdOut.println("Values: " + valueA + ", " + valueB);

    }
}
