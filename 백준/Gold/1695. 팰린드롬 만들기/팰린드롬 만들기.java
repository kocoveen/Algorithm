import java.util.Scanner;

public class Main {
    static int N;
    static int[] arr;
    static int[] ark;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N+1];
        ark = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
            ark[N-i+1] = arr[i];
        }

        dp = new int[N+1][N+1];

        // 원래 수열 A, 뒤집은 수열 B의 LCS를 찾음
        // A와 B의 최장 공통 수열을 찾으면, 그 수열은 이미 팰린드롬
        // 최장 수열이 아닌 나머지(공통이 아닌 수)만큼만 원래 수열에 붙이면 팰린드롬이 완성
        // 이미 최장 수열을 뽑았기 때문에, 붙일 수열은 최소임.

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i] == ark[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(N - dp[N][N]);
    }
}