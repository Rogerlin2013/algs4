
public class ResizingArrayQueueOfStrings {
    private String [] a;
    private int N;
    private int Capacity;
    private int first;
    private int last;

    public ResizingArrayQueueOfStrings() {
        a = new String[1];
        Capacity = 1;
    }

    public void enqueue(String s) {
        if (isFull()) {
            resize(Capacity * 2);
        }

        a[last] = s;
        last = (last + 1) % Capacity;
        N++;
    }

    public String deQueue() {
        String s = a[first];
        a[first] = null;
        first = (first + 1) % Capacity;
        N--;

        if (size() < Capacity / 4) {
            resize(Capacity / 2);
        }

        return s;
    }

    public int size() {
        return N;
    }

    public boolean isFull() {
        return Capacity == N;
    }

    public boolean isEmpty() {
        return N < 1;
    }

    private void resize(int newCap) {
        String [] array = new String[newCap];
        for (int i = 0, index = first; i < N ; i++, index = (index + 1) % Capacity) {
            array[i] = a[index];
        }

        a = array;
        first = 0;
        last = N;
        Capacity = newCap;
    }
}
