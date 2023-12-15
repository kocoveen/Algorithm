import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;

    static int[][] map;
    static Integer[][] cnt;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int m;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        cnt = new Integer[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt[0][0] = 1;
        int count = dp(m-1, n-1);
        System.out.println(count);
    }

    private static int dp(int r, int c) {
        if (r < 0 || m <= r || c < 0 || n <= c) {
            return 0;
        }

        if (cnt[r][c] != null) {
            return cnt[r][c];
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || m <= nr || nc < 0 || n <= nc) continue;
            if (map[nr][nc] <= map[r][c]) continue;
            sum += dp(nr, nc);
        }
        return cnt[r][c] = sum;
    }
}