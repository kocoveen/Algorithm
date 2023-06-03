import java.io.*;

import static java.lang.Math.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static String[] l;

    static int N, T;

    static int[][] graph = new int[100005][3];
    static int[][] dp = new int[100005][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            T++;

            for (int i = 0; i < N; i++) {
                l = br.readLine().split(" ");
                for (int j = 0; j < 3; j++)
                    graph[i][j] = Integer.parseInt(l[j]);
            }

            dp[0][0] = Integer.MAX_VALUE;
            dp[0][1] = graph[0][1];
            dp[0][2] = graph[0][1] + graph[0][2];

            for (int i = 1; i < N; i++) {
                dp[i][0] = graph[i][0] + min(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] = graph[i][1] + min(dp[i - 1][0], min(dp[i - 1][1], min(dp[i - 1][2], dp[i][0])));
                dp[i][2] = graph[i][2] + min(dp[i - 1][1], min(dp[i - 1][2], dp[i][1]));
            }

            sb.append(T).append('.').append(' ').append(dp[N - 1][1]).append('\n');
        }
        System.out.print(sb);
    }
}