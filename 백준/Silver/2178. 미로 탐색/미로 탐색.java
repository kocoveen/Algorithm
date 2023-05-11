import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //
        int[][] board = new int[n][m];
        Integer[][] dis = new Integer[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++)
                board[i][j] = line.charAt(j) - '0';
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Pair> Q = new ArrayDeque<>();
        Q.add(new Pair(0, 0));
        dis[0][0] = 0;

        while (!Q.isEmpty()) {
            Pair cur = Q.remove();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (dis[nx][ny] != null || board[nx][ny] != 1) continue;
                Q.add(new Pair(nx, ny));
                dis[nx][ny] = dis[cur.x][cur.y] + 1;
            }
        }

        System.out.println(dis[n-1][m-1] + 1);
    }

    public static class Pair {
        Integer x;
        Integer y;

        public Pair(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }
    }
}