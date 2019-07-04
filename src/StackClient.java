import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackClient {
    public static void main(String[] args) {
//       testStack();
        testCopyStack();
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
