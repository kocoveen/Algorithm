import java.io.*;
import java.util.*;

public class Main {
    static String[] l;

    static int N, M, max = 0;

    static int[][] board;
    static boolean[][] vis;
    static boolean[][] visBlock;

    static List<Pair> V = new ArrayList<>();
    static Queue<Pair> Q = new ArrayDeque<>();

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        N = Integer.parseInt(l[0]);
        M = Integer.parseInt(l[1]);

        board = new int[N][M];
        vis = new boolean[N][M];
        visBlock = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            l = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(l[j]);
                if (board[i][j] == 2) V.add(new Pair(i, j));
            }
        }

        func(0);
        System.out.println(max);
    }

    private static void func(int depth) {
        if (depth == 3) {
            for (int i = 0; i < N; i++) Arrays.fill(vis[i], false);
            max = Math.max(bfs(), max);
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++)
                    if (board[i][j] == -1) board[i][j] = 0;
            return;
        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 0) continue;
                board[i][j] = 1;
                func(depth + 1);
                board[i][j] = 0;
            }
    }

    private static int bfs() {
        for (Pair P : V) {
            Q.add(P);
            vis[P.r][P.c] = true;
        }

        while (!Q.isEmpty()) {
            Pair cur = Q.remove();
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (board[nr][nc] == 1 || vis[nr][nc]) continue;
                Q.add(new Pair(nr, nc));
                board[nr][nc] = -1;
                vis[nr][nc] = true;
            }
        }

        int cnt = 0;
        for (int[] b : board)
            for (int i : b)
                if (i == 0) cnt++;
        return cnt;
    }


    private static class Pair {
        int r;
        int c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}