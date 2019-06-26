public class FixedCapacityStackOfStrings {
    public FixedCapacityStackOfStrings(int cap) {
        this.N = 0;
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

    public int size() {
        return N;
    }

    private String[] a;
    private int N;
}
