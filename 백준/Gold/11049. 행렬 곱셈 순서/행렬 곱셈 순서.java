public class Main {

    static int n;
    static int[][] mat, dp;

    public static void main(String[] args) throws Exception {
        n = read();
        mat = new int[n][2];
        for (int i = 0; i < n; i++) {
            mat[i][0] = read();
            mat[i][1] = read();
        }
        dp = new int[n][n];

        for (int d = 1; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                calculate(i, i + d);
            }
        }
        System.out.println(dp[0][n-1]);
    }

    private static void calculate(int x, int y) {
        dp[x][y] = Integer.MAX_VALUE;
        for (int i = x; i < y; i++) {
            if (i == x) {
                dp[x][y] = Math.min(dp[x][y], dp[x + 1][y] + (mat[x][0] * mat[x][1] * mat[y][1]));
            } else if (i == y - 1) {
                dp[x][y] = Math.min(dp[x][y], dp[x][y-1] + (mat[x][0] * mat[y][0] * mat[y][1]));
            } else {
                dp[x][y] = Math.min(dp[x][y], dp[x][i] + dp[i + 1][y] + (mat[x][0] * mat[i][1] * mat[y][1]));
            }
        }
    }


    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}