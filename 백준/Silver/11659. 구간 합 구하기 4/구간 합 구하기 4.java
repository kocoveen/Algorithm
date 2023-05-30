import java.io.*;

public class Main {
    static String[] l;

    static int N, M;

    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        N = Integer.parseInt(l[0]);
        M = Integer.parseInt(l[1]);

        arr = new int[100005];
        dp = new Integer[100005];
        dp[0] = 0;
        l = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) dp[i] = dp[i - 1] + Integer.parseInt(l[i - 1]);

        while (M-- > 0) {
            l = br.readLine().split(" ");
            int st = Integer.parseInt(l[0]);
            int en = Integer.parseInt(l[1]);
            System.out.println(func(st, en));
        }

    }

    private static int func(int st, int en) {
        return dp[en] - dp[st - 1];
    }

}