import java.util.Scanner;

public class Main {
    static int t, n;
    static int[][] arr;
    static Integer[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();

        while (t-- > 0) {
            n = sc.nextInt();
            arr = new int[3][n + 1];
            for (int i = 1; i <= n; i++) { arr[1][i] = sc.nextInt(); }
            for (int i = 1; i <= n; i++) { arr[2][i] = sc.nextInt(); }
            dp = new Integer[3][n + 1];

            for (int i = 0; i <= n; i++) { arr[0][i] = 0; }
            dp[1][1] = arr[1][1];
            dp[2][1] = arr[2][1];
            for (int i = 0; i <= 2; i++) { arr[i][0] = 0; }

            System.out.println(Math.max(dp(1, n), dp(2, n)));
        }
    }

    private static int dp(int r, int c) {
        if (c < 0) {
            return 0;
        }

        if (dp[r][c] != null) {
            return dp[r][c];
        }
        
        if (r == 1) {
            return dp[1][c] = Math.max(dp(2, c-1), dp(2, c-2)) + arr[1][c];
        } else {
            return dp[2][c] = Math.max(dp(1, c-1), dp(1, c-2)) + arr[2][c];
        }
    }
}
