import java.util.*;
import java.io.*;

public class Main {
    static int N, M, H, W;
    static int sr, sc, fr, fc;
    static int[][] map;
    static int[][] vis;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Rect {
        int r1, c1;
        int r2, c2;

        Rect(int r1, int c1, int r2, int c2) {
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        H = scanner.nextInt();
        W = scanner.nextInt();
        sr = scanner.nextInt()-1;
        sc = scanner.nextInt()-1;
        fr = scanner.nextInt()-1;
        fc = scanner.nextInt()-1;

        Rect rect = new Rect(sr, sc, sr + H-1, sc + W-1);

        vis = new int[N][M];

        Queue<Rect> q = new ArrayDeque<>();
        q.add(rect);
        vis[rect.r1][rect.c1] = 1;
        while (!q.isEmpty()) { 
            Rect p = q.poll();

            if (p.r1 == fr && p.c1 == fc) {
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr1 = p.r1 + dr[i];
                int nc1 = p.c1 + dc[i];
                int nr2 = p.r2 + dr[i];
                int nc2 = p.c2 + dc[i];

                if (nr1 < 0 || nr2 >= N || nc1 < 0 || nc2 >= M) continue;
                if (vis[nr1][nc1] > 0) continue;
                if (isWallIn(nr1, nc1, nr2, nc2)) continue;
                
                Rect rect2 = new Rect(nr1, nc1, nr2, nc2);
                q.add(rect2);
                vis[nr1][nc1] = vis[p.r1][p.c1] + 1;
            }
        }
        System.out.println(vis[fr][fc]-1);
    }

    static boolean isWallIn(int nr1, int nc1, int nr2, int nc2) {
        for (int r = nr1; r <= nr2; r++) {
            for (int c = nc1; c <= nc2; c++) {
                if (map[r][c] == 1) return true;
            }
        }
        return false;
    }
}