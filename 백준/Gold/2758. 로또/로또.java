import java.util.Scanner;

public class Main {

    static int t, n, m;
    static Long[][] dp = new Long[11][2001];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        while (t-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            System.out.println(dp(n, m));
        }
    }

    private static long dp(int n, int m) {
        if (m <= 0) return 0;
        if (n == 1) return m;

        if (dp[n][m] != null) {
            return dp[n][m];
        }

        return dp[n][m] = dp(n-1, m/2) + dp(n, m-1); // n에서 m고르기 + n에서 m 고르지 않기(m-1 고름)
    }
}