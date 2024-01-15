public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int m = read();

        int[] M = new int[n + 1];
        int[] C = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            M[i] = read();

        }
        int tc = 0;
        for (int i = 1; i <= n; i++) {
            C[i] = read();
            tc += C[i];
        }

        int[][] dp = new int[n + 1][tc + 1];

        int mnC = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= tc; j++) {
                if (C[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - C[i]] + M[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

                if (dp[i][j] >= m) {
                    mnC = Math.min(mnC, j);
                }
            }
        }
        System.out.println(mnC);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
