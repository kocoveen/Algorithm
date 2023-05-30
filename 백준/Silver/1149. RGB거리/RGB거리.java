import java.io.*;

public class Main {
    static String[] l;

    static int[][] cost;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1][3];
        cost = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            l = br.readLine().split(" ");
            for (int j = 0; j < 3; j++)
                cost[i][j] = Integer.parseInt(l[j]);
        }

        dp[1][0] = cost[1][0];
        dp[1][1] = cost[1][1];
        dp[1][2] = cost[1][2];

        System.out.println(Math.min(func(N, 1), Math.min(func(N, 2), func(N, 0))));
    }

    private static int func(int n, int c) {
        if (dp[n][c] == null) {
            dp[n][c] = Math.min(func(n - 1, (c + 1) % 3), func(n - 1, (c + 2) % 3)) + cost[n][c];
        }
        return dp[n][c];
    }

}
