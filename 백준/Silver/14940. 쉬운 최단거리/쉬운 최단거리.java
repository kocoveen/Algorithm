import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static String[] l;

    static int n, m;
    static Pair sp;

    static int[][] board;
    static int[][] vis;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        n = Integer.parseInt(l[0]);
        m = Integer.parseInt(l[1]);

        vis = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(vis[i], -1);

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            l = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(l[j]);
                if (board[i][j] == 2) {
                    sp = new Pair(i, j);
                    vis[i][j] = 0;
                }
                if (board[i][j] == 0) vis[i][j] = 0;
            }
        }

        Queue<Pair> Q = new ArrayDeque<>();
        Q.add(sp);
        while (!Q.isEmpty()) {
            Pair cur = Q.remove();
            int d = vis[cur.r][cur.c];
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (vis[nr][nc] != -1) continue;
                Q.add(new Pair(nr, nc));
                vis[nr][nc] = d + 1;
            }
        }

        for (int[] d : vis) {
            for (int i : d)
                sb.append(i).append(' ');
            sb.append('\n');
        }
        System.out.println(sb);
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