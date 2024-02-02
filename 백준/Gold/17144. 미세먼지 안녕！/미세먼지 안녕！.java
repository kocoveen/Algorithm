import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static String[] line;
    static int R, C, T;
    static int[][] board;
    static int[] aPRows = new int[2]; // 공기청정기 행
    static Queue<Info> q = new LinkedList<>();
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static class Info {
        int r;
        int c;
        int amount;

        public Info(int r, int c, int amount) {
            this.r = r;
            this.c = c;
            this.amount = amount;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine().split(" ");
        R = Integer.parseInt(line[0]);
        C = Integer.parseInt(line[1]);
        T = Integer.parseInt(line[2]);

        board = new int[R][C]; int a = 0;
        for (int i = 0; i < R; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(line[j]);
                if (board[i][j] == -1) {
                    aPRows[a++] = i;
                }
            }
        }

        while (T-- > 0) {
            spread();
            ventilate();
        }

        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == -1) continue;
                sum += board[i][j];
            }
        }
        System.out.println(sum);
    }

    private static void ventilate() {
        // 반시계
        int north = aPRows[0];

        for (int r = north - 2; r >= 0; r--) {
            board[r + 1][0] = board[r][0];
        }

        for (int c = 1; c < C; c++) {
            board[0][c - 1] = board[0][c];
        }

        for (int r = 1; r <= north; r++) {
            board[r - 1][C - 1] = board[r][C - 1];
        }

        for (int c = C - 2; c >= 1; c--) {
            board[north][c + 1] = board[north][c];
        }
        board[north][1] = 0;

        //시계
        int south = aPRows[1];

        for (int r = south + 2; r < R; r++) {
            board[r - 1][0] = board[r][0];
        }

        for (int c = 1; c < C; c++) {
            board[R - 1][c - 1] = board[R - 1][c];
        }

        for (int r = R - 2; r >= south; r--) {
            board[r + 1][C - 1] = board[r][C - 1];
        }

        for (int c = C - 2; c >= 1; c--) {
            board[south][c + 1] = board[south][c];
        }
        board[south][1] = 0;
    }

    private static void spread() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] <= 0) continue;
                board[i][j] -= evaluateDust(i, j, board[i][j]);
            }
        }

        while (!q.isEmpty()) {
            Info d = q.remove();
            board[d.r][d.c] += d.amount;
        }
    }

    private static int evaluateDust(int r, int c, int curAmount) {
        int sum = 0;
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr < 0 || R <= nr || nc < 0 || C <= nc) continue;
            if (board[nr][nc] == -1) continue;
            q.add(new Info(nr, nc, curAmount / 5));
            sum += curAmount / 5;
        }
        return sum;
    }
}
