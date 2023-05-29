import java.io.*;

public class Main {
    static String[] l;

    static int N, M, H;
    static int min = Integer.MAX_VALUE;

    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        N = Integer.parseInt(l[0]);
        M = Integer.parseInt(l[1]);
        H = Integer.parseInt(l[2]);

        board = new int[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            l = br.readLine().split(" ");
            int r = Integer.parseInt(l[0]);
            int c = Integer.parseInt(l[1]);
            board[r][c] = 1;

        }

        func(0, 0);
        if (min == Integer.MAX_VALUE) min = -1;
        System.out.println(min);

    }

    private static void func(int depth, int s) {
        if (depth > 3) return;

        if (check()) min = Math.min(min, depth);

        for (int i = s; i < (N - 1) * H; i++) {
            int r = i / (N - 1) + 1;
            int c = i % (N - 1) + 1;
            if (board[r][c] == 1 || adj(r, c)) continue;
            board[r][c] = 1;
            func(depth + 1, i + 1);
            board[r][c] = 0;
        }
    }

    private static boolean check() {
        for (int j = 1; j <= N; j++) {
            int cur = j;
            for (int i = 1; i <= H; i++) {
                if (board[i][cur - 1] == 1) cur--;
                else if (board[i][cur] == 1) cur++;
            }
            if (cur != j) return false;
        }
        return true;
    }

    private static boolean adj(int r, int c) {
        return board[r][c + 1] == 1 || board[r][c - 1] == 1;
    }

}