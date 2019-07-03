import java.util.Iterator;

public class ResizingArrayDeque<Item> implements Iterable<Item>{

    @Override
    public Iterator<Item> iterator() {
        return new ResizingArrayDequeIterator();
    }

    private class ResizingArrayDequeIterator implements Iterator{
        private int curIndex = left;
        private int countLeft = N;
        @Override
        public void remove() {
        }

        @Override
        public boolean hasNext() {
            return countLeft > 0;
        }

        @Override
        public Object next() {
            countLeft--;
            Item item = data[curIndex];
            curIndex = (curIndex + 1) % Capacity;

            return item;
        }
    }

    public ResizingArrayDeque() {
        Capacity = 4;
        data = (Item[]) new Object[Capacity];
    }

    public boolean isEmpty() {
        return N < 1;
    }

    public int size() {
        return N;
    }

    public void pushLeft(Item item) {
        if (isFull()) {
            resize(Capacity * 2);
        }

        if (isEmpty()) {
            data[0] = item;
            left = right = 0;
        }else {
            left = left - 1;
            if (left < 0) {
                left = left + Capacity;
            }
            data[left] = item;
        }
        N++;
    }

    public void pushRight(Item item) {
        if (isFull()) {
            resize(Capacity * 2);
        }

        if (isEmpty()) {
            data[0] = item;
            left = right = 0;
        }else {
            right = (right + 1) % Capacity;
            data[right] = item;
        }
        N++;
    }

    public Item popLeft() {
        Item retItem = null;

        if (!isEmpty()) {
            retItem = data[left];
            data[left] = null;

            left = (left + 1) % Capacity;
            N--;

            if (N < Capacity / 4) {
                resize(Capacity / 2);
            }
        }
        return retItem;
    }

    public Item popRight() {
        Item retItem = null;

        if (!isEmpty()) {
            retItem = data[right];
            data[right] = null;

            right = right - 1;
            if (right < 0) {
                right = right + Capacity;
            }
            N--;

            if (N < Capacity / 4) {
                resize(Capacity / 2);
            }
        }
        return retItem;
    }

    private boolean isFull() {
        return N == Capacity;
    }

    private void resize(int cap) {
        Item [] a = (Item[]) new Object[cap];

        for (int i = 0, index = left; i < N; ++i, index = (index + 1) % Capacity) {
            a[i] = data[index];
        }

        left = 0;
        right = N - 1;
        Capacity = cap;
        data = a;
    }

    private int left, right;
    private int N;
    private int Capacity;
    private Item[] data;
}
