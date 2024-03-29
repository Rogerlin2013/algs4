import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QueueClient {
    public static void main(String[] args) {
//        testResizingDeque();
//        testRandomQueue();
//        testJosephus(2, 7);
//        testGeneralizedQueue2();
//        testRingBuffer();
        testCopyQueue();
    }

    private static void testRingBuffer() {
        RingBuffer<Integer> queue = new RingBuffer<Integer>(8);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        StdOut.println("deQueue " + queue.deQueue());

        for (int i = 4; i < 12; ++i) {
            if (queue.isFull()) {
                break;
            }
            queue.enqueue(i);
        }

        while (!queue.isEmpty()) {
            StdOut.print(queue.deQueue() + " ");
        }
    }

    private static void testGeneralizedQueue2() {
        GeneralizedQueue2<Integer> queue = new GeneralizedQueue2<Integer>();
        for (int i = 0; i < 10; ++i) {
            queue.insert(i);
        }

        StdOut.println(queue.delete(3) + " ");
        StdOut.println(queue.delete(3) + " ");

        queue.printList();
    }

    private static void testGeneralizedQueue() {
        GeneralizedQueue<Integer> queue = new GeneralizedQueue<Integer>();
        for (int i = 0; i < 10; ++i) {
            queue.insert(i);
        }

        StdOut.println(queue.delete(3) + " ");
        StdOut.println(queue.delete(3) + " ");
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

    private static void testCopyQueue() {
        Queue<Integer> queue1 = new Queue<Integer>();

        queue1.enqueue(1);
        queue1.enqueue(2);

        StdOut.print("Queue1: ");
        queue1.printList();

        Queue<Integer> queue2 = new Queue<Integer>(queue1);
        StdOut.print("Queue2: ");
        queue2.printList();

        queue1.deQueue();

        StdOut.print("Queue1: ");
        queue1.printList();

        StdOut.print("Queue2: ");
        queue2.printList();
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
