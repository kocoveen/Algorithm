import java.util.*;

public class Main {
    static int w, h, mn = Integer.MAX_VALUE;
    static char[][] map;
    static int[][][] mirrors;
    static List<Point> points = new ArrayList<>();
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Point {
        int r, c, dir, mir;

        public Point(int r, int c, int dir, int mir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.mir = mir;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        w = sc.nextInt();
        h = sc.nextInt();

        map = new char[h][w];

        for (int i = 0; i < h; i++) {
            String line = sc.next();
            for (int j = 0; j < w; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'C') {
                    points.add(new Point(i, j, -4, -1));
                }
            }
        }

        Point start = points.get(0);
        bfs(start);
        System.out.println(mn);
    }

    private static void bfs(Point start) {

        Point end = points.get(1);
        PriorityQueue<Point> q = new PriorityQueue<>((p1, p2) -> p1.mir - p2.mir);

        mirrors = new int[4][h][w];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < h; j++) {
                Arrays.fill(mirrors[i][j], Integer.MAX_VALUE);
            }
        }
        
        q.add(start);
        while (!q.isEmpty()) {
            Point cur = q.remove();

            if (cur.r == end.r && cur.c == end.c) {
                mn = Math.min(mn, cur.mir);
                continue;
            }

            for (int dir = 0; dir < 4; dir++) {
                if (Math.abs(cur.dir - dir) == 2) continue;

                int nr = cur.r + dr[dir];
                int nc = cur.c + dc[dir];
                if (nr < 0 || nc < 0 || nr >= h || nc >= w) continue;
                if (map[nr][nc] == '*') continue;

                int nMir = (cur.dir != dir) ? cur.mir + 1 : cur.mir;

                if (mirrors[dir][nr][nc] > nMir) {
                    mirrors[dir][nr][nc] = nMir;
                    q.offer(new Point(nr, nc, dir, nMir));
                }
            }
        }
    }
}