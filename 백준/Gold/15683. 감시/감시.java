import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] board;
    static int[][] vis;
    static List<Pair> L = new ArrayList<>(); //각 위치와 cctv type

    static int R, C;
    static int min = Integer.MAX_VALUE;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] l = br.readLine().split(" ");
        R = Integer.parseInt(l[0]);
        C = Integer.parseInt(l[1]);

        board = new int[R][C];
        vis = new int[R][C];

        for (int i = 0; i < R; i++) {
            l = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                int k = Integer.parseInt(l[j]);
                if (k >= 1) {
                    if (k < 6) L.add(new Pair(i, j, k));
                    board[i][j] = k;
                }
            }
        }

        func(0);
        System.out.println(min);
    }

    private static void func(int depth) {
        if (depth == L.size()) {
            min = Math.min(min, zeroCount());
            return;
        }

        Pair p = L.get(depth);
        for (int i = 0; i < 4; i++) {
            observe(p, i, 0);
            func(depth + 1);
            observe(p, i, 1);
        }
    }

    private static void observe(Pair p, int dir, int rev) {
        switch (p.type) {
            case 1 -> {
                bfs(p, dir, rev);
            }

            case 2 -> {
                bfs(p, dir, rev);
                bfs(p, dir + 2, rev);
            }

            case 3 -> {
                bfs(p, dir, rev);
                bfs(p, dir + 1, rev);
            }

            case 4 -> {
                bfs(p, dir, rev);
                bfs(p, dir + 1, rev);
                bfs(p, dir + 2, rev);
            }

            case 5 -> {
                bfs(p, dir, rev);
                bfs(p, dir + 1, rev);
                bfs(p, dir + 2, rev);
                bfs(p, dir + 3, rev);
            }
        }
    }

    private static void bfs(Pair p, int dir, int rev) {
        dir %= 4;
        int r = p.r;
        int c = p.c;
        while (true) {
            r += dx[dir];
            c += dy[dir];
            if (OOB(r, c) || board[r][c] == 6) return;
            if (board[r][c] != 0) continue;
            if (rev == 0)
                vis[r][c]++;
            else
                vis[r][c]--;
        }
    }

    private static boolean OOB(int r, int c) {
        return r < 0 || r >= R || c < 0 || c >= C;
    }

    private static int zeroCount() {
        int cnt = 0;
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (board[i][j] == 0 && vis[i][j] == 0) cnt++;
        return cnt;
    }

    private static class Pair {
        int r;
        int c;
        int type;

        public Pair(int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }
    }
}