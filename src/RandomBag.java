import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RandomBag<Item> implements Iterable<Item> {

    @Override
    public Iterator<Item> iterator() {
        return new RandomBagIterator();
    }

    private class RandomBagIterator implements Iterator<Item> {
        private List<Integer> indexList;
        private int curIndex = 0;

        RandomBagIterator() {
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

    public RandomBag() {
        Capacity = 4;
        N = 0;
        a = (Item[]) new Object[Capacity];
    }

    public boolean isEmpty() {
        return N < 1;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        if (size() == Capacity) {
            resize(Capacity * 2);
        }

        a[N++] = item;
    }

    private void resize(int cap) {
        Item[] array = (Item[]) new Object[cap];

        for (int i = 0; i < N; i++) {
            array[i] = a[i];
        }

        a = array;
        Capacity = cap;
    }

    private Item[] a;
    private int N;
    private int Capacity;
}
