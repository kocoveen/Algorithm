import java.io.*;

public class Main {

    private static final int INF = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(split[j]);
                if (value == 0) {
                    graph[i][j] = INF;
                } else {
                    graph[i][j] = 1;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for (int[] from : graph) {
            for (int to : from) {
                if (to == INF) {
                    sb.append(0).append(" ");
                } else if (to > 0){
                    sb.append(1).append(" ");
                } else {
                    sb.append(0).append(" ");
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}