import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EvaluatePostFix {

    public static void main(String[] args) {
        Stack<Double> operands = new Stack<Double>();

        while(!StdIn.isEmpty()) {
            String inputString = StdIn.readString();

            if (inputString.equals("+") ||
                    inputString.equals("-") ||
                    inputString.equals("*") ||
                    inputString.equals("/")) {

                double operand2 = operands.pop();
                double operand1 = operands.pop();

                if (inputString.equals("+")) {
                    operands.push(operand1 + operand2);
                }else if (inputString.equals("-")) {
                    operands.push(operand1 - operand2);
                }else if (inputString.equals("*")) {
                    operands.push(operand1 * operand2);
                }else if (inputString.equals("/")) {
                    operands.push(operand1 / operand2);
                }
            }else {
                operands.push(Double.parseDouble(inputString));
            }
        }
        StdOut.println(operands.pop());
    }

}
