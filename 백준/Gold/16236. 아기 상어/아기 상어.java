import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] board;
    static int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    static Pair init;
    static Whale whale = new Whale(2);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(split[j]);
                if (board[i][j] == 9) {
                    init = new Pair(i, j, 0);
                    board[i][j] = 0;
                }
            }
        }

        System.out.println(bfs(init));
    }

    public static int bfs(Pair start) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
            if (p1.d == p2.d) {
                if (p1.r == p2.r) {
                    return p1.c - p2.c;
                }
                return p1.r - p2.r;
            }
            return p1.d - p2.d;
        });

        Deque<Pair> d = new LinkedList<>();
        boolean[][] v = new boolean[n][n];

        d.offer(start);
        v[start.r][start.c] = true;
        while (!d.isEmpty()) {
            Pair cur = d.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dir[i][0];
                int nc = cur.c + dir[i][1];
                if (nr < 0 || n <= nr || nc < 0 || n <= nc) continue;
                if (v[nr][nc]) continue;
                if (board[nr][nc] > whale.lvl) continue;

                if (board[nr][nc] != 0 && board[nr][nc] < whale.lvl) {
                    pq.offer(new Pair(nr, nc, cur.d + 1));
                }

                d.offer(new Pair(nr, nc, cur.d + 1));
                v[nr][nc] = true;
            }
        }

        // 완전 탐색 후, 조건에 맞는 물고기의 위치만 가져오기
        if (!pq.isEmpty()) {
            Pair cur = pq.poll();
            board[cur.r][cur.c] = 0;
            whale.increaseExp();
            return cur.d + bfs(new Pair(cur.r, cur.c, 0));
        }
        return 0;
    }

    public static class Pair {
        int r, c, d;

        public Pair(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    public static class Whale {
        int lvl, exp;
        public Whale(int lvl) {
            this.lvl = lvl;
            this.exp = lvl;
        }

        public void increaseExp() {
            exp--;
            if (exp == 0) {
                levelUp();
            }
        }

        private void levelUp() {
            this.lvl += 1;
            this.exp = lvl;
        }
    }
}