import edu.princeton.cs.algs4.StdOut;

public class Queue<Item> {
    public Queue() {
    }

    public Queue(Queue<Item> r) {
        Queue<Item> k = new Queue<Item>();
        while (!r.isEmpty()) {
            Item item = r.deQueue();
            k.enqueue(item);
            this.enqueue(item);
        }

        while (!k.isEmpty()) {
            Item item = k.deQueue();
            r.enqueue(item);
        }
    }

    public void enqueue(Item newNode) {
        Node oldLast = last;
        last = new Node();
        last.item = newNode;
        last.next = null;

        if (oldLast == null) {
            first = last;
        }else {
            oldLast.next = last;
        }

        N++;
    }

    public Item deQueue() {
        Item item = first.item;
        first = first.next;
        if (first == null) {
            last = null;
        }

        N--;

        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void printList() {
        Node curNode = first;
        while (curNode != null) {
            StdOut.print(curNode.item + " ");
            curNode = curNode.next;
        }
        StdOut.println();
    }

    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }
}
