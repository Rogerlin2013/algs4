import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Evaluate {

    public static void main(String[] args) {
        Stack<Double> operands = new Stack<Double>();
        Stack<String> operators = new Stack<String>();

        while(!StdIn.isEmpty()) {
            String inputString = StdIn.readString();

            if (inputString.equals("+") ||
                inputString.equals("-") ||
                inputString.equals("*") ||
                inputString.equals("/")) {
                operators.push(inputString);
            }else if (inputString.equals(")")) {
                String operator = operators.pop();
                double operand2 = operands.pop();
                double operand1 = operands.pop();
                if (operator.equals("+")) {
                    operands.push(operand1 + operand2);
                }else if (operator.equals("-")) {
                    operands.push(operand1 - operand2);
                }else if (operator.equals("*")) {
                    operands.push(operand1 * operand2);
                }else if (operator.equals("/")) {
                    operands.push(operand1 / operand2);
                }
            }else if (inputString.equals("("));
            else {
                operands.push(Double.parseDouble(inputString));
            }
        }
        StdOut.println(operands.pop());
    }
}
