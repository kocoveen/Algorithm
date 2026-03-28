import java.util.*;

public class Main {
    
    static int N, M;
    static int[][] map, dis;

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        dis = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<Point> q = new ArrayDeque<>();

        q.add(new Point(0, 0));
        dis[0][0] = 1;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (dis[nr][nc] > 0 || map[nr][nc] == 0) continue;
                q.add(new Point(nr, nc));
                dis[nr][nc] = dis[p.r][p.c] + 1;
            }
        }

        System.out.println(dis[N-1][M-1]);
    }
}