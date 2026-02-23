import java.util.Scanner;

public class Main {
    static int N;
    static int[] arr;
    static Integer[][] dp; // n~m 을 수확할 때 최고 수확량

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        dp = new Integer[N][N];

        System.out.println(dp(0, N-1));
    }

    private static int dp(int n, int m) {
        if (n > m || n >= N || m < 0) return 0;
        if (dp[n][m] != null) return dp[n][m];

        // dp[n][m] = max(dp[n][m-1] + arr[m] * k, dp[n+1][m] + arr[n] * k)
        int k = N - (m-n); // 수확순서
        
        return dp[n][m] = Math.max(dp(n, m-1) + arr[m] * k, dp(n+1, m) + arr[n] * k);
    }
}