import java.util.*;

public class Main {

    static int N, M;
    static Medusa medusa;
    static boolean[][] petrifiedMap;
    static Answer answer;

    static int[][] roadMap;

    static List<Warrior>[][] warriorMap;
    static List<Warrior> warriors;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] dirArr = {
        {0, 2, 3},
        {1, 3, 2},
        {2, 1, 0},
        {3, 0, 1}
    };

    static class Answer {
        int distanceSum, petrified, attacking;
        Answer() {}

        @Override
        public String toString() {
            return distanceSum + " " + petrified + " " + attacking;
        }
    }

    static class Point {
        int r, c;
        Point(int r, int c) { this.r = r; this.c = c; }

        @Override
        public String toString() {
            return "[" + r + ", " + c + "]";
        }
    }

    static class Medusa {
        Point cur, home, park;
        Deque<Point> route = new ArrayDeque<>();

        Medusa(Point home, Point park) {
            this.home = home;
            this.park = park;
            this.cur = new Point(home.r, home.c);
            getRoute();
        }

        public void move() {
            cur = route.removeLast();
            if (cur.r == park.r && cur.c == park.c) {
                System.out.println(0);
                System.exit(0);
            }

            if (!warriorMap[cur.r][cur.c].isEmpty()) {
                List<Warrior> currentWarriors = new ArrayList<>(warriorMap[cur.r][cur.c]);
                for (Warrior w : currentWarriors) {
                    w.die();
                }
            }
        }

        private boolean isPlaced(int wr, int wc) {
            return wr == cur.r && wc == cur.c;
        }

        public void petrify() {
            int max = -1, maxDir = -1;
            for (int dir = 0; dir < 4; dir++) {
                int count = goStraight(dir, cur.r + dr[dir], cur.c + dc[dir]) +
                    goStraightLeft(dir, cur.r + dr[dirArr[dir][1]] + dr[dir], cur.c + dc[dirArr[dir][1]] + dc[dir]) +
                    goStraightRight(dir, cur.r + dr[dirArr[dir][2]] + dr[dir], cur.c + dc[dirArr[dir][2]] + dc[dir]);

                // System.out.println("dir: " + dir + ", count: " + count);
                if (max < count) {
                    max = count;
                    maxDir = dir;
                }
            }

            answer.petrified = max;

            for (Warrior w : warriors) { w.petrified = false; }
            petrifiedMap = new boolean[N][N];
            checkStraight(maxDir, cur.r + dr[maxDir], cur.c + dc[maxDir]);
            checkStraightLeft(maxDir, cur.r + dr[dirArr[maxDir][1]] + dr[maxDir], cur.c + dc[dirArr[maxDir][1]] + dc[maxDir]);
            checkStraightRight(maxDir, cur.r + dr[dirArr[maxDir][2]] + dr[maxDir], cur.c + dc[dirArr[maxDir][2]] + dc[maxDir]);

            // for (int i = 0; i < N; i++) {
            //     for (int j = 0; j < N; j++) {
            //         System.out.print(petrifiedMap[i][j] + " ");
            //     }
            //     System.out.println();
            // }
            // System.out.println();
        }

        private int goStraight(int dir, int r, int c) {
            if (r < 0 || N <= r || c < 0 || N <= c) return 0;
            if (!warriorMap[r][c].isEmpty()) return warriorMap[r][c].size();
            return goStraight(dir, r + dr[dir], c + dc[dir]);
        }

        private int goStraightLeft(int dir, int r, int c) {
            if (r < 0 || N <= r || c < 0 || N <= c) return 0;
            if (!warriorMap[r][c].isEmpty()) return warriorMap[r][c].size();
            return goStraight(dir, r + dr[dir], c + dc[dir]) + goStraightLeft(dir, r + dr[dirArr[dir][1]] + dr[dir], c + dc[dirArr[dir][1]] + dc[dir]);
        }

        private int goStraightRight(int dir, int r, int c) {
            if (r < 0 || N <= r || c < 0 || N <= c) return 0;
            if (!warriorMap[r][c].isEmpty()) return warriorMap[r][c].size();
            return goStraight(dir, r + dr[dir], c + dc[dir]) + goStraightRight(dir, r + dr[dirArr[dir][2]] + dr[dir], c + dc[dirArr[dir][2]] + dc[dir]);
        }

        private void checkStraight(int dir, int r, int c) {
            if (r < 0 || N <= r || c < 0 || N <= c) return;
            petrifiedMap[r][c] = true;
            if (!warriorMap[r][c].isEmpty()) {
                for (Warrior w : warriorMap[r][c]) { w.petrified = true; }
                return;
            }
            checkStraight(dir, r + dr[dir], c + dc[dir]);
        }

        private void checkStraightLeft(int dir, int r, int c) {
            if (r < 0 || N <= r || c < 0 || N <= c) return;
            petrifiedMap[r][c] = true;
            if (!warriorMap[r][c].isEmpty()) {
                for (Warrior w : warriorMap[r][c]) { w.petrified = true; }
                return;
            }
            checkStraight(dir, r + dr[dir], c + dc[dir]);
            checkStraightLeft(dir, r + dr[dirArr[dir][1]] + dr[dir], c + dc[dirArr[dir][1]] + dc[dir]);
        }

        private void checkStraightRight(int dir, int r, int c) {
            if (r < 0 || N <= r || c < 0 || N <= c) return;
            petrifiedMap[r][c] = true;
            if (!warriorMap[r][c].isEmpty()) {
                for (Warrior w : warriorMap[r][c]) { w.petrified = true; }
                return;
            }
            checkStraight(dir, r + dr[dir], c + dc[dir]);
            checkStraightRight(dir, r + dr[dirArr[dir][2]] + dr[dir], c + dc[dirArr[dir][2]] + dc[dir]);
        }


        private void getRoute() {
            Point[][] prevMap = new Point[N][N];
            boolean[][] visited = new boolean[N][N];

            Queue<Point> queue = new ArrayDeque<>();
            queue.add(new Point(home.r, home.c));
            prevMap[home.r][home.c] = new Point(-1, -1);
            visited[home.r][home.c] = true;

            Loop:
            while (!queue.isEmpty()) {
                Point p = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = p.r + dr[i];
                    int nc = p.c + dc[i];

                    if (!isBoundary(nr, nc)) continue;
                    if (visited[nr][nc]) continue;
                    if (roadMap[nr][nc] == 1) continue;

                    visited[nr][nc] = true;
                    prevMap[nr][nc] = new Point(p.r, p.c);
                    queue.add(new Point(nr, nc));
                    if (nr == park.r && nc == park.c) break Loop;
                }
            }

            if (!visited[park.r][park.c]) {
                System.out.println(-1);
                System.exit(0);
            }

            route.addFirst(new Point(park.r, park.c));
            int tr = route.getFirst().r;
            int tc = route.getFirst().c;
            while (!(tr == home.r && tc == home.c)) {
                route.addLast(prevMap[tr][tc]);
                int nr = prevMap[tr][tc].r;
                int nc = prevMap[tr][tc].c;
                tr = nr; tc = nc;
            }
            route.removeLast();
        }
    }

    static class Warrior {
        Point cur;
        boolean dead;
        boolean petrified;

        Warrior(Point cur) { this.cur = cur; }

        public void moveFirst() {
            if (dead || petrified) return;

            int dir = -1;

            if (medusa.cur.r < this.cur.r && isEnabledWith(0)) dir = 0;
            else if (medusa.cur.r > this.cur.r && isEnabledWith(1)) dir = 1;
            else if (medusa.cur.c < this.cur.c && isEnabledWith(2)) dir = 2;
            else if (medusa.cur.c > this.cur.c && isEnabledWith(3)) dir = 3;

            if (dir == -1) return;

            warriorMap[cur.r][cur.c].remove(this);
            cur.r += dr[dir];
            cur.c += dc[dir];
            warriorMap[cur.r][cur.c].add(this);


            answer.distanceSum++;
            if (medusa.isPlaced(cur.r, cur.c)) {
                this.die();
                answer.attacking++;
            }
        }

        public void moveSecond() {
            if (dead || petrified) return;

            int dir = -1;

            if (medusa.cur.c < this.cur.c && isEnabledWith(2)) dir = 2;
            else if (medusa.cur.c > this.cur.c && isEnabledWith(3)) dir = 3;
            else if (medusa.cur.r < this.cur.r && isEnabledWith(0)) dir = 0;
            else if (medusa.cur.r > this.cur.r && isEnabledWith(1)) dir = 1;

            if (dir == -1) return;

            warriorMap[cur.r][cur.c].remove(this);
            cur.r += dr[dir];
            cur.c += dc[dir];
            warriorMap[cur.r][cur.c].add(this);

            answer.distanceSum++;
            if (medusa.isPlaced(cur.r, cur.c)) {
                this.die();
                answer.attacking++;
            }
        }

        private boolean isEnabledWith(int dir) {
            int nr = cur.r + dr[dir];
            int nc = cur.c + dc[dir];
            return isBoundary(nr, nc) && !petrifiedMap[nr][nc];
        }

        private int getDirR() {
            if (medusa.cur.r < this.cur.r) return -1;
            if (medusa.cur.r > this.cur.r) return 1;
            return 0;
        }

        private int getDirC() {
            if (medusa.cur.c < this.cur.c) return -1;
            if (medusa.cur.c > this.cur.c) return 1;
            return 0;
        }

        public boolean isDead() {
            return dead;
        }

        public void die() {
            this.dead = true;
            warriorMap[cur.r][cur.c].remove(this);
        }
    }

    public static void main(String[] args) throws Exception {
        N = read(); M = read();
        int sr = read(), sc = read(), er = read(), ec = read();

        warriorMap = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                warriorMap[i][j] = new ArrayList<>();
            }
        }

        warriors = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            Warrior w = new Warrior(new Point(read(), read()));
            warriorMap[w.cur.r][w.cur.c].add(w);
            warriors.add(w);
        }

        roadMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                roadMap[i][j] = read();
            }
        }

        medusa = new Medusa(new Point(sr, sc), new Point(er, ec));

        while (!medusa.route.isEmpty()) {
            answer = new Answer();

            medusa.move();
            medusa.petrify();

            for (Warrior warrior : warriors) {
                // System.out.print("[" + warrior.cur.r + ", " + warrior.cur.c + "] -> ");
                warrior.moveFirst();
                // System.out.print("[" + warrior.cur.r + ", " + warrior.cur.c + "] -> ");
                warrior.moveSecond();
                // System.out.println("[" + warrior.cur.r + ", " + warrior.cur.c + "]");
            }

            System.out.println(answer);
        }
    }

    public static boolean isBoundary(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }


    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}