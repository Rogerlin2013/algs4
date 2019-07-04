public class GeneralizedQueue<Item> {

    public GeneralizedQueue() {
        Capacity = 4;
        a = (Item[] )new Object[Capacity];
    }

    public boolean isEmpty() {
        return N < 1;
    }

    public void insert(Item item) {
        if (N == Capacity) {
            resize(Capacity * 2);
        }

        a[N++] = item;
    }

    public Item delete(int k) {
        if (k < 1 || k > N) {
            return null;
        }

        int index = N - k;
        Item value = a[index++];
        while(index < N) {
            a[index - 1] = a[index++];
        }
        N--;
        a[N] = null;

        if (N < Capacity / 4) {
            resize(Capacity / 2);
        }

        return value;
    }

    private void resize(int cap) {
        Item[] array = (Item[]) new Object[cap];

        for (int i = 0; i < N; ++i) {
            array[i] = a[i];
        }

        Capacity = cap;
        a = array;
    }

    private int N;
    private int Capacity;
    private Item[] a;
}
