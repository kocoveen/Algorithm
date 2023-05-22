import java.io.*;
import java.util.*;

public class Main {

    static String[] l;

    static int N, M, idx = 0;
    static int min = Integer.MAX_VALUE;

    static int[][] board;
    static int[][][] dist;
    static boolean[][] vis;

    static Queue<Pair> Q = new ArrayDeque<>();
    static List<Pair> L1 = new ArrayList<>();
    static List<Pair> L2 = new ArrayList<>();

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        N = Integer.parseInt(l[0]);
        M = Integer.parseInt(l[1]);

        board = new int[N][N];
        dist = new int[13][N][N];

        for (int k = 0; k < 13; k++) {
            int[][] distOfk = dist[k];
            for (int i = 0; i < N; i++) Arrays.fill(distOfk[i], -1);
        }

        for (int i = 0; i < N; i++) {
            l = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int k = Integer.parseInt(l[j]);
                if (k == 1) L1.add(new Pair(i, j));
                else if (k == 2) {
                    L2.add(new Pair(i, j));
                    dist[idx++][i][j] = 0;
                }
                board[i][j] = k;
            }
        }

        for (int k = 0; k < L2.size(); k++) DistOfK(k);

        func(0, 0, board);

        System.out.println(min);
    }

    private static void func(int depth, int s, int[][] prev) {
        if (depth == M) {
            int sum = 0;
            for (Pair e : L1) {
                if (prev[e.r][e.c] == -1) return;
                sum += prev[e.r][e.c];
            }
            min = Math.min(min, sum);
            return;
        }

        for (int i = s; i < L2.size(); i++) {
            int[][] next = depth == 0 ? dist[i] : minDist(prev, i);
            func(depth + 1, i + 1, next);
        }
    }

    private static int[][] minDist(int[][] prev, int index) {
        int[][] next = new int[N][N];
        for (int i = 0; i < N; i++) System.arraycopy(prev[i], 0, next[i], 0, N);
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                next[i][j] = Math.min(next[i][j], dist[index][i][j]);
        return next;
    }

    private static void DistOfK(int k) {
        vis = new boolean[N][N];
        Pair p = L2.get(k);
        Q.add(p);
        vis[p.r][p.c] = true;
        while (!Q.isEmpty()) {
            Pair cur = Q.remove();
            int d = dist[k][cur.r][cur.c];
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (vis[nr][nc]) continue;
                if (dist[k][nr][nc] == -1) dist[k][nr][nc] = d + 1;
                else dist[k][nr][nc] = Math.min(dist[k][nr][nc], d + 1);
                Q.add(new Pair(nr, nc));
                vis[nr][nc] = true;
            }
        }

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