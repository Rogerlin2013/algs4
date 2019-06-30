import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {

    public Iterator<Item> iterator() {
        return new LinkedListStackIterator();
    }

    private class LinkedListStackIterator implements Iterator<Item> {
        private Node node = first;

        @Override
        public Item next() {
            Item item = node.item;
            node = node.next;
            return item;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public void remove() {
        }
    }

    public Stack() {
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item newItem) {
        Node newNode = new Node();
        newNode.item = newItem;
        newNode.next = first;
        first = newNode;
        N++;
    }

    public Item pop() {
        Node oldFirst = first;

        first = oldFirst.next;
        N--;
        return oldFirst.item;
    }

    public Item peek() {
       return first.item;
    }

    private int N;
    private Node first;
    private class Node {
        Item item;
        Node next;
    }
}
