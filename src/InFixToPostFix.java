import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class InFixToPostFix {
    public static void main(String[] args) {
        Stack<String> opStack = new Stack<String>();
        Stack<String> valueStack = new Stack<String>();

        while(!StdIn.isEmpty()) {
            String s = StdIn.readString();

            if (s.equals("+") ||
                    s.equals("-") ||
                    s.equals("*") ||
                    s.equals("/")) {
                opStack.push(s);
            } else if (s.equals(")")) {
                String rValue = valueStack.pop();
                String lValue = valueStack.pop();
                String op = opStack.pop();
                valueStack.push(lValue + rValue + op);
            }else if (s.equals("(")) {

            }else {
                valueStack.push(s);
            }
        }

        if (!valueStack.isEmpty()) {
            StdOut.println(valueStack.pop());
        }
    }
}
