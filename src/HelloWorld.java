import edu.princeton.cs.algs4.StdOut;

public class HelloWorld {

    private Node list;

    public static void main(String[] args) {

        HelloWorld test = new HelloWorld();

        for (int i = 9; i > 0; i--) {
            test.appendValue(i);
            test.appendValue(i);
        }
//        for (int i = 9; i > 0; i--) {
//            test.appendValue(i);
//            test.appendValue(i);
//        }
//        StdOut.println(test.find(6));
//        test.delete(1);
//        test.delete(5);
//        StdOut.println(test.find(6));
//        test.delete(10);
//        test.delete(9);
        test.printList();

        Node node = test.getNode(1);
//        if (removeAfter(node)){
//            test.printList();
//        }
//        test.remove(7);
        test.list = reverse2(node);
        test.printList();
//        StdOut.println(max2(test.list));
    }

    public static Node reverse(Node node) {
        Node newHead = null;
        Node curHead = node;

        while(curHead != null) {
            Node tempNode = curHead;
            curHead = tempNode.next;
            tempNode.next = newHead;
            newHead = tempNode;
        }
        return newHead;
    }

    public static Node reverse2(Node node) {
        Node subHead = node.next;
        if (subHead == null) {
            return node;
        }
        Node newSubHead = reverse2(subHead);
        subHead.next = node;
        node.next = null;
        return newSubHead;
    }

    public static int max(Node node) {
        int maxValue = 0;
        while(node != null) {
            if (node.value > maxValue) {
                maxValue = node.value;
            }
            node = node.next;
        }
        return maxValue;
    }

    public static int max2(Node node) {
        if (node == null) {
            return 0;
        }

        return Math.max(node.value, max2(node.next));
    }

    public static boolean removeAfter(Node node) {
        if (node == null || node.next == null) {
            return false;
        }

        node.next = node.next.next;
        return true;
    }

    public void remove(int key) {
        Node newList = new Node();
        newList.next = list;

        Node preNode = newList;
        Node curNode = list;
        Node nextNode = list.next;

        while (curNode != null) {
            if (curNode.value == key) {
                preNode.next = nextNode;

            }else {
                preNode = curNode;
            }
            curNode = nextNode;
            if (nextNode != null) {
                nextNode = nextNode.next;
            }
        }
    }

    public boolean find(int key) {
        Node curNode = list;
        while (curNode != null) {
            if (curNode.value == key) {
                return true;
            }
            curNode = curNode.next;
        }
        return false;
    }

    public Node getNode(int pos) {
        Node curNode = list;
        int i = 1;

        while(curNode != null && i < pos) {
            curNode = curNode.next;
            i++;
        }

        if (i == pos) {
            return curNode;
        }
        return null;
    }

    private void printList() {
        Node curNode = list;
        while (curNode != null) {
            StdOut.print(curNode.value + " ");
            curNode = curNode.next;
        }
        StdOut.println();
    }

    private void appendValue(int i) {
        Node newNode = new Node();
        newNode.value = i;
        newNode.next = list;
        list = newNode;
    }

    private boolean delete(int k) {

        if (k < 1) {
            return false;
        }else if (k == 1) {
            list = list.next;
            return true;
        }

        Node preNode = null;
        Node curNode = list;
        Node nextNode = list.next;
        int i = 1;

        while(nextNode != null && i < k) {
            preNode = curNode;
            curNode = nextNode;
            nextNode = nextNode.next;
            i++;
        }

        if (i < k) {
            return false;
        }

        preNode.next = nextNode;
        return true;
    }

    private class Node {
        int value;
        Node next;
    }

}
