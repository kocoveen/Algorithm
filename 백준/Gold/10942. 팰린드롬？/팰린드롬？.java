import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] arr;
    static Integer[][] dp;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        dp = new Integer[n+1][n+1];

        int t = sc.nextInt();

        StringBuilder sb = new StringBuilder(); // 출력 모으기
        while (t-- > 0) {
            int i = sc.nextInt();
            int j = sc.nextInt();

            sb.append(dp(i, j)).append("\n");
        }
        System.out.print(sb);
    }

    private static int dp(int i, int j) {
        if (i >= j) {
            return dp[i][j] = 1;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        return dp[i][j] = arr[i] == arr[j] ? dp(i+1, j-1) : 0;
    }
}