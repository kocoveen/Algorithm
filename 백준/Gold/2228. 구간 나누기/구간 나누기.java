import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] sum;
    static Integer[][] dp;
    static final int MIN = -5000000;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        sum = new int[N+1];
        dp = new Integer[N+1][M+1]; // n까지 고려할 때 m개의 구간을 선택할 때

        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i-1] + sc.nextInt();
        }

        System.out.println(dp(N, M));
    }

    private static int dp(int n, int m) {
        if (m == 0) return 0;
        if (n < 0) return MIN;
        if (dp[n][m] != null) return dp[n][m];

        // n을 선택하지 않을 때
        int result = dp(n-1, m);

        // n을 선택할 때
        for (int k = n; k >= 1; k--) {
            int prev = dp(k-2, m-1);

            if (prev != MIN) {
                result = Math.max(result, prev + (sum[n] - sum[k-1]));
            }
        }
        
        return dp[n][m] = result;
    }
}