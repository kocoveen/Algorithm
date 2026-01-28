import java.util.Scanner;

public class Main {

    static int n;
    static int[] A;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        A = new int[n];
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
            dp[i] = -1;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dp(i));
        }
        System.out.println(result);
    }

    private static int dp(int i) {
        if (dp[i] != -1) return dp[i];

        int maxSum = A[i];
        for (int j = 0; j < i; j++) {
            if (A[j] < A[i]) {
                maxSum = Math.max(maxSum, dp(j) + A[i]);
            }
        }
        return dp[i] = maxSum;
    }
}
