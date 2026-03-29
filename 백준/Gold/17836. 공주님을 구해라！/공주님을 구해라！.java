import java.util.*;

public class Main {
    
    static int N, M, T;
    static int[][] map, dist;
    static final int INF = 987654321;
    static int gr = -1, gc = -1, gt = INF;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        T = sc.nextInt();

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    gr = i;
                    gc = j;
                }
            }
        }

        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = INF;
            }
        }

        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(0, 0));
        dist[0][0] = 0;
        while (!q.isEmpty()) { 
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (map[nr][nc] == 1) continue;
                if (dist[nr][nc] < INF) continue;

                dist[nr][nc] = dist[p.r][p.c] + 1;
                q.add(new Point(nr, nc));
            }
        }

        // 검에 도달할 수 있을 때
        if (!(gr == -1 && gc == -1)) {
            gt = dist[gr][gc];
        }

        int min = Math.min(
            // 칼 안들고 갈때
            dist[N-1][M-1],

            // 칼 들고 벽 뚫을때
            Math.abs(N-1 - gr) + Math.abs(M-1 - gc) + gt
        );

        // 두 값이 T 시간 이하면
        if (min <= T) {
            System.out.println(min);
        } else {
            System.out.println("Fail");
        }
    }
}