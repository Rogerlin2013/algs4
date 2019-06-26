

public class Queue<Item> {
    public Queue() {
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

    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }
}
