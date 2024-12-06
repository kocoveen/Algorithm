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
            c += dc[d];

            if (c >= n) { 
                d = (d + 2) % 4;
                moveWest();
                moveWest();
            }
        }

        private void moveSouth() {
            v = (v + 1) % 4;
            hor[h] = ver[v];
            hor[(h + 2) % 4] = 7 - hor[h];
            r += dr[d];

            if (r >= n) { 
                d = (d + 2) % 4;
                moveNorth();
                moveNorth();
            }
        }

        private void moveWest() {
            h = (h + 3) % 4;
            ver[v] = hor[h];
            ver[(v + 2) % 4] = 7 - ver[v];
            c += dc[d];

            if (c < 0) {
                d = (d + 2) % 4;
                moveEast();
                moveEast();
            }
        }

        private void moveNorth() {
            v = (v + 3) % 4;
            hor[h] = ver[v];
            hor[(h + 2) % 4] = 7 - hor[h];
            r += dr[d];

            if (r < 0) { 
                d = (d + 2) % 4;
                moveSouth();
                moveSouth();
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
                    // System.out.println("1: [" + nr + ", " + nc + "]");
                    if (visited[nr][nc]) continue;
                    // System.out.println("2: [" + nr + ", " + nc + "]");
                    if (map[nr][nc] != map[this.r][this.c]) continue;
                    // System.out.println("3: [" + nr + ", " + nc + "] -> " + map[nr][nc]);

                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));
                    count++;
                }
            }
            // System.out.println();
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

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); m = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        Dice dice = new Dice();

        for (int i = 0; i < m; i++) {
            dice.move();

            int s = dice.getScore();
            // System.out.println("[" + dice.r + ", " + dice.c + "](" + dice.d + ")" + ", bot: " + dice.ver[dice.v] + ", score: " + s);
            score += s;

        }

        System.out.println(score);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read(); 
        return n;
    }
}