package Analysis;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class DoublingTest {

    private static double timeTrial(int N) {
        int MAX = 1000000;
        int []a = new int[N];

        for (int i = 0; i < N; ++i) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }

        Stopwatch stopwatch = new Stopwatch();
        int count = ThreeSum.count(a);
        return stopwatch.elapsedTime();
    }

    public static void main(String[] args) {
        StdDraw.setXscale(3, 12);
        StdDraw.setYscale(-5, 6);
        StdDraw.setPenColor(255, 0, 0);
        StdDraw.setPenRadius(0.02);
        for (int N = 250; true; N += N) {
            double time = timeTrial(N);

            double x = Math.log(N);
            double y = Math.log(time);
            StdDraw.point(x, y);
            StdOut.printf("%7d %5.1f\n", (int)x, y);
        }
    }
}
