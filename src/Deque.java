import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> {
    public boolean isEmpty() {
        return N < 1;
    }

    public int size() {
        return N;
    }

    public void pushLeft(Item item) {
        DoubleNode newNode = new DoubleNode();
        newNode.item = item;
        newNode.next = left;

        if (left == null) {
            right = newNode;
        }else {
            left.previous = newNode;
        }
        left = newNode;

        N++;
    }

    public void pushRight(Item item) {
        DoubleNode newNode = new DoubleNode();
        newNode.item = item;
        newNode.previous = right;

        if (right == null) {
            left = newNode;
        }else {
            right.next = newNode;
        }
        right = newNode;

        N++;
    }

    public Item popLeft() {
        Item retItem = null;

        if (left != null) {
            retItem = left.item;
            if (left == right) {
                left = right = null;
            }else {
                left = left.next;
                left.previous = null;
            }
            N--;
        }

        return retItem;
    }

    public Item popRight() {
        Item retItem = null;

        if (right != null) {
            retItem = right.item;

            if (right == left) {
                left = right = null;
            }else {
                right = right.previous;
                right.next = null;
            }
            N--;
        }
        return retItem;
    }

    public void printList() {
        DoubleNode curNode = left;
        while (curNode != null) {
            StdOut.print(curNode.item + " ");
            curNode = curNode.next;
        }
        StdOut.println();
    }

    private DoubleNode left;
    private DoubleNode right;
    private int N;

    private class DoubleNode {
        DoubleNode previous;
        Item item;
        DoubleNode next;
    }
}
