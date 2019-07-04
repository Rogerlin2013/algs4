import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QueueClient {
    public static void main(String[] args) {
//        testResizingDeque();
//        testRandomQueue();
        testJosephus(2, 7);
    }

    private static void testJosephus(int m, int n) {
        Josephus josephus = new Josephus(n, m);
        josephus.printQueue();
    }

    private static void testRandomQueue() {
        RandomQueue<Integer> randomQueue = new RandomQueue<Integer>();

        for (int i = 0; i < 10; ++i) {
            randomQueue.enqueue(i);
        }

        for (int j = 0; j < 3; ++j) {
            StdOut.println("dequeue " + randomQueue.deQueue());
        }

        for (int k : randomQueue) {
            StdOut.print(k + " ");
        }
    }

    public static void testResizingDeque() {
        ResizingArrayDeque<Integer> deque = new ResizingArrayDeque<Integer>();

        deque.pushLeft(2);
        deque.pushRight(1);
        deque.pushRight(3);
        deque.pushLeft(4);
        deque.pushRight(5);

        for (Integer a: deque) {
            StdOut.print(a + " ");
        }
    }

    public static void testDeque() {
        Deque<Integer> deque = new Deque<Integer>();

        deque.pushLeft(2);
        deque.pushRight(1);
        deque.pushRight(3);
        deque.pushLeft(4);

        StdOut.println("pop " + deque.popRight());
        deque.printList();
    }

    public static void testQueue() {
        Queue2<String> queue = new Queue2<String>();

        while(!StdIn.isEmpty()) {
            String s = StdIn.readString();

            if (s.equals("-") && !queue.isEmpty()) {
                StdOut.print(queue.deQueue() + " ");
            } else {
                queue.enqueue(s);
            }
        }

        StdOut.println();
        StdOut.print(queue.size() + " items left.");
    }
}
