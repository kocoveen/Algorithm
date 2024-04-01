public class Main {

    static int n, k;
    static int[] weights, values;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        n = read(); k = read();

        weights = new int[n + 1];
        values = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int w = read();
            int v = read();
            weights[i] = w;
            values[i] = v;
        }

        dp = new int[n + 1][k + 1];


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j >= weights[i]) dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                else dp[i][j] = dp[i - 1][j];
            }
        }

        System.out.println(dp[n][k]);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}