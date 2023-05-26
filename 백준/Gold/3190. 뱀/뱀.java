import java.io.*;
import java.util.*;

public class Main {
    static String[] l;

    static int N, K, L, T, D;

    static char[][] board;
    static int[][] info;

    static Queue<Pair> Q = new ArrayDeque<>();
    static List<Pair> S = new ArrayList<>();
    static Pair P;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(board[i], '.');

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            l = br.readLine().split(" ");
            int r = Integer.parseInt(l[0]) - 1;
            int c = Integer.parseInt(l[1]) - 1;
            board[r][c] = '@';
        }

        L = Integer.parseInt(br.readLine());
        info = new int[L][2];
        for (int i = 0; i < L; i++) {
            l = br.readLine().split(" ");
            info[i][0] = Integer.parseInt(l[0]);
            if (l[1].equals("L")) info[i][1] = 0;
            else info[i][1] = 1;
        }

        P = new Pair(0, 0);
        Q.add(P);
        S.add(P);
        board[0][0] = '*';
        int i = 0;

        while (true) {
            T++;
            Pair cur = Q.remove();
            int nr = cur.r + dr[D];
            int nc = cur.c + dc[D];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) break;
            if (board[nr][nc] == '*') break;
            if (board[nr][nc] == '.') {
                P = S.remove(0);
                board[P.r][P.c] = '.';
            }
            P = new Pair(nr, nc);
            Q.add(P);
            S.add(P);
            board[nr][nc] = '*';

            if (i < L && T == info[i][0]) {
                if (info[i++][1] == 0) D = (D + 3) % 4;
                else D = (D + 1) % 4;
            }

        }
        System.out.println(T);
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
