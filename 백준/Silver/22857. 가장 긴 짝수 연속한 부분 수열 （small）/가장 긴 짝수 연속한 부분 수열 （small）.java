import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        dp = new int[n+1][k+1];
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (arr[i] % 2 == 0) {
                    dp[i][j] = dp[i - 1][j] + 1;
                } else {
                    if (j == 0) continue;
                    dp[i][j] = dp[i - 1][j - 1];
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }
        
        System.out.println(answer);
    }
}
