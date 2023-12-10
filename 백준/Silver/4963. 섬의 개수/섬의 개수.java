import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }

            int[][] map = new int[h][w];
            boolean[][] visit = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int islandCount = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (visit[i][j] || map[i][j] != 1) {
                        continue;
                    }
                    dfs(i, j, h, w, map, visit);
                    islandCount++;
                }
            }
            sb.append(islandCount).append('\n');
        }
        System.out.print(sb);
    }

    private static void dfs(int r, int c, int h, int w, int[][] map, boolean[][] visit) {
        Stack<Pair> s = new Stack<>();
        s.push(new Pair(r, c));
        visit[r][c] = true;

        int[] dr = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

        while (!s.isEmpty()) {
            Pair cur = s.pop();
            for (int i = 0; i < 8; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (nr < 0 || nr >= h || nc < 0 || nc >= w) {
                    continue;
                }
                if (visit[nr][nc] || map[nr][nc] == 0) {
                    continue;
                }

                s.push(new Pair(nr, nc));
                visit[nr][nc] = true;
            }
        }
    }

    private static class Pair {
        int r, c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}