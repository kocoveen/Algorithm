import java.io.*;

public class Main {
    static String[] l;

    static int N, K, C = 10007;

    static Integer dp[][] = new Integer[1005][1005];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        N = Integer.parseInt(l[0]);
        K = Integer.parseInt(l[1]);

        System.out.println(func(N, K));
    }

    private static int func(int n, int k) {
        if (n == 0 || k == 0 || k == n) return 1;
        if (dp[n][k] == null) dp[n][k] = (func(n - 1, k - 1) % C + func(n - 1, k) % C) % C;
        return dp[n][k];
    }
}