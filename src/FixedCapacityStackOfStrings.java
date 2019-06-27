public class FixedCapacityStackOfStrings {
    public FixedCapacityStackOfStrings(int cap) {
        this.N = 0;
        this.capacity = cap;
        this.a = new String[cap];
    }
    public void push(String item) {
        a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean isFull() {
        return N == capacity;
    }

    public int size() {
        return N;
    }

    private String[] a;
    private int N;
    private int capacity;
}
