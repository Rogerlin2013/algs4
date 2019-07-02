public class LinkedListClient {
    public static void main(String[] args) {
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
