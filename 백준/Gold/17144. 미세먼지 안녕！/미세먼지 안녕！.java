import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static String[] split;

    static int[][] board;
    static int r, c, t;
    static List<int[]> cleaner = new ArrayList<>();
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static Deque<Dust> d = new LinkedList<>();
    static class Dust {
        int r, c, a;
        public Dust(int r, int c, int a) {
            this.r = r;
            this.c = c;
            this.a = a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        split = br.readLine().split(" ");
        r = Integer.parseInt(split[0]);
        c = Integer.parseInt(split[1]);
        t = Integer.parseInt(split[2]);

        board = new int[r][c];
        for (int i = 0; i < r; i++) {
            split = br.readLine().split(" ");
            for (int j = 0; j < c; j++) {
                board[i][j] = Integer.parseInt(split[j]);
                if (board[i][j] == -1) {
                    cleaner.add(new int[]{i, j});
                }
            }
        }

        while (t-- > 0) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (board[i][j] >= 5) {
                        spreadDust(i, j, board[i][j]);
                    }
                }
            }
            while (!d.isEmpty()) {
                Dust loc = d.pollFirst();
                board[loc.r][loc.c] += loc.a;
            }
            circulate();
        }

        int answer = 0;
        for (int[] b : board) {
            for (int i : b) {
                if (i != -1) {
                    answer += i;
                }
            }
        }
        System.out.println(answer);
    }

    private static void circulate() {
        for (int i = cleaner.get(0)[0] - 2; i >= 0; i--) {
            board[i + 1][0] = board[i][0];
        }

        for (int i = 1; i < c; i++) {
            board[0][i - 1] = board[0][i];
        }

        for (int i = 1; i <= cleaner.get(0)[0]; i++) {
            board[i - 1][c - 1] = board[i][c - 1];
        }

        for (int i = c - 2; i >= 1; i--) {
            board[cleaner.get(0)[0]][i + 1] = board[cleaner.get(0)[0]][i];
        }
        board[cleaner.get(0)[0]][cleaner.get(0)[1] + 1] = 0;
        //-------
        for (int i = cleaner.get(1)[0] + 2; i < r; i++) {
            board[i - 1][0] = board[i][0];
        }

        for (int i = 1; i < c; i++) {
            board[r - 1][i - 1] = board[r - 1][i];
        }

        for (int i = r - 2; i >= cleaner.get(1)[0]; i--) {
            board[i + 1][c - 1] = board[i][c - 1];
        }

        for (int i = c - 2; i >= 1; i--) {
            board[cleaner.get(1)[0]][i + 1] = board[cleaner.get(1)[0]][i];
        }
        board[cleaner.get(1)[0]][cleaner.get(1)[1] + 1] = 0;
    }

    private static void spreadDust(int r, int c, int a) {
        int spreadingDust = a / 5;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (isOverBoundary(nr, nc)) continue;
            if (isCleaner(nr, nc)) continue;
            d.offerLast(new Dust(nr, nc, spreadingDust));
            board[r][c] -= spreadingDust;
        }
    }

    private static boolean isCleaner(int nr, int nc) {
        for (int[] clean : cleaner) {
            if (clean[0] == nr && clean[1] == nc) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOverBoundary(int nr, int nc) {
        return nr < 0 || nr >= r || nc < 0 || nc >= c;
    }
}