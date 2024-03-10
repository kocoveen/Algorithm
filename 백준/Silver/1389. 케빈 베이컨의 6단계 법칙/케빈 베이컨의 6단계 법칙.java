import java.util.*;

public class Main {

    static int n, m;
    static List<Integer>[] graph;
    static int[][] dist;
    static int mn = 5051, mnIdx;

    public static void main(String[] args) throws Exception {
        n = read(); m = read();
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        while (m-- > 0) {
            int a = read(), b = read();
            graph[a].add(b);
            graph[b].add(a);
        }

        dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] = mn;
            }
            for (int j : graph[i]) {
                dist[i][j] = 1;
            }
            dist[i][i] = 0;
        }

        floyd_warshall();
        for (int i = 1; i <= n; i++) {
            int kevin = sum(i);
            if (mn > kevin) {
                mn = kevin;
                mnIdx = i;
            }
        }
        System.out.println(mnIdx);
    }
    
    static void floyd_warshall() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    private static int sum(int i) {
        return Arrays.stream(dist[i]).sum();
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
