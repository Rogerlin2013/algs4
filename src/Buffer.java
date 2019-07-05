
public class Buffer {

    public Buffer() {
        leftStack = new Stack<Character>();
        rightStack = new Stack<Character>();
    }

    public void insert(char c) {
        leftStack.push(c);
    }

    public char get() {
        return leftStack.peek();
    }

    public char delete() {
        return leftStack.pop();
    }

    public void left(int k) {
        if (leftStack.size() > k) {
            int i = k;
            while (i > 0) {
                rightStack.push(leftStack.pop());
                i--;
            }
        }
    }

    public void right(int k) {
        if (rightStack.size() > k) {
            int i = k;
            while (i > 0) {
                leftStack.push(rightStack.pop());
                i--;
            }
        }
    }

    public int size() {
        return leftStack.size() + rightStack.size();
    }

    private Stack<Character> leftStack;
    private Stack<Character> rightStack;
}
