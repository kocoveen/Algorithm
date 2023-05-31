import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int T, N;

    static Integer[] fib;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        fib = new Integer[45];
        fib[0] = 0; fib[1] = 1;
        func(42);

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                sb.append(1).append(" ").append(0).append('\n');
                continue;
            }
            sb.append(fib[N - 1]).append(" ").append(fib[N]).append('\n');
        }
        System.out.println(sb);
    }

    private static void func(int n) {
        for (int i = 2; i <= n; i++) fib[i] = fib[i - 1] + fib[i - 2];
    }
}
