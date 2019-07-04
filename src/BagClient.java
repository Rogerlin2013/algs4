import edu.princeton.cs.algs4.StdOut;

public class BagClient {

    public static void main(String[] args) {
        testRandomBag();
    }

    private static void testRandomBag() {
        RandomBag<Integer> bag = new RandomBag<Integer>();

        for (int i = 0; i < 10; ++i) {
            bag.add(i);
        }

        for (Integer i : bag) {
            StdOut.print(i + " ");
        }
    }
}
