import java.util.Scanner;

public class Main {

    static int[] arr;
    static Integer[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        dp = new Integer[n+1][k+1];

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                answer = Math.max(answer, dp(i, j));
            }
        }
        
        System.out.println(answer);

    }

    private static int dp(int i, int j) {
        if (i == 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        return dp[i][j] = arr[i] % 2 == 0 ? dp(i-1, j) + 1 : dp(i-1, j-1); 
    }
}
