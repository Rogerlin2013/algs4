import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackClient {
    public static void main(String[] args) {
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
