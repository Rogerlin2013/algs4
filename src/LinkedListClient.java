import edu.princeton.cs.algs4.StdOut;

public class LinkedListClient {
    public static void main(String[] args) {
        testSteque();
    }

    public static void testSteque() {
        Steque<Integer> steque = new Steque<Integer>();

//        steque.enqueue(1);
        steque.push(2);
        steque.enqueue(1);
        steque.push(3);
        steque.enqueue(4);
        steque.printList();
        StdOut.println(steque.size());
    }

    public static void testLinkedList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();

        for (int i = 1; i < 10; ++i) {

//            list.insertTail(i);
            list.insertHead(i);
        }
//        for (int i = 1; i < 9; ++i) {
//
//            list.removeTail();
//            list.removeHead();
//        }

//        list.removeHead();
//        list.removeHead();
//        list.insertAfterNodeAtPos(9, 90);
//        list.insertBeforeNodeAtPos(1, 80);
        list.removeNodeAtPos(2);

        list.printList();
    }
}
