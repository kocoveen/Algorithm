import java.io.IOException;

public class Main {

    static int[] t, p, dp;
    
    public static void main(String[] args) throws Exception {
        int n = read();
        t = new int[n];
        p = new int[n];
        dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            t[i] = read(); p[i] = read();
        }

        for (int i = n - 1; i >= 0; i--) {
            if (i + t[i] > n) dp[i] = Math.max(dp[i], dp[i + 1]);
            else dp[i] = Math.max(dp[i + 1], p[i] + dp[i + t[i]]);
        }

        System.out.println(dp[0]);
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}