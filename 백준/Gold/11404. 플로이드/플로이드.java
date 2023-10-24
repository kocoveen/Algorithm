import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    private static final int INF = 100000000;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    graph[i][j] = INF;
                } else {
                    graph[i][j] = 0;
                }
            }
        }

        while (m-- > 0) {
            String[] split = br.readLine().split(" ");
            int s = Integer.parseInt(split[0]) - 1;
            int e = Integer.parseInt(split[1]) - 1;
            int c = Integer.parseInt(split[2]);
            graph[s][e] = Math.min(c, graph[s][e]);
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for (int[] i : graph) {
            for (int j : i) {
                if (j != INF) {
                    sb.append(j);
                } else {
                    sb.append(0);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

}