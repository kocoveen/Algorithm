import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // 2: 1
    // 3: 7
    // 4: 4
    // 5: 5, 3, 2
    // 6: 9, 6, 0
    // 7: 8
    
    static long[] dp = new long[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Arrays.fill(dp, Long.MAX_VALUE);

        dp[2] = 1L;
        dp[3] = 7L;
        dp[4] = 4L;
        dp[5] = 2L;
        dp[6] = 6L;
        dp[7] = 8L;
        dp[8] = 10L;

        for (int i = 9; i <= 100; i++) {
            for (int j = 2; j <= 7; j++) {
                long tmp = j == 6 ? 0 : dp[j];
                String combined = String.valueOf(dp[i-j]) + String.valueOf(tmp);
                dp[i] = Math.min(dp[i], Long.parseLong(combined));
            }
        }

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(dp[n] + " " + getMax(n));
        }
    }

    private static String getMax(int n) {
        if (n % 2 == 0) {
            return "1".repeat(n/2);
        } else {
            String answer = "7";
            int m = n - 3;
            if (m > 0) {
                answer += "1".repeat(m/2);
            }
            return answer;
        }
    }
}