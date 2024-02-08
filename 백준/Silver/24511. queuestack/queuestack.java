import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int n, m;
    static int[] qs, arr;
    static boolean[] isStack;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();

        n = read();
        qs = new int[n];
        isStack = new boolean[n];
        for (int i = 0; i < n; i++) isStack[i] = read() == 1;
        for (int i = 0; i < n; i++) qs[i] = read();

        m = read();
        for (int i = n - 1; i >= 0 && m > 0; i--) {
            if (isStack[i]) continue;
            sb.append(qs[i]).append(" "); m--;
        }

        while (m-- > 0) {
            sb.append(read()).append(" ");
        }

        System.out.print(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}