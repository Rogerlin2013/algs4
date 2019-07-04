public class RingBuffer<Item> {

    public RingBuffer(int n) {
        a = (Item[]) new Object[n];
        Capacity = n;
    }

    public boolean isEmpty() {
        return N < 1;
    }

    public boolean isFull() {
        return N == Capacity;
    }

    public void enqueue(Item item) {
        a[last] = item;
        last = (last + 1) % Capacity;

        N++;
    }

    public Item deQueue() {
        Item item = a[first];
        a[first] = null;
        first = (first + 1) % Capacity;

        N--;
        return item;
    }

    private int first;
    private int last;
    private int N;
    private int Capacity;
    private Item [] a;
}
