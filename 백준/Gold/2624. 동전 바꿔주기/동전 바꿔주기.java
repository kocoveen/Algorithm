import java.util.Scanner;

public class Main {
    static int T, k;
    static Coin[] coins;
    static class Coin {
        int value;
        int count;

        Coin(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
    static Integer[][] dp;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        k = sc.nextInt();

        coins = new Coin[k];
        for (int i = 0; i < k; i++) {
            int value = sc.nextInt();
            int count = sc.nextInt();
            coins[i] = new Coin(value, count);
        }

        dp = new Integer[k][T+1];

        System.out.print(dp(0, 0));
    }

    private static int dp(int i, int s) {
        if (s == T) return 1;
        if (i == k || s > T) return 0;
        if (dp[i][s] != null) return dp[i][s];

        int countWays = 0;
        Coin cur = coins[i];

        for (int n = 0; n <= cur.count; n++) {
            int ns = s + cur.value * n;
            if (ns > T) break;
            countWays += dp(i + 1, ns);
        }
        return dp[i][s] = countWays;
    }
}