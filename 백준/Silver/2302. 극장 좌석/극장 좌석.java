import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
//    static String[] l;
    static int N, M;

    static int[] VIP;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        VIP = new int[M + 1];
        dp = new Integer[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 0; i < M; i++) VIP[i] = Integer.parseInt(br.readLine());

        int a = 0, cnt = 0, ans = 1;
        for (int i = 1; i <= N; i++) {
            if (VIP[a] == i) {
                ans *= func(cnt);
                cnt = 0;
                a++;
            }
            else cnt++;
        }
        ans *= func(cnt);

        System.out.println(ans);
    }

    private static int func(int n) {
        if (dp[n] == null) dp[n] = func(n - 1) + func(n - 2);
        return dp[n];
    }
}