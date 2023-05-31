import java.io.*;

public class Main {
    static String[] l;

    static int T;

    static Long[] dp = new Long[105];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;

        while (T-- > 0) System.out.println(func(Integer.parseInt(br.readLine())));
    }

    private static long func(int N) {
        if (dp[N] == null) {
            dp[N] = func(N - 2) + func(N - 3);
        }
        return dp[N];
    }
}
