import edu.princeton.cs.algs4.StdOut;

public class Josephus {

    public Josephus(int cap, int m) {
        size = cap;
        M = m;
        a = new Entity[cap];
        for (int i = 0; i < cap; ++i) {
            Entity entity = new Entity();
            entity.item = i;
            entity.eliminated = false;

            a[i] = entity;
        }
    }

    public void printQueue() {
        int index = 0;
        int stepCount = 0;
        int count = 0;

        while(count < size) {
            Entity entity = a[index];
            if (!entity.eliminated) {
                stepCount++;
            }
            if (stepCount == M) {
                StdOut.print(entity.item + " ");
                entity.eliminated = true;
                stepCount = 0;
                count++;
            }
            index = (index + 1) % size;
        }

    }

    private int M;
    private int size;
    private Entity[] a;
    private class Entity {
        int item;
        boolean eliminated;
    }
}
