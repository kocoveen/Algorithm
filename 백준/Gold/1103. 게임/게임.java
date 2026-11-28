import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dp;
    static boolean[][] visit;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        dp = new int[N][M]; // 이 칸에서 새로 출발할 때 앞으로 몇 번이나 더 갈 수 있는지(남은 최대 이동 횟수)
        // 지금까지 온 횟수가 아님
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                map[i][j] = (c == 'H') ? 0 : c - '0';
            }
        }
        System.out.println(dfs(0, 0));
    }

    static int dfs(int r, int c) {
        if (r < 0 || c < 0 || r >= N || c >= M || map[r][c] == 0) {
            return 0;
        }
        if (visit[r][c]) {
            System.out.println(-1);
            System.exit(0);
        }
        if (dp[r][c] != 0) {
            return dp[r][c];
        }
        visit[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i] * map[r][c];
            int nc = c + dc[i] * map[r][c];
            dp[r][c] = Math.max(dp[r][c], dfs(nr, nc) + 1);
        }
        visit[r][c] = false;
        return dp[r][c];
    }
}