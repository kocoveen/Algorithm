import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static List<Integer>[] graph;
    static boolean[] visit;
    static int[] dists;
    static class Info {
        int num, dist;

        public Info(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        n = read(); m = read();
        graph = new List[n + 1];
        visit = new boolean[n + 1];
        dists = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            int a = read();
            int b = read();
            graph[b].add(a);
            graph[a].add(b);
        }

        int x = 0, y = 0, z = 0;

        y = bfs(y);

        for (int i = n; i > 0; i--) {
            if (y == dists[i]) {
                x = i;
                z++;
            }
        }
        System.out.println(x + " " + y + " " + z);
    }

    static int bfs(int y) {
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(1, 0));
        visit[1] = true;
        while (!q.isEmpty()) {
            Info cur = q.poll();
            int dist = cur.dist;
            for (int i : graph[cur.num]) {
                if (visit[i]) continue;
                q.add(new Info(i, dist + 1));
                visit[i] = true;
                dists[i] = dist + 1;
            }
            y = dist;
        }
        return y;
    }

    static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read(); // c == '\r' -> '\n'. for CRLF(Windows)
        return n;
    }
}