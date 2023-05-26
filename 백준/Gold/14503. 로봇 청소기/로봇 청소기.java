import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static String[] l;
    
    static int N, M, R, C, D;
    static int cnt = 0;
    
    static int[][] board;
    static int[][] path;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static Queue<Pair> Q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        N = Integer.parseInt(l[0]);
        M = Integer.parseInt(l[1]);

        l = br.readLine().split(" ");
        R = Integer.parseInt(l[0]);
        C = Integer.parseInt(l[1]);
        D = Integer.parseInt(l[2]);

        board = new int[N][M];
        path = new int[N][M];
        for (int i = 0; i < N; i++) {
            l = br.readLine().split(" ");
            for (int j = 0; j < M; j++)
                board[i][j] = Integer.parseInt(l[j]);
        }

        Q.add(new Pair(R, C));
        board[R][C] = -1;
        path[R][C] = 1;
        Loop:
        while (true) {
            Pair cur = Q.remove();
            for (int i = 3; i >= 0; i--) {
                int nr = cur.r + dr[(i + D) % 4];
                int nc = cur.c + dc[(i + D) % 4];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (board[nr][nc] != 0) continue;
                Q.add(new Pair(nr, nc));
                board[nr][nc] = -1;
                path[nr][nc] = 1 + path[cur.r][cur.c];
                D = (i + D) % 4;
                continue Loop;
            }
            int nr = cur.r + dr[(2 + D) % 4];
            int nc = cur.c + dc[(2 + D) % 4];
            if (board[nr][nc] == 1) break;
            Q.add(new Pair(nr, nc));
        }

        for (int[] b : board)
            for (int i : b)
                if (i == -1) cnt++;

        System.out.println(cnt);
    }

    private static class Pair {
        int r;
        int c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}