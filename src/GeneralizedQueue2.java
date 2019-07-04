import edu.princeton.cs.algs4.StdOut;

public class GeneralizedQueue2<Item> {

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(Item x) {
        Node node = new Node();
        node.item = x;
        node.next = first;

        first = node;
    }

    public Item delete(int k) {
        Item retItem = null;

        Node previous = null;
        Node current = first;
        int pos = 1;

        while (current != null && pos < k) {
            previous = current;
            current = current.next;
            pos++;
        }

        if (pos == k && current != null) {
            retItem = current.item;
            if (previous == null) {
                first = first.next;
            }else {
                previous.next = current.next;
            }
        }
        return retItem;
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

    private class Node {
        Item item;
        Node next;
    }
}
