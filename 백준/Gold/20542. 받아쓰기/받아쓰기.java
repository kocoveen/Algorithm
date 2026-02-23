import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, m;
    static char[] sheet, answer;
    static Integer[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        sheet = sc.next().toCharArray();
        answer = sc.next().toCharArray();

        dp = new Integer[n][m];

        System.out.println(dp(n-1, m-1));
    }

    // 최장 공통 부분 수열
    private static int dp(int n, int m) {
        if (n < 0) return m + 1;
        if (m < 0) return n + 1;
        if (dp[n][m] != null) return dp[n][m];
        
        if (isMatch(sheet[n], answer[m])) {
            // 수정 : dp(n-1, m-1) + 1
            // 삭제 : dp(n-1, m) + 1
            // 삽입 : dp(n, m-1) + 1
            return dp[n][m] = dp(n-1, m-1);
        } else {
            return dp[n][m] = min(dp(n-1, m-1), dp(n, m-1), dp(n-1, m)) + 1;
        }
    }

    private static boolean isMatch(char a, char b) {
        return (
            (a == 'i' && (b == 'i' || b == 'j' || b == 'l'))
         || (a == 'v' && (b == 'v' || b == 'w'))
         || (a == b)
        );
    }

    private static int min(int... values) {
        return Arrays.stream(values).min().orElse(Integer.MAX_VALUE);
    }
}