import java.io.*;

public class Main {

    static int[][] graph;
    static final int INF = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            String string = br.readLine();
            for (int j = 0; j < n; j++) {
                if (string.charAt(j) == 'Y') {
                    graph[i][j] = 1;
                } else {
                    graph[i][j] = INF;
                }
            }
        }

        // 플로이드-워셜로 각 친구마다의 거리 구하기
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j || j == k || k == i) continue;
                    graph[i][j]  = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int ans = 0;
        for (int[] ints : graph) {
            int sum = 0;
            for (int i : ints) {
                if (i <= 2) {
                    sum++;
                }
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);

    }
}