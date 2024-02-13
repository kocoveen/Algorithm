import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int n, bmx, wmx;
    static List<Integer> black_idxs = new ArrayList<>();
    static List<Integer> white_idxs = new ArrayList<>();
    static boolean[][] isPlaced;
    static int[] dr = {1, -1, -1, 1};
    static int[] dc = {1, 1, -1, -1};

    public static void main(String[] args) throws IOException {
        n = read();

        for (int i = 0; i < n * n; i++) {
            int r = i / n;
            int c = i % n;
            if (read() == 1) {
                if ((r + c) % 2 == 0) black_idxs.add(i);
                else white_idxs.add(i);
            }
        }

        isPlaced = new boolean[n][n];
        black_backtracking(0, 0);
        white_backtracking(0, 0);
        System.out.println(bmx + wmx);
    }

    private static void black_backtracking(int depth, int cnt) {
        bmx = Math.max(bmx, cnt);

        if (depth == black_idxs.size()) return;

        int k = black_idxs.get(depth);
        int r = k / n;
        int c = k % n;

        if (canPlaced(r, c)) {
            isPlaced[r][c] = true;
            black_backtracking(depth + 1, cnt + 1);
            isPlaced[r][c] = false;
        }

        black_backtracking(depth + 1, cnt);
    }

    private static void white_backtracking(int depth, int cnt) {
        wmx = Math.max(wmx, cnt);

        if (depth == white_idxs.size()) return;

        int k = white_idxs.get(depth);
        int r = k / n;
        int c = k % n;

        if (canPlaced(r, c)) {
            isPlaced[r][c] = true;
            white_backtracking(depth + 1, cnt + 1);
            isPlaced[r][c] = false;
        }

        white_backtracking(depth + 1, cnt);
    }

    private static boolean canPlaced(int r, int c) {
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i] * len;
                int nc = c + dc[i] * len;
                if (nr < 0 || nc < 0 || n <= nr || n <= nc) continue;
                if (isPlaced[nr][nc]) return false;
            }
        }
        return true;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}