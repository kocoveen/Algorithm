import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static String[] l;
    static int T, N, M;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            l = br.readLine().split(" ");
            M = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            dp = new int[N + 1][M + 1];
            for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(l[i - 1]);
            for (int i = 1; i <= N; i++) dp[i][0] = 1; // initial condition

            for (int i = 1; i <= N; i++)
                for (int j = 1; j <= M; j++)
                    if (j < arr[i]) dp[i][j] = dp[i - 1][j];
                    else dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i]];

            sb.append(dp[N][M]).append('\n');
        }
        System.out.print(sb);
    }
}