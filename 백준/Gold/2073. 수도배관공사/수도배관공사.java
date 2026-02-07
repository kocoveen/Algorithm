public class Main {
    static class Pipe {
        int l, c;
        Pipe(int l, int c) {
            this.l = l;
            this.c = c;
        }
    }

    static int d, p;
    static Pipe[] pipes; 
    static Integer[][] dp;

    public static void main(String[] args) throws Exception {
        d = read(); // 수도관 길이
        p = read(); // 개수

        pipes = new Pipe[p+1];
        for (int i = 1; i <= p; i++) {
            int l = read();
            int c = read();

            pipes[i] = new Pipe(l, c);
        }

        dp = new Integer[d+1][p+1];
        System.out.println(dp(d, p));
    }

    private static int dp(int d, int p) {
        if (d == 0) return Integer.MAX_VALUE;
        if (p <= 0 || d < 0) return 0;
        if (dp[d][p] != null) return dp[d][p];

        return dp[d][p] = Math.max(
            dp(d, p-1),
            Math.min(
                pipes[p].c,
                dp(d - pipes[p].l, p-1)
            )
        );
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n; 
    }
}