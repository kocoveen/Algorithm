import java.io.*;

public class Main {
    static int N;
    static long C = 1000000000L;
    static long sum;

    static Long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new Long[N + 1][10];

        for (int i = 0; i < 10; i++) dp[1][i] = 1L;

        for (int i = 1; i < 10; i++) sum += func(N, i);
        System.out.println(sum % C);
    }

    private static long func(int n, int i) {
        if (dp[n][i] == null) {
            if (i == 0) return dp[n][i] = func(n - 1, i + 1);
            if (i == 9) return dp[n][i] = func(n - 1, i - 1);
            dp[n][i] = func(n - 1, i - 1) + func(n - 1, i + 1);
        }
        return dp[n][i] % C;
    }
}
