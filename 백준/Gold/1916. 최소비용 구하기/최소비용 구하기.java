import java.io.*;
import java.util.Arrays;

public class Main {

    static final int INF = 100_000_001;
    static int[][] graph;
    static int n, m;
    static int st, en;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j] = INF;
            }
            graph[i][i] = 0;
        }

        while (m-- > 0) {
            String[] split = br.readLine().split(" ");
            int s = Integer.parseInt(split[0]);
            int e = Integer.parseInt(split[1]);
            int c = Math.min(graph[s][e], Integer.parseInt(split[2]));
            graph[s][e] = c;
        }
        String[] split = br.readLine().split(" ");
        st = Integer.parseInt(split[0]);
        en = Integer.parseInt(split[1]);

        bw.write(dijkstra(st, en) + "");
        bw.flush();
    }

    private static int dijkstra(int st, int en) {
        graph[st][st] = 0;
        boolean[] visited = new boolean[n + 1];
        int[] cost = Arrays.copyOf(graph[st], n + 1);

        visited[st] = true;
        for (int i = 1; i <= n; i++) {
            int minIndex = findMinIndex(cost, visited);
            visited[minIndex] = true;
            for (int j = 1; j <= n; j++) {
                if (visited[j]) continue;
                if (cost[j] > cost[minIndex] + graph[minIndex][j]) {
                    cost[j] = cost[minIndex] + graph[minIndex][j];
                }
            }
        }
        return cost[en];
    }

    private static int findMinIndex(int[] cost, boolean[] visited) {
        int idx = 0, min = INF;
        for (int i = 1; i <= n ; i++) {
            if (visited[i]) continue;
            if (min > cost[i]) {
                min = cost[i];
                idx = i;
            }
        }
        return idx;
    }
}