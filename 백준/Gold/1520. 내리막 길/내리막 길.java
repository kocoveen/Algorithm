import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] map;
    static Integer[][] dp;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        dp = new Integer[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        System.out.println(dp(N-1, M-1));
    }

    private static int dp(int r, int c) {
        if (r == 0 && c == 0) { return 1; }
        if (dp[r][c] != null) { return dp[r][c]; }

        int sum = 0;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) { continue; }
            if (map[r][c] >= map[nr][nc]) { continue; }
            sum += dp(nr, nc);
        }
        return dp[r][c] = sum;
    }
}