import java.io.*;
import java.util.*;

public class Main {

    static char[][] board = new char[12][6];
    static boolean[][] vis = new boolean[12][6];

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean isPuyo;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            String line = br.readLine();
            for (int j = 0; j < 6; j++)
                board[i][j] = line.charAt(j);
        }

        do {
            isPuyo = false;
            for (int i = 0; i < 6; i++)
                for (int j = 10; j >= 0; j--) {
                    int tmp = j;
                    while (tmp < 11 && board[tmp + 1][i] == '.') {
                        char a = board[tmp][i];
                        board[tmp][i] = board[tmp + 1][i];
                        board[tmp + 1][i] = a;
                        tmp++;
                    }
                }


            for (int i = 0; i < 12; i++)
                for (int j = 0; j < 6; j++)
                    if (!vis[i][j] && board[i][j] != '.')
                        findSamePuyo(i, j);

            if (isPuyo) ans++;
            visInit();
        } while (isPuyo);

        System.out.println(ans);
    }

    private static void visInit() {
        for (int i = 0; i < 12; i++)
            Arrays.fill(vis[i], false);
    }

    private static void findSamePuyo(int r, int c) {
        char color = board[r][c];

        Queue<Pair> Q = new ArrayDeque<>();
        List<Pair> L = new ArrayList<>();
        Q.add(new Pair(r, c));
        L.add(new Pair(r, c));
        vis[r][c] = true;
        while (!Q.isEmpty()) {
            Pair cur = Q.remove();
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (nr < 0 || nr >= 12 || nc < 0 || nc >= 6) continue;
                if(vis[nr][nc] || board[nr][nc] == '.' || board[nr][nc] != color) continue;
                Q.add(new Pair(nr, nc));
                L.add(new Pair(nr, nc));
                vis[nr][nc] = true;
            }
        }

        //Puyos pop
        if (L.size() >= 4) {
            isPuyo = true;
            for (Pair pair : L)
                board[pair.r][pair.c] = '.';
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