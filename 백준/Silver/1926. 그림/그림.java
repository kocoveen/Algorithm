import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int count = 0; int max = 0;
        Queue<Pair> Q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && board[i][j] == 1) {
                    count++;
                    int size = 1;
                    Q.add(new Pair(i, j));
                    vis[i][j] = true;
                    while (!Q.isEmpty()) {
                        Pair cur = Q.remove();
                        for (int k = 0; k < 4; k++) {
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if (vis[nx][ny] || board[nx][ny] != 1) continue;
                            Q.add(new Pair(nx, ny));
                            size++;
                            vis[nx][ny] = true;
                        }
                    }
                    if (max < size)
                        max = size;
                }

            }
        }

        System.out.println(count);
        System.out.println(max);
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