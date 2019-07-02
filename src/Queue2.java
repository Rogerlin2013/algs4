
public class Queue2<Item> {

    public void enqueue(Item item) {
        Node newNode = new Node();
        newNode.item = item;
        if (isEmpty()) {
            last = newNode;
            last.next = newNode;
        }else {
            Node oldLast = last;
            last = newNode;
            last.next = oldLast.next;
            oldLast.next = newNode;
        }

        N++;
    }

    public Item deQueue() {
        Item retItem = null;
        if (N == 1) {
            retItem = last.item;
            last = null;
            N--;
        }else if (N > 1) {
            Node first = last.next;
            retItem = first.item;
            last.next = first.next;
            N--;
        }

        return retItem;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private int N;
    private Node last;

    private class Node {
        Item item;
        Node next;
    }
}
