import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n, m, k, count, mx;
    static int[][] map;
    static boolean[][] vis;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        k = read();
        map = new int[n][m];
        vis = new boolean[n][m];
        while (k-- > 0) {
            int r = read();
            int c = read();
            map[r - 1][c - 1] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] || map[i][j] != 1) continue;
                count = 1;
                q.add(new int[]{i, j});
                vis[i][j] = true;
                while (!q.isEmpty()) {
                    int[] cur = q.remove();
                    for (int l = 0; l < 4; l++) {
                        int nr = cur[0] + dr[l];
                        int nc = cur[1] + dc[l];
                        if (nr < 0 || n <= nr || nc < 0 || m <= nc) continue;
                        if (vis[nr][nc] || map[nr][nc] != 1) continue;
                        q.add(new int[]{nr, nc});
                        vis[nr][nc] = true;
                        count++;
                    }
                }
                mx = Math.max(mx, count);
            }
        }

        System.out.println(mx);
    }

    public static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}