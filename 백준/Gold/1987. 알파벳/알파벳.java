import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int R, C, mx;
    static char[][] map;
    static boolean[] visited = new boolean[26];
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        R = Integer.parseInt(token[0]);
        C = Integer.parseInt(token[1]);

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        dfs(0, 0);
        System.out.println(mx);
    }

    private static void dfs(int r, int c) {
        visited[map[r][c] - 'A'] = true;
        mx = Math.max(mx, count(visited));
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || R <= nr || nc < 0 || C <= nc) continue;
            if (visited[map[nr][nc] - 'A']) continue;
            visited[map[nr][nc] - 'A'] = true;
            dfs(nr, nc);
            visited[map[nr][nc] - 'A'] = false;
        }
    }

    private static int count(boolean[] visited) {
        int cnt = 0;
        for (boolean b : visited) if (b) cnt++;
        return cnt;
    }
}