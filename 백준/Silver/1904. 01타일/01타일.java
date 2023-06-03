import java.io.*;

public class Main {
    static String[] l;

    static int N, C = 15746;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        N = Integer.parseInt(l[0]);

        dp = new int[N + 2];

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) dp[i] = (dp[i - 1] % C + dp[i - 2] % C) % C;
        System.out.println(dp[N]);
    }
}