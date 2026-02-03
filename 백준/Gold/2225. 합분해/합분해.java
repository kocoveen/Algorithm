import java.util.Scanner;

public class Main {

    static int n, k;
    static Integer[][] dp;
    static final int C = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        dp = new Integer[n+1][k+1];

        System.out.println(dp(n, k));
    }

    // 숫자 k개를 이용해서 n 만들기
    private static int dp(int n, int k) {
        if (k == 1) return dp[n][k] = 1;
        if (dp[n][k] != null) return dp[n][k];

        int result = 0;
        for (int i = 0; i <= n; i++) {
            result = (result + dp(n-i, k-1)) % C;
        }
        return dp[n][k] = result;
    }
}