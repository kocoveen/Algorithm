import java.util.Scanner;

public class Main {
    static int N, A;
    static int[] arr;
    static Long[][] dp;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt() - 1;
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        A = sc.nextInt();

        dp = new Long[N+1][21];

        System.out.println(dp(N-1, A));
    }

    private static long dp(int i, int j) {
        if (j < 0 || j > 20) return 0;

        if (i == 0) {
            if (j == arr[0]) {
                return 1L;
            } else {
                return 0;
            }
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        return dp[i][j] = dp(i-1, j-arr[i]) + dp(i-1, j+arr[i]);
    }
}