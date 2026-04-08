import java.util.*;

public class Main {

    static int K, R, C;
    static int[][] map;
    static int[][][] count;

    static class Point {
        int r, c, k;
        Point(int r, int c, int k) {
            this.r = r;
            this.c = c;
            this.k = k;
        }
    }

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int[] dhr = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] dhc = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        C = sc.nextInt();
        R = sc.nextInt();

        if (R == 1 && C == 1) {
            System.out.println(0);
            System.exit(0);
        }

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        count = new int[K+1][R][C];

        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(0, 0, 0));
        count[0][0][0] = 1;
        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if (map[nr][nc] != 0) continue;
                if (count[p.k][nr][nc] > 0) continue;

                if (nr == R-1 && nc == C-1) {
                    System.out.println(count[p.k][p.r][p.c]);
                    System.exit(0);
                }

                q.add(new Point(nr, nc, p.k));
                count[p.k][nr][nc] = count[p.k][p.r][p.c] + 1;
            }

            if (p.k < K) {
                for (int i = 0; i < 8; i++) {
                    int nr = p.r + dhr[i];
                    int nc = p.c + dhc[i];
                    int nk = p.k + 1;

                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                    if (map[nr][nc] != 0) continue;
                    if (count[nk][nr][nc] > 0) continue;

                    if (nr == R-1 && nc == C-1) {
                        System.out.println(count[p.k][p.r][p.c]);
                        System.exit(0);
                    }

                    q.add(new Point(nr, nc, nk));
                    count[nk][nr][nc] = count[p.k][p.r][p.c] + 1;
                }
            }
        }
        System.out.println(-1);
    }
}