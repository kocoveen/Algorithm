import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static String[] l;
    static int N;

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        l = br.readLine().split(" ");
        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) dp[i] = Integer.parseInt(l[i - 1]);

        for (int i = 1; i <= N; i++)
            for (int j = 1; j < i; j++)
                dp[i] = Math.max(dp[i - j] + dp[j], dp[i]);

        System.out.println(dp[N]);
    }
}