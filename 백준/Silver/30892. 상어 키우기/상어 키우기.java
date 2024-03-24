import java.util.Arrays;
import java.util.Stack;

public class Main {

    static int n, k;
    static long t;
    static long[] A;

    public static void main(String[] args) throws Exception {
        n = read(); k = read(); t = read();
        A = new long[n];
        for (int i = 0; i < n; i++) {
            A[i] = read();
        }
        Arrays.sort(A);

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n && k > 0; i++) {
            while (!s.isEmpty() && t <= A[i]) {
                t += A[s.pop()];
                k--;
            }
            if (t > A[i]) s.push(i);
        }

        while (!s.isEmpty() && k-- > 0) {
            t += A[s.pop()];
        }
        System.out.println(t);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}