import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int score;

    static class Dice {
        int r, c, d;
        int v = 1, h = 1;
        int[] ver, hor;


        Dice() {
            this.ver = new int[]{5, 6, 2, 1};
            this.hor = new int[]{4, 6, 3, 1};
        }

        public void move() {
            switch (d) {
                case 0: { moveEast(); break; }
                case 1: { moveSouth(); break; }
                case 2: { moveWest(); break; }
                case 3: { moveNorth(); break; }
            }
            

            if (ver[v] > map[r][c]) {
                d = (d + 1) % 4;
            } else if (ver[v] < map[r][c]) {
                d = (d + 3) % 4;
            }
        }

        private void moveEast() {
            h = (h + 1) % 4;
            ver[v] = hor[h];
            ver[(v + 2) % 4] = 7 - ver[v];
            c += 1;

            if (c >= n) { 
                d = (d + 2) % 4;
                c -= 1;
            }
        }

        private void moveSouth() {
            v = (v + 1) % 4;
            hor[h] = ver[v];
            hor[(h + 2) % 4] = 7 - hor[h];
            r += 1;

            if (r >= n) { 
                d = (d + 2) % 4;
                r -= 1;
            }
        }

        private void moveWest() {
            h = (h + 3) % 4;
            ver[v] = hor[h];
            ver[(v + 2) % 4] = 7 - ver[v];
            c -= 1;

            if (c < 0) { 
                d = (d + 2) % 4;
                c += 1;
            }
        }

        private void moveNorth() {
            v = (v + 3) % 4;
            hor[h] = ver[v];
            hor[(h + 2) % 4] = 7 - hor[h];
            c -= 1;

            if (r < 0) { 
                d = (d + 2) % 4;
                r += 1;
            }
        }

        public int getScore() {
            int count = 1;

            boolean[][] visited = new boolean[n][n];

            Queue<Point> q = new ArrayDeque<>();
            visited[this.r][this.c] = true;
            q.add(new Point(this.r, this.c));

            while (!q.isEmpty()) {
                Point p = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = p.r + dr[i];
                    int nc = p.c + dc[i];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                    if (visited[nr][nc]) continue;
                    if (map[nr][nc] != map[p.r][p.c]) continue;

                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));
                    count++;
                }
            }
            return count * map[this.r][this.c];
        }
    }

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        n = read(); m = read();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = read();
            }
        }

        Dice dice = new Dice();

        while (m-- > 0) {
            dice.move();
            score += dice.getScore();
        }

        System.out.println(score);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}