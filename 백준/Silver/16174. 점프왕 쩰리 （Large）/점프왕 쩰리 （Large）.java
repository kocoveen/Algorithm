import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] map;
    static boolean[][] vis;

    static int[] dr = {1, 0};
    static int[] dc = {0, 1};

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        vis = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(0, 0, map[0][0]));
        vis[0][0] = true;
        while (!q.isEmpty()) {
            Info cur = q.poll();
            for (int i = 0; i < 2; i++) {
                int nr = cur.r + dr[i] * cur.d;
                int nc = cur.c + dc[i] * cur.d;
                if (n <= nr || n <= nc) continue;
                if (vis[nr][nc]) continue;
                if (nr == n-1 && nc == n-1) {
                    System.out.println("HaruHaru");
                    System.exit(0);
                }
                q.add(new Info(nr, nc, map[nr][nc]));
                vis[nr][nc] = true;
            }
        }
        System.out.println("Hing");
    }

    private static class Info {
        int r, c, d;
        public Info(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
}