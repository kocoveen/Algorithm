import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int n, m, mx;
    static int[][] map;
    static boolean[][] vis;
    static Queue<Info> q = new ArrayDeque<>();

    static int[] dr = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    static class Info {
        int r, c, d;
        public Info(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {
        n = read(); m = read();
        map = new int[n][m];
        vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (read() == 1) {
                    q.add(new Info(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Info cur = q.remove();

            for (int i = 0; i < 8; i++) {
                int nr = dr[i] + cur.r;
                int nc = dc[i] + cur.c;
                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (vis[nr][nc]) continue;
                map[nr][nc] = cur.d + 1;
                vis[nr][nc] = true;
                q.add(new Info(nr, nc, cur.d + 1));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mx = Math.max(mx, map[i][j]);
            }
        }
        System.out.println(mx);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}