import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static int R, C, K, cnt;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static char[][] map;
    static boolean[][] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tkn = br.readLine().split(" ");
        R = Integer.parseInt(tkn[0]);
        C = Integer.parseInt(tkn[1]);
        K = Integer.parseInt(tkn[2]);

        map = new char[R][C];
        vis = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String ln = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = ln.charAt(j);
            }
        }

        vis[R - 1][0] = true;
        backtracking(R - 1, 0, 1);
        System.out.println(cnt);
    }

    private static void backtracking(int r, int c, int d) {
        if (d > K) return;
        if (0 == r && C - 1 == c) {
            if (d == K) cnt++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nc < 0 || R <= nr || C <= nc) continue;
            if (vis[nr][nc] || map[nr][nc] == 'T') continue;
            vis[nr][nc] = true;
            backtracking(nr, nc, d + 1);
            vis[nr][nc] = false;
        }
    }
}