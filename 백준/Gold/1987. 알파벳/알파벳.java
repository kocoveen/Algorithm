import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int R, C, mx;
    static char[][] map;
    static int visitedBit;
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
        int curVisitedBit = 1 << (map[r][c] - 'A');
        visitedBit |= curVisitedBit;
        mx = Math.max(mx, Integer.bitCount(visitedBit));
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || R <= nr || nc < 0 || C <= nc) continue;
            int nxtVisitedBit = 1 << (map[nr][nc] - 'A');
            if ((visitedBit & nxtVisitedBit) == nxtVisitedBit) continue;
            visitedBit |= nxtVisitedBit;
            dfs(nr, nc);
            visitedBit &= (~nxtVisitedBit);
        }
    }
}