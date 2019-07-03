import edu.princeton.cs.algs4.StdOut;

public class DoublyLinkedList<Item> {


    public void insertBeforeNodeAtPos(int pos, Item item) {
        DoubleNode node3 = getNodeAt(pos);
        insertBefore(node3, item);
    }

    public void insertAfterNodeAtPos(int pos, Item item) {
        DoubleNode node = getNodeAt(pos);
        insertAfter(node, item);
    }

    public void removeNodeAtPos(int pos) {
        DoubleNode node = getNodeAt(pos);
        remove(node);
    }

    public void insertHead(Item item) {
        DoubleNode newNode = new DoubleNode();
        newNode.item = item;
        if (first == null) {
            first = last = newNode;
        }else {
            newNode.next = first;
            first.previous = newNode;

            first = newNode;
        }
    }

    public void insertTail(Item item) {
        DoubleNode newNode = new DoubleNode();
        newNode.item = item;

        if (last == null) {
            first = last = newNode;
        }else {
            last.next = newNode;
            newNode.previous = last;

            last = newNode;
        }
    }

    public void removeHead() {
        if (first == null) {
            return;
        }else if (first == last) {
            first = last = null;
        }else {
            first = first.next;
            first.previous = null;
        }
    }

    public void removeTail() {
        if (last == null) {
            return;
        }else if (last == first) {
            first = last = null;
        }else {
            last = last.previous;
            last.next = null;
        }
    }

    public void insertBefore(DoubleNode node, Item item) {
        if (node == null) {
            return;
        }
        if (node.previous == null) {
            insertHead(item);
        }else {
            DoubleNode oldPre = node.previous;

            DoubleNode newNode = new DoubleNode();
            newNode.item = item;
            newNode.previous = oldPre;
            newNode.next = node;

            node.previous = newNode;
            oldPre.next = newNode;
        }
    }

    public void insertAfter(DoubleNode node, Item item) {
        if (node == null) {
            return;
        }
        DoubleNode nodeNext = node.next;

        if (nodeNext == null) {
            insertTail(item);
        }else {
            insertBefore(nodeNext, item);
        }
    }

    public void remove(DoubleNode node) {
        if (node == null) {
            return;
        }

        if (node.previous == null) {
            removeHead();
        }else if (node.next == null) {
            removeTail();
        }else {
            DoubleNode preNode = node.previous;
            DoubleNode nextNode = node.next;
            preNode.next = nextNode;
            nextNode.previous = preNode;
        }
    }

    public void printList() {
        DoubleNode curNode = first;
        while (curNode != null) {
            StdOut.print(curNode.item + " ");
            curNode = curNode.next;
        }
        StdOut.println();
    }

    private DoubleNode getNodeAt(int pos) {
        DoubleNode retNode = first;
        int i = 1;

        while (retNode != null && i < pos) {
            retNode = retNode.next;
            i++;
        }

        if (i < pos) {
            return null;
        }else {
            return retNode;
        }

    }

    private DoubleNode first;
    private DoubleNode last;

    private class DoubleNode {
        DoubleNode previous;
        Item item;
        DoubleNode next;
    }
}
