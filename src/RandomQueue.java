import java.util.*;

public class RandomQueue<Item> implements Iterable<Item> {

    @Override
    public Iterator<Item> iterator() {
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator<Item> {
        private List<Integer> indexList;
        private int curIndex = 0;

        RandomIterator() {
            indexList = new ArrayList<Integer>();
            for (int i = 0; i < N; ++i) {
                indexList.add(i);
            }
            Collections.shuffle(indexList);
        }

        @Override
        public boolean hasNext() {
            return curIndex < N;
        }

        @Override
        public Item next() {
            return a[indexList.get(curIndex++)];
        }

        @Override
        public void remove() {
        }
    }

    public RandomQueue() {
        Capacity = 5;
        a = (Item[])new Object[Capacity];
    }

    public boolean isEmpty() {
        return N < 1;
    }

    public void enqueue(Item item) {
        if (N == Capacity) {
            resize(Capacity * 2);
        }

        a[N++] = item;
    }

    public Item deQueue() {
        if (isEmpty()) {
            return null;
        }
        int index = randomIndex();
        Item temp = a[index];
        a[index] = a[N - 1];
        a[N - 1] = null;

        N--;
        return temp;
    }

    public Item sample() {
        if (isEmpty()) {
            return null;
        }

        return a[randomIndex()];
    }

    private int randomIndex() {
        Random r = new Random();
        return r.nextInt(N - 1);
    }

    private void resize(int cap) {
        Item[] array = (Item[])new Object[cap];
        for (int i = 0; i < N; ++i) {
            array[i] = a[i];
        }

        Capacity = cap;
        a = array;
    }

    private int Capacity;
    private int N;
    private Item [] a;
}
