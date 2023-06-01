import java.io.*;

public class Main {
    static String[] l;
    static int T, W;
    static int max;

    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        T = Integer.parseInt(l[0]);
        W = Integer.parseInt(l[1]);

        arr = new int[T + 1];
        for (int i = 1; i <= T; i++) arr[i] = Integer.parseInt(br.readLine()) - 1;

        dp = new int[W + 1][T + 1];

        for (int i = 1; i <= T; i++) {
            if (arr[i] == 0) dp[0][i] = dp[0][i - 1] + 1;
            else dp[0][i] = dp[0][i - 1];
        }

        for (int i = 1; i <= W; i++) {
            for (int j = 1; j <= T; j++) {
                if (i % 2 != arr[j]) dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                else dp[i][j] = dp[i][j - 1] + 1;
            }
        }

        System.out.println(dp[W][T]);

    }
}