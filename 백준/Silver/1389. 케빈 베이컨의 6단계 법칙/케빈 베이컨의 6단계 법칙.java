import java.util.*;

public class Main {

    static int n, m;
    static int[][] graph;
    static int[] depth;
    static int mn = 5051, mnIdx;

    public static void main(String[] args) throws Exception {
        n = read(); m = read();
        graph = new int[n + 1][n + 1];
        while (m-- > 0) {
            int a = read(), b = read();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            int kevin = bfs(q, i);
            if (mn > kevin) {
                mn = kevin;
                mnIdx = i;
            }
        }
        System.out.println(mnIdx);
    }

    static int bfs(Queue<Integer> q, int num) {
        depth = new int[n + 1];
        Arrays.fill(depth, -1);

        q.add(num);
        while (!q.isEmpty()) {
            int cur = q.remove();
            for (int nxt = 1; nxt <= n; nxt++) {
                if (graph[cur][nxt] > 0 && depth[nxt] < 0) {
                    q.add(nxt);
                    depth[nxt] = depth[cur] + 1;
                }
            }
        }

        return Arrays.stream(depth).sum() + 1;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}