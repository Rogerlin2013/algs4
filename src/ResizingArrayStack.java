import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {

    @Override
    public Iterator<Item> iterator() {
        return new ArrayReverseIterator();
    }

    public ResizingArrayStack(int cap) {
        this.N = 0;
        this.a = (Item[])new Object[cap];
    }
    public void push(Item item) {
        if (N == a.length) {
            resize(N * 2);
        }
        a[N++] = item;
    }

    public Item pop() {
        Item s = a[--N];
        a[N] = null;
        if (N >= 0 && N < a.length / 4) {
            resize(a.length / 2);
        }

        return s;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int newSize) {
        Item [] array = (Item[]) new Object[newSize];

        for (int i = 0; i < N; ++i) {
            array[i] = a[i];
        }

        a = array;
    }

    private Item[] a;
    private int N;


    class ArrayReverseIterator implements Iterator<Item> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {
        }
    }
}
