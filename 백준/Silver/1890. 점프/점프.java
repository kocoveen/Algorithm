public class Main {

    static int n;
    static int[][] board;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        n = read();
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = read();
            }
        }

        dp = new long[n][n];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] <= 0) continue;
                int nr = i + board[i][j];
                int nc = j + board[i][j];

                if (nr < n) {
                    dp[nr][j] += dp[i][j];
                }

                if (nc < n) {
                    dp[i][nc] += dp[i][j];
                }
            }
        }
        System.out.println(dp[n-1][n-1]);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}