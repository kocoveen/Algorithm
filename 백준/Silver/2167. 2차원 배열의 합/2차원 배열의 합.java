public class Main {

    static int n, m, k;
    static int[][] arr;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        arr = new int[n + 1][m + 1];
        dp = new long[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] = read();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = arr[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }

        k = read();
        for (int i = 0; i < k; i++) {
            int r1 = read();
            int c1 = read();
            int r2 = read();
            int c2 = read();
            System.out.println(findSum(r1, c1, r2, c2));
        }
    }

    private static long findSum(int r1, int c1, int r2, int c2) {
        return dp[r2][c2] - dp[r2][c1 - 1] - dp[r1 - 1][c2] + dp[r1 - 1][c1 - 1];
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}