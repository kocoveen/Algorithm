import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map, sum;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        m = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);
        map = new int[n][m];
        sum = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
//            String line = "0".repeat(n);
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
                sum[i][j] = Integer.MAX_VALUE;
            }
        }
        sum[0][0] = 0;

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(0, 0, 0));
        while (!q.isEmpty()) {
            Info cur = q.remove();

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (nr < 0 || n <= nr || nc < 0 || m <= nc) continue;

                if (sum[nr][nc] > cur.cnt + map[nr][nc]) {
                    sum[nr][nc] = cur.cnt + map[nr][nc];
                    q.add(new Info(nr, nc, sum[nr][nc]));
                }
            }
        }
        System.out.println(sum[n-1][m-1]);
    }

    static class Info {
        int r, c, cnt;

        public Info(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}