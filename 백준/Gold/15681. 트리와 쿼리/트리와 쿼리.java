import java.io.*;
import java.util.ArrayList;

public class Main {

    static ArrayList<Integer>[] child;
    static int[] size;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = read(), r = read(), q = read();

        child = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            child[i] = new ArrayList<>();
        }
        size = new int[n+1];

        for (int i = 0; i < n-1; i++) {
            int a = read();
            int b = read();
            child[a].add(b);
            child[b].add(a);
        }

        size[r] = dfs(r, 0);

        while (q-- > 0) {
            int w = read();
            sb.append(size[w]).append('\n');
        }
        System.out.print(sb);
    }

    private static int dfs(int cur, int root) {
        int sum = 1;
        for (Integer i : child[cur]) {
            if (i != root) {
                sum += dfs(i, cur);
            }
        }
        return size[cur] = sum;
    }

    static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }
}