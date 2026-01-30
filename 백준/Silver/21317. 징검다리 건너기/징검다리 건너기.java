import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n, k;
    static int[][] A;
    static Integer[] dp;
    static final int MAX = 987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        A = new int[n][2]; // 작은 점프 A[i][0], 큰 점프 A[i][1]
        for (int i = 0; i < n-1; i++) {
            A[i][0] = sc.nextInt();
            A[i][1] = sc.nextInt();
        }
        k = sc.nextInt();
        dp = new Integer[n];
        dp[0] = 0;

        dp(n-1, false);
        
        System.out.println(dp[n-1]);
    }

    private static int dp(int i, boolean BFJumped) {
        if (i == 0) {
            return dp[i];
        } else if (i == 1) {
            return dp[i] = dp(i-1, BFJumped) + A[i-1][0];
        } else if (i == 2) {
            return dp[i] = min(dp(i-1, BFJumped) + A[i-1][0], dp(i-2, BFJumped) + A[i-2][1]);
        } else if (i >= 3) {
            if (BFJumped) {
                return dp[i] = min(dp(i-1, BFJumped) + A[i-1][0], dp(i-2, BFJumped) + A[i-2][1]);
            } else {
                return dp[i] = min(dp(i-1, BFJumped) + A[i-1][0], dp(i-2, BFJumped) + A[i-2][1], dp(i-3, true) + k);
            }
        }
        return MAX;
    }

    private static int min(int... values) {
        return Arrays.stream(values).min().orElse(MAX);
    }
}