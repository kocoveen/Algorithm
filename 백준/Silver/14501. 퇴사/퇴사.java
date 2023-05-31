import java.io.*;

public class Main {
    static String[] l;

    static int N;

    static int[] T, P;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        T = new int[N + 2];
        P = new int[N + 2];
        dp = new Integer[N + 2];

        dp[N + 1] = 0;

        for (int i = 1; i <= N; i++) {
            l = br.readLine().split(" ");
            T[i] = Integer.parseInt(l[0]);
            P[i] = Integer.parseInt(l[1]);
        }

        for (int i = N; i >= 1; i--) func(i);

        int max = Integer.MIN_VALUE;
        for (Integer i : dp) {
            if (i == null) continue;
            max = Math.max(max, i);
        }

        System.out.println(max);
    }

    private static int func(int day) {
        if (dp[day] == null) {
            if (day + T[day] > N + 1) dp[day] = dp[day + 1];
            else dp[day] = Math.max(func(day + T[day]) + P[day], dp[day + 1]);
        }
        return dp[day];
    }
}