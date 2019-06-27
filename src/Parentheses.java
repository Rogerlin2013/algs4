import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {

    private static boolean isLeftString(String s) {
        return s.equals("{") || s.equals("[") || s.equals("(");
    }

    private static boolean isRightString(String s) {
        return s.equals("}") || s.equals("]") || s.equals(")");
    }

    private static boolean isMatch(String left, String right) {
        if (left.equals("{") && right.equals("}")) {
            return true;
        }else if (left.equals("[") && right.equals("]")) {
            return true;
        }else if (left.equals("(") && right.equals(")")) {
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        boolean valid = false;

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();

            if (isLeftString(s)) {
                stack.push(s);
            }else if (isRightString(s)) {
                if (stack.isEmpty()) {
                    stack.push(s);
                    break;
                }else {
                    String top = stack.pop();
                    if (!isMatch(top, s)) {
                        stack.push(top);
                        break;
                    }
                }
            }
        }

        StdOut.println(stack.size());
    }
}
