import java.util.Scanner;

import static java.lang.Math.*;

public class Main {
    static int n;
    static int[] dp = new int[6];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int a, b, c;
        a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt();
        dp[0] = a;
        dp[1] = b;
        dp[2] = c;
        dp[3] = a;
        dp[4] = b;
        dp[5] = c;

        for (int i = 1; i < n; i++) {
            a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt();
            int t1 = dp[0];
            int t2 = dp[1];
            int t3 = dp[2];
            int t4 = dp[3];
            int t5 = dp[4];
            int t6 = dp[5];

            dp[0] = max(t1, t2) + a;
            dp[1] = max(t2, max(t1, t3)) + b;
            dp[2] = max(t2, t3) + c;
            dp[3] = min(t4, t5) + a;
            dp[4] = min(t5, min(t4, t6)) + b;
            dp[5] = min(t5, t6) + c;
        }

        System.out.println(max(dp[0], max(dp[1], dp[2])) + " " + min(dp[3], min(dp[4], dp[5])));
    }
}