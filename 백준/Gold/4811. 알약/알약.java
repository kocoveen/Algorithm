public class Main {

    static int n;
    static Long[][] dp = new Long[31][31];

    public static void main(String[] args) throws Exception {
        while ((n = read()) > 0) System.out.println(func(n, 0));
    }

    public static long func(int w, int h) {
        if (h == -1) return 0;
        if (w == 0) return 1;

        if (dp[w][h] == null) dp[w][h] = func(w - 1, h + 1) + func(w, h - 1);
        return dp[w][h];
    }
    
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}