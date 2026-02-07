import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n, m;
    static int[][] arr;
    static Integer[][] dp;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        dp = new Integer[n][m];

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, dp(i, j));
            }
        }
        System.out.print(max * max);
    }

    private static int dp(int n, int m) {
        if (n < 0 || m < 0) {
            return 0;
        }

        if (dp[n][m] != null) {
            return dp[n][m];
        }

        if (arr[n][m] == 1) {
            return dp[n][m] = min(dp(n-1, m), dp(n, m-1), dp(n-1, m-1)) + 1;
        } else {
            return dp[n][m] = 0;
        }
    }

    private static int min(int... values) {
        return Arrays.stream(values).min().orElse(987654321);
    }
}