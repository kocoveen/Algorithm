public class Main {

    static int n, mn = 1000001, C = 1000001;
    static int[][] map;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {
        n = read();
        map = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = read();
            }
        }

        dp = new int[3][n + 1][3]; // dp[색깔부터 시작][step][step에 각 색깔일 때]
        dp[0][1][0] = map[1][0]; dp[0][1][1] = C; dp[0][1][2] = C;
        dp[1][1][0] = C; dp[1][1][1] = map[1][1]; dp[1][1][2] = C;
        dp[2][1][0] = C; dp[2][1][1] = C; dp[2][1][2] = map[1][2];

        for (int k = 0; k < 3; k++) {
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < 3; j++) {
                    dp[k][i][j] = Math.min(dp[k][i - 1][(j + 1) % 3], dp[k][i - 1][(j + 2) % 3]) + map[i][j];
                }
            }

            mn = Math.min(mn, dp[k][n][(k + 1) % 3]);
            mn = Math.min(mn, dp[k][n][(k + 2) % 3]);
        }
        System.out.println(mn);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}