import java.util.*;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int R, C, K;
    static List<Golem> golems = new ArrayList<>();
    static Forest forest;

    static class Forest {
        int or, oc, g;
        int r, c;
        int[][] map;

        Forest(int r, int c) {
            this.or = r;
            this.oc = c;
            this.r = or + 3;
            this.c = c;
            this.map = new int[this.r][this.c];
            init();
        }

        private void init() {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    map[i][j] = -1;
                }
            }
        }

        public void clear() {
            init();
        }

        private void printGolem(Golem golem) {
            if (golem.r < 0) {
                ++g;

            } else if (golem.r == 0) {
                map[golem.r][golem.c] = g++;

                map[golem.r][golem.c-1] = g;
                map[golem.r][golem.c+1] = g;

            } else {
                map[golem.r][golem.c] = g++;

                map[golem.r-1][golem.c] = g;
                map[golem.r][golem.c-1] = g;
                map[golem.r][golem.c+1] = g;
            }

            map[golem.r+1][golem.c] = g;
            g++;

            int nr = golem.r + dr[golem.d];
            if (nr >= 0) {
                map[golem.r + dr[golem.d]][golem.c + dc[golem.d]] = g;
            }
            g++;
        }

        private boolean isFull() {
            for (int i = 0; i < c; i++) {
                if (map[0][i] > 0) return true;
                if (map[1][i] > 0) return true;
                if (map[2][i] > 0) return true;
            }
            return false;
        }

        private boolean isBoundarySouth(int gr, int gc) {
            return gr + 2 < r;
        }

        private boolean isBoundaryWestSouth(int gr, int gc) {
            return gc - 2 >= 0 && isBoundarySouth(gr, gc - 1);
        }

        private boolean isBoundaryEastSouth(int gr, int gc) {
            return gc + 2 < C && isBoundarySouth(gr, gc + 1);
        }

        private boolean isEmptySouth(int gr, int gc) {
            return map[gr + 2][gc] < 0 && map[gr + 1][gc - 1] < 0 && map[gr + 1][gc + 1] < 0;
        }

        private boolean isEmptyWestSouth(int gr, int gc) {
            return map[gr][gc - 2] < 0 && map[gr - 1][gc - 1] < 0 && map[gr + 1][gc - 1] < 0 && isEmptySouth(gr, gc - 1);
        }

        private boolean isEmptyEastSouth(int gr, int gc) {
            return map[gr][gc + 2] < 0 && map[gr - 1][gc + 1] < 0 && map[gr + 1][gc + 1] < 0 && isEmptySouth(gr, gc + 1);
        }

        public int getMaxRow(int gr, int gc) {
            int maxRow = 0;

            boolean[][] visited = new boolean[r][c];
            Queue<Point> q = new LinkedList<>();
            q.add(new Point(gr, gc));
            visited[gr][gc] = true;

            while (!q.isEmpty()) {
                Point p = q.poll();
                maxRow = Math.max(maxRow, p.r - 2);
                for (int i = 0; i < 4; i++) {
                    int nr = p.r + dr[i];
                    int nc = p.c + dc[i];

                    if (nr < 1 || nc < 0 || nr >= r || nc >= c) continue;
                    if (visited[nr][nc] || map[nr][nc] < 0) continue;

                    if (map[p.r][p.c] / 3 == map[nr][nc] / 3) {
                        visited[nr][nc] = true;
                        q.add(new Point(nr, nc));
                    } else if (map[p.r][p.c] % 3 == 2) {
                        visited[nr][nc] = true;
                        q.add(new Point(nr, nc));
                    }
                }
            }
            return maxRow;
        }

        public void printMap() {
            for (int i = 0; i < r; i++) {
                System.out.printf("%2d|", i-2);
                for (int j = 0; j < c; j++) {
                    System.out.printf("%2c ", printValue(map[i][j]));
                }
                System.out.print("|");
                System.out.println();
            }
        }

        private char printValue(int v) {
            if (v < 0) return ' ';
            if (v % 3 == 0) return '@'; // 정령
            if (v % 3 == 1) return '+'; // 골렘 몸통
            return '#'; // 문
        }
    }

    static class Golem {
        int r, c, d;
        private final Forest f;

        Golem(int c, int d, Forest f) {
            this.r = 1;
            this.c = c;
            this.d = d;
            this.f = f;
        }

        public void move() {
            while (true) {
                if (isStarted()) {
                    if (canTranslate()) {
                        moveSouth();
                    } else {
                        break;
                    }
                }

                if (canTranslate()) {
                    moveSouth();
                    continue;
                }

                if (canRotatePlus()) {
                    moveWestSouth();
                    continue;
                }

                if (canRotateMinus()) {
                    moveEastSouth();
                    continue;
                }

                break;
            }

            f.printGolem(this);
        }

        private boolean isStarted() {
            return r < 1;
        }

        private boolean canTranslate() {
            return f.isBoundarySouth(r, c) && f.isEmptySouth(r, c);
        }

        private boolean canRotatePlus() {
            return f.isBoundaryWestSouth(r, c) && f.isEmptyWestSouth(r, c);
        }

        private boolean canRotateMinus() {
            return f.isBoundaryEastSouth(r, c) && f.isEmptyEastSouth(r, c);
        }

        private void moveSouth() {
            this.r += 1;
        }

        private void moveWestSouth() {
            this.c -= 1;
            rotatePlus();
            this.r += 1;
        }

        private void moveEastSouth() {
            this.c += 1;
            rotateMinus();
            this.r += 1;
        }

        private void rotatePlus() { // 반시계방향, 서쪽 갈 때
            this.d = (this.d + 3) % 4;
        }

        private void rotateMinus() { // 시계방향, 동쪽 갈 때
            this.d = (this.d + 1) % 4;
        }

        public int getMaxRowSum() {
            return f.getMaxRow(this.r, this.c);
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
        R = read(); C = read(); K = read();
        forest = new Forest(R, C);
        for (int i = 0; i < K; i++) {
            int c = read()-1; int d = read();
            golems.add(new Golem(c, d, forest));
        }

        int maxRowSum = 0;
        for (Golem golem : golems) {
            golem.move();

            if (forest.isFull()) {
                forest.clear();
                continue;
            }

            int rowSum = golem.getMaxRowSum();
            maxRowSum += rowSum;
        }
        System.out.println(maxRowSum);
    }

    public static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}