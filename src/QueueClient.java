import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QueueClient {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();

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
