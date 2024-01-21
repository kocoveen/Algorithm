import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int n, m;
    static List<Integer>[] graph;
    static int[] depth;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        depth = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = read();
            int b = read();
            depth[b]++;
            graph[a].add(b);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (depth[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");
            for (int i : graph[cur]) {
                depth[i]--;
                if (depth[i] == 0) {
                    q.offer(i);
                }
            }
        }
        System.out.println(sb.toString());
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}