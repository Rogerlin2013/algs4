import edu.princeton.cs.algs4.StdOut;

public class Steque<Item> {

    public boolean isEmpty() {
        return N < 1;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = first;

        if (last == null) {
            last = newNode;
        }
        first = newNode;

        N++;
    }

    public Item pop() {
        Item retValue = null;

        if (first != null) {
            retValue = first.item;
            if (first == last) {
                first = last = null;
            }else {
                first = first.next;
            }
            N--;
        }
        return retValue;
    }

    public void enqueue(Item item) {
        Node newNode = new Node();
        newNode.item = item;

        if (last != null) {
            last.next = newNode;
        }else {
            first = newNode;
        }
        last = newNode;

        N++;
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
