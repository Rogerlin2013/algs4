import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MoveToFront {

    public static void main(String[] args) {
        MoveToFront cache = new MoveToFront();

        while (!StdIn.isEmpty()) {
            char c = StdIn.readChar();
            cache.insert(c);
        }

        cache.printList();
    }

    public void insert(char c) {
        Node node = find(c);
        if (node != null) {
            if (node == first) {
                return;
            }
            remove(node);
        }else {
            node = new Node();
            node.item = c;
        }

        node.next = first;
        node.previous = null;

        if (first != null) {
            first.previous = node;
        }
        first = node;
    }

    private Node find(char c) {
        Node curNode = first;

        while (curNode != null) {
            if (c == curNode.item) {
                return curNode;
            }
            curNode = curNode.next;
        }

        return null;
    }

    private void remove(Node node) {
        Node previous = node.previous;
        Node next = node.next;

        if (previous != null) {
            previous.next = next;
            if (next != null) {
                next.previous = previous;
            }
        }
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
        Node previous;
        char item;
        Node next;
    }
}
