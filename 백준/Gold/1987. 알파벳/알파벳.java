import java.io.*;

public class Main {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] board;
    static int n, m, mx;
    static boolean[] visit = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j) - 'A';
            }
        }

        dfs(0, 0, 0);
        System.out.println(mx);
    }

    private static void dfs(int r, int c, int count) {
        if (visit[board[r][c]]) {
            mx = Math.max(mx, count);
            return;
        }

        visit[board[r][c]] = true;
        for (int i = 0; i < 4; i++) {
            int nr = dr[i] + r;
            int nc = dc[i] + c;
            if (nr >= n || nr < 0 || nc >= m || nc < 0) continue;
            dfs(nr, nc, count + 1);
        }
        visit[board[r][c]] = false;
    }
}