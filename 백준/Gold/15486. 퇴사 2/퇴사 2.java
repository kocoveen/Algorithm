import java.util.Scanner;

public class Main {
    static int n;
    static int[] T, P;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();

        T = new int[n + 1];
        P = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        for (int i = n-1; i >= 0; i--) {
            // 상담 안하는 경우
            int skip = dp[i + 1];

            // 상담 하는 경우
            int take = (i + T[i] <= n) ? P[i] + dp[i + T[i]] : 0;
            
            dp[i] = Math.max(skip, take);
        }
        System.out.println(dp[0]);
    }
}