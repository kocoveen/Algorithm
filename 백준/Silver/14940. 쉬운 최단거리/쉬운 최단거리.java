import java.util.*;

public class Main {
    
    static int n, m;
    static int[][] map, dist;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    };

    static Point sp;
    static final int INF = 987654321;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        dist = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    sp = new Point(i, j);
                    dist[i][j] = 0;
                } else if (map[i][j] == 0) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = -1;
                }
            }
        }

        // bfs
        Queue<Point> q = new ArrayDeque<>();
        q.add(sp);

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (0 > nr || nr >= n || 0 > nc || nc >= m) continue;

                if (dist[nr][nc] == -1 && map[nr][nc] == 1) {
                    dist[nr][nc] = dist[p.r][p.c] + 1;
                    q.add(new Point(nr, nc));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(dist[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}