import java.io.*;

public class Main {
    static int n;
    static int C = 10007;

    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new Integer[1001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] % C + 2 * dp[i - 2] % C) % C;
        }

        System.out.println(dp[n]);
    }
}