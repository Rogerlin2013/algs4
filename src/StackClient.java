import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackClient {
    public static void main(String[] args) {
//       testStack();
//        testCopyStack();
//        testBuffer();
//        StdOut.println(testStackUnderFlow());
        StdOut.println(testPermutationValid());
    }

    private static boolean testPermutationValid() {
        Stack<Integer> stack = new Stack<Integer>();
        int nextToPush = 0;

        while (!StdIn.isEmpty()) {
            int i = StdIn.readInt();

            if (i >= nextToPush) {
                while (i >= nextToPush) {
                    stack.push(nextToPush);
                    if (i == nextToPush) {
                        stack.pop();
                    }
                    nextToPush++;
                }
            }else {
                if (stack.isEmpty()) {
                    return false;
                }

                int j = stack.pop();
                while (j != i) {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    j = stack.pop();
                }
            }
        }

        return true;
    }

    private static boolean testStackUnderFlow() {
        int N = 0;
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();

            if (s.equals("-")) {
                if (N == 0) {
                    return true;
                }
                N--;
            }else {
                N++;
            }
        }

        return false;
    }

    private static void testBuffer() {
        Buffer buffer = new Buffer();

        buffer.insert('a');
        buffer.insert('b');
        buffer.insert('c');
        buffer.insert('d');
        StdOut.println("current : " + buffer.get());

        StdOut.println("delete : " + buffer.delete());
        StdOut.println(buffer.size() + "char left");


        buffer.left(2);
        StdOut.println("current : " + buffer.get());

        buffer.right(1);
        StdOut.println("current : " + buffer.get());
    }

    private static void printStack(Stack<Integer> stack, String stackDes) {
        StdOut.println(stackDes);
        for (int s : stack) {
            StdOut.print(s + " ");
        }
        StdOut.println();
    }
    private static void testCopyStack() {
        Stack<Integer> stack1 = new Stack<Integer>();
        stack1.push(1);
        stack1.push(2);

        printStack(stack1, "stack1: ");

        Stack<Integer> stack2 = new Stack<Integer>(stack1);
        printStack(stack2, "stack2: ");

        stack1.pop();

        printStack(stack1, "stack1: ");
        printStack(stack2, "stack2: ");
    }

    private static void testStack() {
        Stack<String> stack = new Stack<String>();

        while(!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-") && !stack.isEmpty()) {
                StdOut.print(stack.pop() + " ");
            }else {
                stack.push(s);
            }
        }
        StdOut.println();
        StdOut.println(stack.size() + " items left.");

        for (String s : stack) {
            StdOut.print(s + " ");
            StdOut.println();
        }
    }
}
