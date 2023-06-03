import java.io.*;

public class Main {
    static int N, C = 10007;

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 2][11];
        dp[1][0] = 1;

        for (int i = 1; i <= N + 1; i++)
            for (int j = 1; j <= 10; j++)
                dp[i][j] = (dp[i][j - 1] % C + dp[i - 1][j] % C) % 10007;
        System.out.println(dp[N + 1][10]);
    }
}