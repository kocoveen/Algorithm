import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int h, w, t, outerSize;
    static int[][] map;
    static boolean[][] vis;
    static Queue<Info> q = new ArrayDeque<>();
    static Queue<Info> outer = new ArrayDeque<>();

    static class Info {
        int r, c;
        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        h = read(); w = read();
        map = new int[h][w];
        vis = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                map[i][j] = read();
            }
        }

        q.add(new Info(0, 0));
        vis[0][0] = true;
        while (true) {
            q.addAll(outer);
            outer.clear();

            bfs();

            if (outer.isEmpty()) break;

            outerSize = outer.size();
            t++;
        }
        System.out.println(t);
        System.out.println(outerSize);
    }

    static void bfs() {
        while(!q.isEmpty()) {
            Info cur = q.remove();
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (nr < 0 || nc < 0 || nr >= h || nc >= w) continue;
                if (vis[nr][nc]) continue;

                if (map[nr][nc] != 1) q.add(new Info(nr, nc));
                else outer.add(new Info(nr, nc));
                vis[nr][nc] = true;
            }
        }

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}