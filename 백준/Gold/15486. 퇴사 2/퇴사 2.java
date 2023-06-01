import java.io.*;

public class Main {
    static String[] l;

    static int N;

    static int[] T, P;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        T = new int[N + 2];
        P = new int[N + 2];
        dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            l = br.readLine().split(" ");
            T[i] = Integer.parseInt(l[0]);
            P[i] = Integer.parseInt(l[1]);
        }

        for (int i = 1; i <= N; i++) {
            if (i + T[i] <= N + 1) {
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        System.out.println(dp[N + 1]);
    }
}