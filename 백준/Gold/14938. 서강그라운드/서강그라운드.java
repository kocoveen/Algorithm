import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int INF = 100001;
    static int n, m, r;
    static int[] item;
    static int[][] graph;
    static String[] split;
    static int mx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        r = Integer.parseInt(split[2]);

        item = new int[n + 1];
        split = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(split[i - 1]);
        }

        graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j] = INF;
            }
            graph[i][i] = 0;
        }

        for (int i = 1; i <= r; i++) {
            split = br.readLine().split(" ");
            int f = Integer.parseInt(split[0]);
            int t = Integer.parseInt(split[1]);
            int c = Integer.parseInt(split[2]);
            graph[f][t] = c;
            graph[t][f] = c;
        }
        
        floyd();
        for (int i = 1; i <= n; i++) {
            mx = Math.max(mx, findPossibleItem(graph[i]));
        }
        System.out.println(mx);
    }

    private static void floyd() {
        for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
        }
        }
        }
    }

    private static int findPossibleItem(int[] dist) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (m >= dist[i]) {
                sum += item[i];
            }
        }
        return sum;
    }
}