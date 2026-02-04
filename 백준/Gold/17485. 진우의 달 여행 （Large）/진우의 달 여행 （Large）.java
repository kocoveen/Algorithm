import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    static int N, M;
    static int[][] arr;
    static Integer[][][] dp;
    static final int C = 1_000_001;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        dp = new Integer[N][M][3];
        
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < M; j++) {
            for (int k = 0; k < 3; k++) {
                min = Math.min(min, dp(N-1, j, k));
            }
        }
        System.out.print(min);
    }

    private static int dp(int i, int j, int dir) {
        if (j < 0 || j >= M) return C;
        if (i == 0) return dp[i][j][dir] = arr[i][j];
        if (dp[i][j][dir] != null) return dp[i][j][dir];

        return switch (dir) {
            case 0 -> dp[i][j][0] = Math.min(dp(i-1, j, 1), dp(i-1, j+1, 2)) + arr[i][j];
            case 1 -> dp[i][j][1] = Math.min(dp(i-1, j-1, 0), dp(i-1, j+1, 2)) + arr[i][j];
            case 2 -> dp[i][j][2] = Math.min(dp(i-1, j-1, 0), dp(i-1, j, 1)) + arr[i][j];
            default -> Integer.MAX_VALUE;
        };
    }

    private static int min(Integer... values) {
        return Stream.of(values).min(Integer::compare).orElse(C);
    }
}