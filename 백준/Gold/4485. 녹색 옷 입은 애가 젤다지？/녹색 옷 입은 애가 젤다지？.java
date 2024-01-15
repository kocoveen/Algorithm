import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    static int[][] sum;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {

        int idx = 1;
        while ((n = read()) != 0) {
            map = new int[n][n];
            sum = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = read();
                    sum[i][j] = Integer.MAX_VALUE;
                }
            }

            int total = bfs();
            System.out.printf("Problem %d: %d\n", idx++, total);
        }
    }

    private static int bfs() {
        PriorityQueue<Loc> q = new PriorityQueue<>((Loc l1, Loc l2) -> l1.cost - l2.cost);
        q.add(new Loc(0, 0, map[0][0]));

        while (!q.isEmpty()) {
            Loc cur = q.remove();

            if (cur.r == n - 1 && cur.c == n - 1) {
                return cur.cost;
            }

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (nr < 0 || n <= nr || nc < 0 || n <= nc) continue;

                if (sum[nr][nc] <= cur.cost + map[nr][nc]) continue;
                sum[nr][nc] = cur.cost + map[nr][nc];
                q.add(new Loc(nr, nc, sum[nr][nc]));
            }
        }
        return -1;
    }
    
    static class Loc implements Comparable<Loc> {
        int r, c, cost;
        public Loc(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Loc loc) {
            return this.cost - loc.cost;
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }
}