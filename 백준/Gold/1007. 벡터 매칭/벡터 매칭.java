import java.io.IOException;

public class Main {

    private static int[] xs;
    private static int[] ys;
    private static boolean[] visited;

    private static int T, N;
    private static double mn;

    public static void main(String[] args) throws IOException {
        T = read();
        while (T-- > 0) {
            N = read();
            xs = new int[N];
            ys = new int[N];
            visited = new boolean[N];

            for (int i = 0; i < N; i++) {
                int x = read(); int y = read();
                xs[i] = x; ys[i] = y;
            }

            mn = Double.MAX_VALUE;
            backtracking(0, 0);
            System.out.println(mn);
        }
    }

    private static void backtracking(int depth, int index) {
        if (depth == N/2) {
            double x = 0; double y = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    x += xs[i];
                    y += ys[i];
                } else {
                    x -= xs[i];
                    y -= ys[i];
                }
            }

            double scalar = Math.sqrt(x * x + y * y);
            mn = Math.min(mn, scalar);
        }

        if (index == N) return;

        backtracking(depth, index + 1);
        visited[index] = true;
        backtracking(depth + 1, index + 1);
        visited[index] = false;

    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}