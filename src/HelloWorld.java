import edu.princeton.cs.algs4.StdOut;

public class HelloWorld {

    private static int lg(int N) {
        int result = 0;
        while( (N = (N >> 1)) != 0) {
            result++;
        }

        return result;
    }

    public static String exR1(int n)
    {
        if (n <= 0) return "";
        return exR1(n-3) + n + exR1(n-2) + n;
    }

    public static int mystery(int a, int b)
    {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery(a+a, b/2);
        return mystery(a+a, b/2) + a;
    }

    public static void main(String[] args) {
        System.out.println(mystery(3, 11));
    }
}
