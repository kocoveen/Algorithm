import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static int n, k;
    static Integer[] dp;
    static Set<Integer> set = new HashSet<>();
    static final int INF = 100001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        dp = new Integer[k+1];
        dp[0] = 0;

        int result = dp(k);
        System.out.print(result != INF ? result : -1);
    }

    private static int dp(int i) {
        if (i < 0) { return INF; }
        if (dp[i] != null) { return dp[i]; }
        int min = INF;
        for (int c : set) {
            min = Math.min(min, dp(i-c) + 1);
        }
        return dp[i] = min;
    }
}