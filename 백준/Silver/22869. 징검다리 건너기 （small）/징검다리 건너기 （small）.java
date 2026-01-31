import java.util.Scanner;

public class Main {
    static int n, k;
    static int[] A;
    static boolean[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
    
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        dp = new boolean[n];
        dp(0);

        System.out.print(dp[n-1] ? "YES" : "NO");
    }

    private static void dp(int i) {
        dp[i] = true;

        for (int j = i + 1; j < n; j++) {
            if (dp[j]) continue;
            int f = (j - i) * (1 + Math.abs(A[j] - A[i]));
            if (f <= k) dp(j);
        }
    }
}
