import java.io.*;

public class Main {

    static String[] st;
    static int[] costs;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 구매하려는 카드 수

        st = br.readLine().split(" ");
        costs = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            costs[i] = Integer.parseInt(st[i - 1]);
            dp[i] = 10000000;
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + costs[j]);
            }
        }
        System.out.println(dp[n]);
    }
}